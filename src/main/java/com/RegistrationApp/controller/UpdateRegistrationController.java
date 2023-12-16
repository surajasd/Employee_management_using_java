package com.RegistrationApp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RegistrationApp.model.DAOServiceImpl;


@WebServlet("/update")
public class UpdateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateRegistrationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailId");
		String Phone = request.getParameter("mobile");
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", Phone);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Registration_update.jsp");
		rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
			DAOServiceImpl ser = new DAOServiceImpl();
			ser.connectDB();
			ser.updateRegistration(email, mobile);
			
			ResultSet res = ser.readAllReg();
			request.setAttribute("result", res);
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/views/new_reg_list.jsp");
			rd.forward(request, response);
	}

}
