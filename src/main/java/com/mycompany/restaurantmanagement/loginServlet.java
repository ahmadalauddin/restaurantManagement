/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmad
 */
public class loginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();  
          
        String username=request.getParameter("username");  
        String password=request.getParameter("password");
        
        userData pd = validator.validate(username, password);
        
        if(pd.getStatus()){
                HttpSession session = request.getSession();
                session.setAttribute("name", pd.getName());
                      
                RequestDispatcher rd=request.getRequestDispatcher("Hrmanager.html");
                rd.forward(request,response);                
                               
            }
            
            else{
                out.print("Sorry username or password error");
                RequestDispatcher rd=request.getRequestDispatcher("Signin.html");  
                rd.include(request,response);
            }
            
     
         out.close();  
         
        
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
