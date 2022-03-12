package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.UserDao;
import com.ty.dto.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDao dao = new UserDao();
		User user = dao.validateUser(email, password);
	
		if(user != null) {
			
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("userName", user.getName());
		
			RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
			dispatcher.forward(req, resp);
			
		} else {
			PrintWriter pw = resp.getWriter();
			pw.write("<html><body><h1> Sorry invalid user name or passowrd</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
			dispatcher.include(req, resp);
		}
	}
}
