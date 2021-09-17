package com.trinh.bookmanager.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trinh.bookmanager.models.WebUser;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tendangnhap");
		String matKhau = request.getParameter("matkhau");
		int authLevel = 1;

		WebUser wu = new WebUser();
		wu.setTenDangNhap(tenDangNhap);
		wu.setMatKhau(matKhau);
		wu.setAuthLevel(authLevel);

		HttpSession s = request.getSession();
		s.setAttribute("authorized_user", wu);

		if (request.getParameter("rememberMe") != null) {
			String rememberMe = request.getParameter("rememberMe");
			if (rememberMe.equalsIgnoreCase("ON")) {
				int cookieLife = 3600 * 24 * 7;

				Cookie tdnCook = new Cookie("credentials_tdn", tenDangNhap);
				tdnCook.setMaxAge(cookieLife);

				Cookie pwdCook = new Cookie("credentials_pwd", matKhau);
				pwdCook.setMaxAge(cookieLife);

				response.addCookie(tdnCook);
				response.addCookie(pwdCook);
			}
		}
		String target = (request.getParameter("dest") == null || request.getParameter("dest") == "") 
				? "index.jsp"
				: request.getParameter("dest") + ".jsp";

		response.sendRedirect(target);

	}

}
