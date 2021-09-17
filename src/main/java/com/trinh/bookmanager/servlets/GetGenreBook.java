package com.trinh.bookmanager.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trinh.bookmanager.dbmodels.DBManager;
import com.trinh.bookmanager.helpers.DBBookQueries;
import com.trinh.bookmanager.models.WebUser;

/**
 * Servlet implementation class GetGenreBook
 */
@WebServlet("/getgenrebook.do")
public class GetGenreBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetGenreBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession();

		if (s.getAttribute("authorized_user") == null) {
			response.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
			return;
		} else {
			WebUser wu = (WebUser) s.getAttribute("authorized_user");
			if (wu.getAuthLevel() < 2) {
				response.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
				return;
			}
		}

		if (getServletConfig().getServletContext().getAttribute("BookDBManager") != null) {
			DBManager dbm = (DBManager) getServletConfig().getServletContext().getAttribute("BookDBManager");

			try {
				if (!dbm.isConnected()) {
					if (!dbm.openConnection())
						throw new IOException("Could not connect to database and open connection");
				}

				String query = DBBookQueries.getGenreBook();

				ArrayList<String> allMaLoaiSP = new ArrayList<String>();

				ResultSet rs = dbm.ExecuteResultSet(query);

				while (rs.next()) {
					String m = rs.getString("MaLoaiSP");
					allMaLoaiSP.add(m);
				}

				s.setAttribute("MaLoaiSP", allMaLoaiSP);

			} catch (Exception ex) {
				throw new IOException("Query could not be executed to get book genre");
			}
			response.sendRedirect(getServletContext().getInitParameter("hostURL") + getServletContext().getContextPath()
					+ "Protected/addBook.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
