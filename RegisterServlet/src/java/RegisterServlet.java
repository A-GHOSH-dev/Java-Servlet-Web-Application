/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


/**
 *
 * @author anany
 */
@WebServlet(name = "RegisterServletServlet", urlPatterns = {"/RegisterServletServlet"})
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
String name = request.getParameter("name");
String age = request.getParameter("age");

try {
// loading drivers for mysql
Class.forName("com.mysql.jdbc.Driver");
//creating connection with the database
Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Driver","root","ananya1234!");
Statement st = con.createStatement();
st.executeUpdate("insert into RegisterServlet(name, username)values('"+name+"','"+"','"+age+"')");
out.println("You are sucessfully registered");
}
catch(Exception e)
{
out.println(e);
}
}
}