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
        <form action="submission.jsp" method="post">
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
        
    </body>
</html>