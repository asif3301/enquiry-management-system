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


@WebServlet("/UpdateRegistrationController")
public class UpdateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateRegistrationController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	try {	
	   int id= Integer.parseInt(request.getParameter("id"));
	
	   DBServiceImpl service = new DBServiceImpl();
	   
	   service.connectDB();
	   
	  ResultSet result = service.getRegistrationById(id);
	
	  if(result.next()) {
	  request.setAttribute("id", result.getInt(1));
	  request.setAttribute("name", result.getString(2));
	  request.setAttribute("course", result.getString(3));
	  request.setAttribute("email", result.getString(4));
	  request.setAttribute("mobile", result.getString(5));
	
	  RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/update_registration.jsp");
	  
	rd.forward(request, response);
	
	
	  }
	
	}catch(Exception a) {
		a.printStackTrace();
	}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String course = request.getParameter("course");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		
		
		HttpSession session = request.getSession(false);
		
		DBServiceImpl service = new DBServiceImpl();
		
		service.connectDB();
		
		int userId = service.getUserByEmail((String)session.getAttribute("email"));
		
		String updateStatus = service.updateRegistrationData(id,name,course,email,mobile,userId);
		
		
		ResultSet result =	service.getRegistrationByUserId(userId );
		
		request.setAttribute("res", result);
        request.setAttribute("updateStatus", updateStatus);
		RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
       
		rd.forward(request, response);
			
		
		
		
		
	}

}
