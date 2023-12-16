package com.RegistrationApp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.RegistrationApp.model.DAOServiceImpl;


@WebServlet("/allReg")
public class Registrationcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Registrationcontroller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(10);
		if(session.getAttribute("email")!=null) {
		DAOServiceImpl ser = new DAOServiceImpl();
		ser.connectDB();
		
		ResultSet res = ser.readAllReg();
		request.setAttribute("result", res);
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/views/new_reg_list.jsp");
		rd.forward(request, response);
		} else {
			request.setAttribute("msg", "Session Expired.Login Again!! ");
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			}
		} catch(Exception e) {
			request.setAttribute("msg", "Session Expired.Login Again!! ");
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	

}
