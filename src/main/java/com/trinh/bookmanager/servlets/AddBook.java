package com.trinh.bookmanager.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trinh.bookmanager.dbmodels.DBManager;
import com.trinh.bookmanager.helpers.DBBookQueries;
import com.trinh.bookmanager.models.Book;

/**
 * Servlet implementation class AddNewBook
 */
@WebServlet("/addnewbook.do")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBook() {
		super();
		// TODO Auto-g enerated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String tensp = request.getParameter("tenSP");
			String tacgia = request.getParameter("tacGia");
			String mota = request.getParameter("moTa");
			String ngayphathanh = request.getParameter("ngayPhatHanh");

			// String date_p = request.getParameter("date_p");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			java.sql.Date SQLDate = new java.sql.Date(df.parse(ngayphathanh).getTime());

			System.out.println(SQLDate);
			String giatien = request.getParameter("giaTien");
			String maloaisp = request.getParameter("maLoaiSP");
			String anhminhhoa = request.getParameter("anhMinhHoa");

			if (tensp == null || tensp.equals("") || tacgia == null || tacgia.equals("") || mota == null
					|| mota.equals("") || ngayphathanh == null || ngayphathanh.equals("") || giatien == null
					|| giatien.equals("") || maloaisp == null || maloaisp.equals("") || anhminhhoa == null
					|| anhminhhoa.equals("")) {

				response.sendRedirect(getServletContext().getInitParameter("hostURL")
						+ getServletContext().getContextPath() + "/Protected/addBook.jsp");
			}

			try {
				System.out.println("chạy try");
				// DateFormat formatter;
				// formatter = new SimpleDateFormat("yyyy-MM-dd");
				Book b = new Book();
				b.setTenSP(tensp);
				b.setTacGia(tacgia);
				b.setMoTa(mota);
				b.setNgayPhatHanh(SQLDate);
				b.setGiaTien(Integer.parseInt(giatien));
				b.setMaLoaiSP(maloaisp);
				b.setAnhMinhHoa(anhminhhoa);
				System.out.println(SQLDate);
				if (getServletConfig().getServletContext().getAttribute("BookDBManager") != null) {
					DBManager dbm = (DBManager) getServletConfig().getServletContext().getAttribute("BookDBManager");

					try {
						System.out.println("chạy try 1");
						if (!dbm.isConnected()) {
							if (!dbm.openConnection())
								throw new IOException("Could not connect to database and open connection");
						}

						String query = DBBookQueries.insertBook(b);
						System.out.println(query);
						dbm.ExecuteNonQuery(query);
					} catch (Exception ex) {
						throw new IOException("Query could not be executed to insert a new book");

					}

					HttpSession s = request.getSession();
					s.setAttribute("bookData", null);

					response.sendRedirect(getServletContext().getContextPath() + "/Protected/listBooks.jsp");
				} else {
					response.sendRedirect("login.jsp");
				}
			} catch (Exception ex) {
				response.sendRedirect(getServletContext().getContextPath() + "/errorHandler.jsp");
				System.out.println(ex.getMessage());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
