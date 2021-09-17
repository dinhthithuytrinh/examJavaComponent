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
import com.trinh.bookmanager.models.Book;

/**
 * Servlet implementation class GetBookData
 */
@WebServlet("/getbookdata.do")
public class GetBookData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetBookData() {
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

				String query = "select * from SanPham order by ID ASC";

				ArrayList<Book> allBooks = new ArrayList<Book>();

				ResultSet rs = dbm.ExecuteResultSet(query);

				while (rs.next()) {
					Book c = new Book();

					c.setID(rs.getInt("ID"));
					c.setTenSP(rs.getString("TenSP"));
					c.setTacGia(rs.getString("TacGia"));
					c.setMoTa(rs.getString("MoTa"));
					c.setNgayPhatHanh(rs.getDate("NgayPhatHanh"));
					c.setGiaTien(rs.getInt("GiaTien"));
					c.setMaLoaiSP(rs.getString("MaLoaiSP"));
					c.setAnhMinhHoa(rs.getString("AnhMinhHoa"));

					allBooks.add(c);
				}
				s.setAttribute("bookData", allBooks);

			} catch (Exception ex) {
				throw new IOException("Query could not be executed to get all books");
			}

			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			response.sendRedirect("Protected/listBooks.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}

	}

}
