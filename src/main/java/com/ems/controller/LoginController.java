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


@WebServlet("/Verifylogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DBServiceImpl service = new DBServiceImpl();
		service.connectDB();
		boolean status= service.verifyLogin( email, password);
		
		if(status) {
			
			 HttpSession session = request.getSession(true); //create session object
			 
			session.setMaxInactiveInterval(10); // after 10 sec session object automatic distroyed
			
		    session.setAttribute("email", email);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Registration.jsp");
					rd.forward(request, response);
			
		}else {
			
			request.setAttribute("error" , "Invalid username/password");
			
			RequestDispatcher rd =request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		}
	}

}
