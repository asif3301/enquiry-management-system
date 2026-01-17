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


@WebServlet("/DeleteRegistrationController")
public class DeleteRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteRegistrationController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		int id = Integer.parseInt(request.getParameter("id"));

		DBServiceImpl service = new DBServiceImpl();
		
		service.connectDB();
		
		service.deleteRegistrationById(id);
		
		HttpSession session = request.getSession(false);
		
		 int userId = service.getUserByEmail((String)session.getAttribute("email"));
		 
			System.out.println(userId);
			
		ResultSet result =	service.getRegistrationByUserId(userId );
		
		request.setAttribute("res", result);

		RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
    
		rd.forward(request, response);
			
		
		
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
