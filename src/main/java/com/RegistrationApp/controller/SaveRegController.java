package com.RegistrationApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.RegistrationApp.model.DAOServiceImpl;


@WebServlet("/saveReg")
public class SaveRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SaveRegController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/views/new_reg.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email")!=null) {
			String Name = request.getParameter("name");
			String City = request.getParameter("city");
			String Email = request.getParameter("email");
			String Phone = request.getParameter("mobile");
			
			DAOServiceImpl service = new DAOServiceImpl();
			service.connectDB();
			service.saveregister(Name, City, Email, Phone);
			request.setAttribute("msg", "Record saved");
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/views/new_reg.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "Session Expired.Login Again!! ");
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
			}
		}catch(Exception e) {
			request.setAttribute("msg", "Session Expired.Login Again!! ");
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
