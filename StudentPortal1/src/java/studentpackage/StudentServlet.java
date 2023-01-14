/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentpackage;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 *
 * @author anany
 */
@WebServlet(urlPatterns = { "/StudentServlet" })
public class StudentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
   response.setContentType("text/html;charset=UTF-8");
   PrintWriter out = response.getWriter();
        
         String name = request.getParameter("name");
        String regno = request.getParameter("regno");
        String choosencourse[] = request.getParameterValues("course");
        String mycourses=Arrays.toString(choosencourse);
//if (choosencourse != null && choosencourse.length != 0) {
    out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>You have selected the option is: </h1>");
          


    out.println("<h1>Servlet StudentServlet at " + request.getParameter(mycourses) + "</h1>");


  out.println("</body>");
  out.println("</html>");
//String mycourses=Arrays.toString(choosencourse);

        
 
        try{
            Connection con;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","ananya1234!");
            System.out.println("Connection");
            PreparedStatement st = con
                   .prepareStatement("insert into studentcourse values(?, ?, ?)");
            st.setString(1, request.getParameter("regno"));
            st.setString(2, request.getParameter("name"));
            //st.setString(3, request.getParameter("choosencourse"));
           st.setString(3, request.getParameter(mycourses));
            
            
            st.executeUpdate();
            st.close();
            
            
            
        }catch(Exception e){
            System.out.println("ERROR : : "+e.getMessage());
        }
        
      
   
        
        
        
        
        
   
        
    }
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


