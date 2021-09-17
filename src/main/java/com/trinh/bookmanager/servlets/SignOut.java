package com.trinh.bookmanager.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignOut
 */
@WebServlet("/signout.do")
public class SignOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignOut() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession();
		s.invalidate();
		response.sendRedirect("index.jsp");
	}

}
