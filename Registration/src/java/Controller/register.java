/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.sql.*;
//import javax.servlet.annotation.WebServlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 *
 * @author anany
 */
//@WebServlet("/register")
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String idnumber = request.getParameter("idnumber");
        String emailid = request.getParameter("emailid");
        String phn = request.getParameter("phn");
        String categorystudent = request.getParameter("categorystudent");
        String categoryfaculty = request.getParameter("categoryfaculty");
        String categoryswe = request.getParameter("categoryswe");
        String designation = request.getParameter("designation");
        String affiliation = request.getParameter("affiliation");
        String fee = request.getParameter("fee");
        
        
        
        try{
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","ananya1234!");
            System.out.println("Connection");
            PreparedStatement st = con
                   .prepareStatement("insert into register values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, request.getParameter("name"));
            st.setString(2, request.getParameter("idnumber"));
            st.setString(3, request.getParameter("emailid"));
            st.setString(4, request.getParameter("phn"));
            st.setString(5, request.getParameter("categorystudent"));
            st.setString(6, request.getParameter("categoryfaculty"));
            st.setString(7, request.getParameter("categoryswe"));
            st.setString(8, request.getParameter("designation"));
            st.setString(9, request.getParameter("affiliation"));
            st.setString(10, request.getParameter("fee"));
            st.executeUpdate();
            st.close();
            
            
            
        }catch(Exception e){
            System.out.println("ERROR : : "+e.getMessage());
        }
        
      System.out.println(name+" "+idnumber+" "+fee);
      PrintWriter ps = response.getWriter();
      ps.print("name= "+name+"\n");
      ps.print("idnumber= "+idnumber+"\n");
      ps.print("fee= "+fee+"\n");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
