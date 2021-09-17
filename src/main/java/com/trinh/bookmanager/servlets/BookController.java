package com.trinh.bookmanager.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 * Servlet implementation class Bookcontroller
 */
@WebServlet("/bookcontroller.do")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String theCommand = request.getParameter("command");

		if (theCommand == null) {
			theCommand = "LIST";
		}

		switch (theCommand) {
		case "DELETE":
			deleteBook(request, response);
			break;
		case "LOAD":
			loadBook(request, response);
			break;
		default:
			getBookData(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String theCommand = request.getParameter("command");

		if (theCommand == null) {
			theCommand = "LIST";
		}

		switch (theCommand) {
		case "ADD":
			addBook(request, response);
			break;
		case "UPDATE":
			updateBook(request, response);
			break;
		default:
			getBookData(request, response);
			break;
		}
	}

	private void getBookData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession s = request.getSession();

		if (getServletConfig().getServletContext().getAttribute("BookDBManager") != null) {
			DBManager dbm = (DBManager) getServletConfig().getServletContext().getAttribute("BookDBManager");

			try {
				if (!dbm.isConnected()) {
					if (!dbm.openConnection())
						throw new IOException("Could not connect to database and open connection");
				}

				String query = DBBookQueries.getBook();

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
					c.setAnhMinhHoa((rs.getString("AnhMinhHoa") == null || rs.getString("AnhMinhHoa").equals(""))
							? "default320x320.jpg"
							: rs.getString("AnhMinhHoa"));
					System.out.println(c);

					allBooks.add(c);
				}
				s.setAttribute("bookData", allBooks);
				System.out.println("finish getting bookData");

			} catch (Exception ex) {
				throw new IOException("Query could not be executed to get all bookses");
			}
			response.sendRedirect(getServletContext().getInitParameter("hostURL") + getServletContext().getContextPath()
					+ "/Protected/listBooks.jsp");
		} else {
			response.sendRedirect(getServletContext().getInitParameter("hostURL") + getServletContext().getContextPath()
					+ "login.jsp");
		}
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

					response.sendRedirect(getServletContext().getInitParameter("hostURL")
							+ getServletContext().getContextPath() + "/Protected/listBooks.jsp");
				} else {
					response.sendRedirect(getServletContext().getInitParameter("hostURL")
							+ getServletContext().getContextPath() + "login.jsp");
				}
			} catch (Exception ex) {
				response.sendRedirect(getServletContext().getInitParameter("hostURL")
						+ getServletContext().getContextPath() + "/errorHandler.jsp");
				System.out.println(ex.getMessage());
			}
		} catch (Exception e) {

		}
	}

	private void loadBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession s = request.getSession();
		String bookid = request.getParameter("bookId");

		if (getServletConfig().getServletContext().getAttribute("BookDBManager") != null) {
			DBManager dbm = (DBManager) getServletConfig().getServletContext().getAttribute("BookDBManager");

			try {
				if (!dbm.isConnected()) {
					if (!dbm.openConnection())
						throw new IOException("Could not connect to database and open connection");
				}

				String query = DBBookQueries.loadBook(bookid);

				Book theBook = new Book();

				ResultSet rs = dbm.ExecuteResultSet(query);

				while (rs.next()) {
					theBook.setID(rs.getInt("ID"));
					theBook.setTenSP(rs.getString("TenSP"));
					theBook.setTacGia(rs.getString("TacGia"));
					theBook.setMoTa(rs.getString("MoTa"));
					theBook.setNgayPhatHanh(rs.getDate("NgayPhatHanh"));
					theBook.setGiaTien(rs.getInt("GiaTien"));
					theBook.setMaLoaiSP(rs.getString("MaLoaiSP"));
					theBook.setAnhMinhHoa((rs.getString("AnhMinhHoa") == null || rs.getString("AnhMinhHoa").equals(""))
							? "default320x320.jpg"
							: rs.getString("AnhMinhHoa"));
					System.out.println();
				}
				s.setAttribute("theBook", theBook);
			} catch (Exception ex) {
				throw new IOException("Query could not be executed to get the book with given id");
			}
			response.sendRedirect(getServletContext().getContextPath() + "/Protected/updateBook.jsp");
		} else {
			response.sendRedirect(getServletContext().getContextPath() + "login.jsp");
		}
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
			/* String anhminhhoa = request.getParameter("anhMinhHoa"); */

			if (tensp == null || tensp.equals("") || tacgia == null || tacgia.equals("") || mota == null
					|| mota.equals("") || ngayphathanh == null || ngayphathanh.equals("") || giatien == null
					|| giatien.equals("") || maloaisp == null || maloaisp.equals("")) {

				response.sendRedirect(
						getServletContext().getInitParameter("hostURL") + getServletContext().getContextPath()
								+ "/bookcontroller.do?command=LOAD&bookId=" + request.getParameter("bookId"));
				return;
			}

			try {

				HttpSession s = request.getSession();
				Book tempBook = (Book) s.getAttribute("theBook");

				int id = Integer.parseInt(request.getParameter("bookId"));

				Book b = new Book();

				b.setID(id);
				b.setTenSP(tensp);
				b.setTacGia(tacgia);
				b.setMoTa(mota);
				b.setNgayPhatHanh(SQLDate);
				b.setGiaTien(Integer.parseInt(giatien));
				b.setMaLoaiSP(maloaisp);
				System.out.println(maloaisp);
				b.setAnhMinhHoa(tempBook.getAnhMinhHoa());
				System.out.println(tensp);

				if (getServletConfig().getServletContext().getAttribute("BookDBManager") != null) {
					DBManager dbm = (DBManager) getServletConfig().getServletContext().getAttribute("BookDBManager");

					try {
						if (!dbm.isConnected()) {
							if (!dbm.openConnection())
								throw new IOException("Could not connect to database and open connection");
							System.out.println("connect thanh cong");
						}

						String query = DBBookQueries.updateBook(b);
						System.out.println(query);
						dbm.ExecuteNonQuery(query);
						System.out.println("update thanh cong");
					} catch (Exception ex) {
						throw new IOException("Query could not be executed to update this book");
					}

					s.setAttribute("bookData", null);
					s.setAttribute("theBook", null);
					System.out.println("finish updating bookData");
					response.sendRedirect(getServletContext().getInitParameter("hostURL")
							+ getServletContext().getContextPath() + "/Protected/listBooks.jsp");
				} else {
					response.sendRedirect(getServletContext().getInitParameter("hostURL")
							+ getServletContext().getContextPath() + "login.jsp");
				}
			} catch (Exception ex) {
				response.sendRedirect(getServletContext().getInitParameter("hostURL")
						+ getServletContext().getContextPath() + "/errorHandler.jsp");
			}
		} catch (Exception e) {
			System.out.println("lỗi");
		}
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			String bookId = request.getParameter("bookId");

			if (getServletConfig().getServletContext().getAttribute("BookDBManager") != null) {
				DBManager dbm = (DBManager) getServletConfig().getServletContext().getAttribute("BookDBManager");

				try {
					if (!dbm.isConnected()) {
						if (!dbm.openConnection())
							throw new IOException("Could not connect to database and open connection");
					}

					String query = DBBookQueries.deleteBook(bookId);

					dbm.ExecuteNonQuery(query);
				} catch (Exception ex) {
					throw new IOException("Query could not be executed to delete this book");
				}

				HttpSession s = request.getSession();
				s.setAttribute("bookData", null);

				response.sendRedirect("Protected/listBooks.jsp");
				return;
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception ex) {
			response.sendRedirect(getServletContext().getContextPath() + "/errorHandler.jsp");
		}
	}

}
