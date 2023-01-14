<%@page import="java.sql.*, java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Registration for Academic year 2022-2023</title>
    </head>
    <body>
        <h1>Course Registration for Academic year 2022-2023</h1>
        <form action="registration.jsp" method="post">
            Reg. Number: <input type="text" name="regno"><br>
            Name: <input type="text" name="name"><br>
            <%
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "ananya1234!");
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("select * from courses");
                    while (rs.next()) {
            %>
                        <input type="text" name="course" value="<%=rs.getString("id")+rs.getString("name")+rs.getString("credits")%>"> <br>
                       
                           
                        
                        <%
                    }



                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        rs.close();
                        stmt.close();
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            %>
            <input type="submit" value="Register">
        </form>
            <%
                
        String choosencourse[] = request.getParameterValues("course");
        int cred=0;
        if (choosencourse != null && choosencourse.length != 0) {
        for (int i = 0; i < choosencourse.length; i++) {
            if(choosencourse[i]=="0"){
                cred=cred+0;
            }
            else if(choosencourse[i].contains("Python")==true){
                    cred=cred+4;
                }
                else if(choosencourse[i].contains("Blockchain")==true){
                    cred=cred+4;
                }
                else if(choosencourse[i].contains("Web Dev")==true){
                    cred=cred+4;
                }
                else if(choosencourse[i].contains("Java")==true){
                cred=cred+3;
            }
                
                else if(choosencourse[i].contains("C")==true){
                cred=cred+3;
            }
                else if(choosencourse[i].contains("Machine Learning")==true){
                cred=cred+3;
            }
                else if(choosencourse[i].contains("Big Data")==true){
                cred=cred+3;
            }
               
             
                else if(choosencourse[i].contains("IIP")==true){
                cred=cred+2;
            }
                 else if(choosencourse[i].contains("Literature")==true){
                cred=cred+2;
            }
                  else if(choosencourse[i].contains("STS")==true){
                cred=cred+2;
            }
            }
            
                
        
        
        if(cred<16){ %>
            <h1>Minimum number of credits to be taken is 16.</h1>
       <% }
        else if(cred>26){  %>
        <h1>Maximum number of credits to be taken is 26.</h1>
     <%   }
        else{
        String mycourses=Arrays.toString(choosencourse);
     
               
                
                try {
                    Connection conn1;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "ananya1234!");
                    PreparedStatement st = conn1
                   .prepareStatement("insert into studentcourse values(?, ?, ?)");
                    st.setString(1, request.getParameter("regno"));
            st.setString(2, request.getParameter("name"));
            //st.setString(3, request.getParameter("choosencourse"));
           st.setString(3, mycourses);
        st.executeUpdate();
            st.close();
            
            
            
        }catch(Exception e){
            System.out.println("ERROR : : "+e.getMessage());
        }  %>
        <h1>Successfully registered</h1>
        
        <h1><%=request.getParameter("regno")%></h1>
        <h1><%=request.getParameter("name")%></h1>
        <h1><%=choosencourse.length%></h1>
        <h1><%=cred%></h1>
     <%
        }  }    %>
    </body>
</html>
