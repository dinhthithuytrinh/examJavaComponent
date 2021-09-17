package com.trinh.bookmanager.servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trinh.bookmanager.dbmodels.DBManager;
import com.trinh.bookmanager.helpers.DBBookQueries;
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
		HttpSession s = request.getSession();
		WebUser wu = (WebUser) s.getAttribute("authorized_user");

		if (wu == null || wu.getTenTaiKhoan().equals("") || wu.getTenTaiKhoan() == null || wu.getAuthLevel() < 1) {
			String tenTaiKhoan = "";
			String matKhau = "";

			if (request.getParameter("tentaikhoan") != null)
				tenTaiKhoan = request.getParameter("tentaikhoan");

			if (request.getParameter("matkhau") != null)
				matKhau = request.getParameter("matkhau");

			if ((wu == null || wu.getTenTaiKhoan().equals("") || wu.getAuthLevel() < 1 || wu.getTenTaiKhoan() == null)
					&& (tenTaiKhoan != "" && matKhau != "")) {

				if (getServletConfig().getServletContext().getAttribute("BookDBManager") != null) {
					DBManager dbm = (DBManager) getServletConfig().getServletContext().getAttribute("BookDBManager");

					try {
						if (!dbm.isConnected()) {
							if (!dbm.openConnection())
								throw new IOException("Could not connect to database and open connection");
						}

						String query = DBBookQueries.getWebUserByUsernameAndPassword(tenTaiKhoan, matKhau);
						ResultSet rs = dbm.ExecuteResultSet(query);

						while (rs.next()) {
							wu = new WebUser();

							wu.setTenTaiKhoan(rs.getString("tenTaiKhoan"));
							wu.setMatKhau(rs.getString("matKhau"));
							wu.setAuthLevel(rs.getInt("authLevel"));

							s.setAttribute("authorized_user", wu);

							if (request.getParameter("rememberMe") != null) {
								String rememberMe = request.getParameter("rememberMe");
								if (rememberMe.equalsIgnoreCase("ON")) {
									int CookieLife = 3600 * 24 * 7;

									Cookie ttkCookie = new Cookie("credentials_ttk", tenTaiKhoan);
									Cookie pwdCookie = new Cookie("credentials_pwd", matKhau);

									ttkCookie.setMaxAge(CookieLife);
									pwdCookie.setMaxAge(CookieLife);

									response.addCookie(ttkCookie);
									response.addCookie(pwdCookie);
								}
							}
						}

					} catch (Exception ex) {
						System.out.println("Exception: " + ex.getMessage());
						response.sendRedirect(getServletContext().getContextPath() + "/loginError.jsp");
						return;
					}
				} else {
					response.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
				}
			}

			if (wu == null || wu.getTenTaiKhoan().equals("") || wu.getTenTaiKhoan() == null || wu.getAuthLevel() < 1) {
				response.sendRedirect(getServletContext().getContextPath() + "/loginError.jsp");
				return;
			}

		}

		String target = (request.getParameter("dest") == null || request.getParameter("dest") == "") ? "index.jsp"
				: request.getParameter("dest");

		response.sendRedirect(target);
	}

}
