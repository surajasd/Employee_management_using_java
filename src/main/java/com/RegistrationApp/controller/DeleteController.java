package com.RegistrationApp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RegistrationApp.model.DAOService;
import com.RegistrationApp.model.DAOServiceImpl;


@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email = request.getParameter("emailId");
			DAOServiceImpl ser = new DAOServiceImpl();
			ser.connectDB();
			ser.delete(email);
			
			ResultSet res = ser.readAllReg();
			request.setAttribute("result", res);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/views/new_reg_list.jsp");
			rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
