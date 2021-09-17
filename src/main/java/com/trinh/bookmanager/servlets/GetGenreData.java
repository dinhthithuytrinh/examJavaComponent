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
import com.trinh.bookmanager.models.Genre;

/**
 * Servlet implementation class GetBookData
 */
@WebServlet("/getgenredata.do")
public class GetGenreData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetGenreData() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession();

		if (getServletConfig().getServletContext().getAttribute("BookDBManager") != null) {
			DBManager dbm = (DBManager) getServletConfig().getServletContext().getAttribute("BookDBManager");

			try {
				if (!dbm.isConnected()) {
					if (!dbm.openConnection())
						throw new IOException("Could not connect to database and open connection");
				}

				String query = "select * from LoaiSanPham order by MaLoaiSP ASC";

				ArrayList<Genre> allGenres = new ArrayList<Genre>();

				ResultSet rs = dbm.ExecuteResultSet(query);

				while (rs.next()) {
					Genre c = new Genre();

					c.setMaLoaiSP(rs.getString("MaLoaiSP"));
					c.setTenLoaiSP(rs.getString("TenLoaiSP"));

					allGenres.add(c);
				}
				s.setAttribute("genreData", allGenres);

			} catch (Exception ex) {
				throw new IOException("Query could not be executed to get all genres");
			}

			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			response.sendRedirect("Protected/listGenres.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}

	}

}
