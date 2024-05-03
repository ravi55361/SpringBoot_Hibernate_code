package com.registrationApp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registrationApp.model.DAOServiceImpl;

@WebServlet("/update")
public class EmailAndPhoneByUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmailAndPhoneByUpdateController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailId");
		String mobile = request.getParameter("mobileNo");
		System.out.println(email);
		System.out.println(mobile);
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/updateRegistration.jsp"); 
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email")!=null) {
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");

				DAOServiceImpl service = new DAOServiceImpl();
				service.connectDB();
				service.updateByEmailAndPhone(email,mobile);

				ResultSet res = service.readAllReg();

				request.setAttribute("res", res);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listRegistration.jsp"); 
				rd.forward(request, response);
			}else {
				request.setAttribute("msg", "Session Expired,Login Again!!!");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); 
				rd.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", "Session Expired,Login Again!!!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); 
			rd.forward(request, response);
		}

	}

}
