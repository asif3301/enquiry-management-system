package com.ems.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import com.ems.model.DBServiceImpl;


@WebServlet("/ReadRegistrationController")
public class ReadRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadRegistrationController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			
		
		//Session Object being Accessed
		
				HttpSession session = request.getSession(false);
				
				session.setMaxInactiveInterval(10); // after 10 sec session object automatic distroyed
				
				System.out.println(session.getAttribute("email"));
				
				
				 // Using Session Object we will get user data from database
				if(session.getAttribute("email")!=null) {
					
				
				 DBServiceImpl service = new DBServiceImpl();
				 service.connectDB();
				 
				 int userId = service.getUserByEmail((String)session.getAttribute("email"));
				 
					System.out.println(userId);
					
				ResultSet result =	service.getRegistrationByUserId(userId );
				
				request.setAttribute("res", result);
		
				RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
	           
				rd.forward(request, response);
				
				}else {
					
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				   
	            
	             } catch (Exception a) {
				  
					a.printStackTrace();
	             }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
