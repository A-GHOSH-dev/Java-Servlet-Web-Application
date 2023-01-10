package driverpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

  import java.util.ArrayList;
/**
 * Servlet implementation class DriverServlet
 */
@WebServlet(description = "fetches user from system", urlPatterns = { "/DriverServlet" })
public class DriverServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        response.getWriter().append("<h1>DL CANCELLED</h1>").append(request.getParameter("userName")).append("<h5>Caught 3rd time</h5>"+formatter.format(date));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
        response.setContentType("text/html");

        ArrayList<User> list = UserSevice.getAllUsers();
        String userName = request.getParameter("userName");
        
        PrintWriter writer= response.getWriter();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
       // System.out.println(formatter.format(date));  
        //writer.print("<h1>Hello form "+ userName+ "</h1>");
        for(User u: list) {
            if(u.getName().equals(userName)) {
                if(u.getAge()<18) {
                    writer.print("<h1>You are not eligible for Driving</h1>");    
                }else {
                    int count=u.getViolations();
                    count++;
                    if(count>=3) {
                        System.out.println("DL cancelled");
                        writer.print("<h1>DL CANCELLED </h1>"+formatter.format(date) );
                    }else {
                        System.out.println("Not cancelled");
                        u.setViolations(count++);
                        writer.print("<h1>You have "+count + "violations</h1>");
                    }
                }
            }
        }
    }

}
