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
                 out.print("Student Data:");
       out.println("1, annu, 72372673, hagh@gmail.com, Student, VIT, 500");
       out.println("2, annu1, 72372673, hagh@gmail.com, Student, VIT, 500");
       out.print("3, annu2, 72378673, hagh@gmail.com, Student, VIT, 500");
      out.print("4, annu3, 72312673, hagh@gmail.com, Student, VIT, 500");
      out.print("5, annu5, 7239073, hagh@gmail.com, Student, VIT, 500");
       
           out.print("Faculty Data:");
      out.print("1, hvgc, 72372673, hagh@gmail.com, Faculty, VIT, 1000");
     out.print("2, cvahcv, 72372673, hagh@gmail.com, Faculty, VIT, 1000");
       out.print("3, acdbjsj, 72378673, hagh@gmail.com, Faculty, VIT, 1000");
       out.print("4, aeuwe, 72312673, hagh@gmail.com, Faculty, VIT, 1000");
       
       out.print("5, ajdjs, 7239073, hagh@gmail.com, Faculty, VIT, 1000");
       
                   out.print("SWE Data:");
      out.print("1, hvgcuyewu, 72372673, hagh@gmail.com, SWE, VIT, 2000");
       out.print("2, cvahc763bndsbv, 72372673, hagh@gmail.com, SWE, VIT, 2000");
      out.print("3, acdbjoauoauqesj, 72378673, hagh@gmail.com, SWE, VIT, 2000");
      out.print("4, aeusgdsgfwe, 72312673, hagh@gmail.com, SWE, VIT, 2000");
      out.print("5, ajdururi8js, 7239073, hagh@gmail.com, SWE, VIT, 2000");
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
        String designation = request.getParameter("designation");
        String affiliation = request.getParameter("affiliation");
        String fee = request.getParameter("fee");
        
        
        
        String namef = request.getParameter("namef");
        String idnumberf = request.getParameter("idnumberf");
        String emailidf = request.getParameter("emailidf");
        String phnf = request.getParameter("phnf");
        String designationf = request.getParameter("designationf");
        String affiliationf = request.getParameter("affiliationf");
        String feef = request.getParameter("feef");
        
        
        
        String names = request.getParameter("names");
        String idnumbers = request.getParameter("idnumbers");
        String emailids = request.getParameter("emailids");
        String phns = request.getParameter("phns");
        String designations = request.getParameter("designations");
        String affiliations = request.getParameter("affiliations");
        String fees = request.getParameter("fees");
        
        
        
        try{
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","ananya1234!");
            System.out.println("Connection");
            
            
            
            HttpSession session = request.getSession();

            
            
            
            
//            PreparedStatement st = con
//                   .prepareStatement("insert into register values(?, ?, ?, ?, ?, ?, ?)");
//            st.setString(1, request.getParameter("name"));
//            st.setString(2, request.getParameter("idnumber"));
//            st.setString(3, request.getParameter("emailid"));
//            st.setString(4, request.getParameter("phn"));
//            st.setString(5, request.getParameter("designation"));
//            st.setString(6, request.getParameter("affiliation"));
//            st.setString(7, request.getParameter("fee"));
//            st.executeUpdate();
//            st.close();
            
            PreparedStatement st = con
                   .prepareStatement("insert into register values(?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, (String)session.getAttribute("name"));
            st.setString(2, (String)session.getAttribute("idnumber"));
            st.setString(3, (String)session.getAttribute("emailid"));
            st.setString(4, (String)session.getAttribute("phn"));
            st.setString(5, (String)session.getAttribute("designation"));
            st.setString(6, (String)session.getAttribute("affiliation"));
            st.setString(7, (String)session.getAttribute("fee"));
            st.executeUpdate();
            st.close();
            
            
//            
//            PreparedStatement st1 = con
//                   .prepareStatement("insert into registerf values(?, ?, ?, ?, ?, ?, ?)");
//            st1.setString(1, request.getParameter("namef"));
//            st1.setString(2, request.getParameter("idnumberf"));
//            st1.setString(3, request.getParameter("emailidf"));
//            st1.setString(4, request.getParameter("phnf"));
//            st1.setString(5, request.getParameter("designationf"));
//            st1.setString(6, request.getParameter("affiliationf"));
//            st1.setString(7, request.getParameter("feef"));
//            st1.executeUpdate();
//            st1.close();
            
            
                  PreparedStatement st1 = con
                   .prepareStatement("insert into registerf values(?, ?, ?, ?, ?, ?, ?)");
            st1.setString(1, (String)session.getAttribute("namef"));
            st1.setString(2, (String)session.getAttribute("idnumberf"));
            st1.setString(3, (String)session.getAttribute("emailidf"));
            st1.setString(4, (String)session.getAttribute("phnf"));
            st1.setString(5, (String)session.getAttribute("designationf"));
            st1.setString(6, (String)session.getAttribute("affiliationf"));
            st1.setString(7, (String)session.getAttribute("feef"));
            st1.executeUpdate();
            st1.close();
            
            
//            PreparedStatement st2 = con
//                   .prepareStatement("insert into registers values(?, ?, ?, ?, ?, ?, ?)");
//            st2.setString(1, request.getParameter("names"));
//            st2.setString(2, request.getParameter("idnumbers"));
//            st2.setString(3, request.getParameter("emailids"));
//            st2.setString(4, request.getParameter("phns"));
//            st2.setString(5, request.getParameter("designations"));
//            st2.setString(6, request.getParameter("affiliations"));
//            st2.setString(7, request.getParameter("fees"));
//            st2.executeUpdate();
//            st2.close();
            
            
                 PreparedStatement st2 = con
                   .prepareStatement("insert into registers values(?, ?, ?, ?, ?, ?, ?)");
            st2.setString(1, (String)session.getAttribute("names"));
            st2.setString(2, (String)session.getAttribute("idnumbers"));
            st2.setString(3, (String)session.getAttribute("emailids"));
            st2.setString(4, (String)session.getAttribute("phns"));
            st2.setString(5, (String)session.getAttribute("designations"));
            st2.setString(6, (String)session.getAttribute("affiliations"));
            st2.setString(7, (String)session.getAttribute("fees"));
            st2.executeUpdate();
            st2.close();
            
               
      
            
        }catch(Exception e){
            System.out.println("ERROR : : "+e.getMessage());
        }
        
 
      PrintWriter ps = response.getWriter();
      
      
      ps.print("Student Data:");
       ps.print("1, annu, 72372673, hagh@gmail.com, Student, VIT, 500");
       ps.print("2, annu1, 72372673, hagh@gmail.com, Student, VIT, 500");
       ps.print("3, annu2, 72378673, hagh@gmail.com, Student, VIT, 500");
       ps.print("4, annu3, 72312673, hagh@gmail.com, Student, VIT, 500");
       ps.print("5, annu5, 7239073, hagh@gmail.com, Student, VIT, 500");
       
            ps.print("Faculty Data:");
       ps.print("1, hvgc, 72372673, hagh@gmail.com, Faculty, VIT, 1000");
       ps.print("2, cvahcv, 72372673, hagh@gmail.com, Faculty, VIT, 1000");
       ps.print("3, acdbjsj, 72378673, hagh@gmail.com, Faculty, VIT, 1000");
       ps.print("4, aeuwe, 72312673, hagh@gmail.com, Faculty, VIT, 1000");
       
       ps.print("5, ajdjs, 7239073, hagh@gmail.com, Faculty, VIT, 1000");
       
                   ps.print("SWE Data:");
       ps.print("1, hvgcuyewu, 72372673, hagh@gmail.com, SWE, VIT, 2000");
       ps.print("2, cvahc763bndsbv, 72372673, hagh@gmail.com, SWE, VIT, 2000");
       ps.print("3, acdbjoauoauqesj, 72378673, hagh@gmail.com, SWE, VIT, 2000");
       ps.print("4, aeusgdsgfwe, 72312673, hagh@gmail.com, SWE, VIT, 2000");
       ps.print("5, ajdururi8js, 7239073, hagh@gmail.com, SWE, VIT, 2000");
  
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
