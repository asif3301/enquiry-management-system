package com.ems.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ems.model.DBServiceImpl;


@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/Registration.jsp");
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name= request.getParameter("name");
		String course= request.getParameter("course");
		String email= request.getParameter("email");
		String mobile= request.getParameter("mobile");
			
		try {
		//Session Object being Accessed
		
		HttpSession session = request.getSession(false);
		
		session.setMaxInactiveInterval(10); // after 10 sec session object automatic distroyed
		
		// System.out.println(session.getAttribute("email"));
		 
		 
		 if(session.getAttribute("email")!=null) {
				
			
		 
		 // Using Session Object we will get user data from database
		 
		 DBServiceImpl service = new DBServiceImpl();
		 service.connectDB();
		 
		int userId = service.getUserByEmail((String)session.getAttribute("email"));
		System.out.println(userId);
		
		service.saveRegistration(name,course,email,mobile,userId);
		
		 }else {
			 
			 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
		 }
		
		}catch(Exception a) {
			request.setAttribute("error" , "Session Timeout Login Again"); 
			
			 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			
		}
		
		
	}
	}