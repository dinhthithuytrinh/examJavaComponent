package com.trinh.bookmanager.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trinh.bookmanager.models.DBManager;
import com.trinh.bookmanager.models.IConnectionBehavior;
import com.trinh.bookmanager.models.MySQLConnectionBehavior;

/**
 * Servlet implementation class ListAllBook
 */
@WebServlet("/listallbook.do")
public class ListAllBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListAllBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder("<html><body>");
		
		String uid = getServletContext().getInitParameter("dbuserid");
		String pwd = getServletContext().getInitParameter("dbuserpwd");
		String cat = getServletContext().getInitParameter("dbinitcat");
		
		IConnectionBehavior icb = new MySQLConnectionBehavior(uid, pwd, cat);
		System.out.println(icb.getConnectionDetails());
		System.out.println(icb.getConnectionURL());
		
		DBManager dbm = new DBManager(icb);
		
		try {
			if (!dbm.isConnected())
			{
				if (!dbm.openConnection())
					sb.append("Could not connect to Database");
			}
			
			sb.append("<table border=1>"
					+ "<tr><td>Id</td>"
					+ "<td>Ten SP</td>"
					+ "<td>Tac Gia</td>"
					+ "<td>Mo Ta</td>"
					+ "<td>Gia Tien</td>"
					+ "<td>Loai SP</td>"
					+ "<td>Anh Minh Hoa</td></tr>");
			String query = "select * from SanPham order by TenSP DESC";
			
			ResultSet rs = dbm.ExecuteResultSet(query);
			
			while (rs.next())
			{
				int id = rs.getInt("ID");
				String tenSP = rs.getString("TenSP");
				String tacGia = rs.getString("TacGia");
				String moTa = rs.getString("MoTa");
				int giaTien = rs.getInt("GiaTien");
				String maLoaiSP = rs.getString("MaLoaiSP");
				String anhMinhHoa = rs.getString("AnhMinhHoa");
				
				sb.append("<tr><td>" + id + "</td>"
						+ "<td>" + tenSP + "</td>"
						+ "<td>" + tacGia + "</td>"
						+ "<td>" + moTa + "</td>"
						+ "<td>" + giaTien + "</td>"
						+ "<td>" + maLoaiSP + "</td>" 
						+ "<td>" + anhMinhHoa + "</td></tr>");
			}
			sb.append("</table>");
		}
		catch (Exception ex)
		{
			sb.append("<h1>Error:" + ex.getMessage() + "</h1>");
		}
		sb.append("</body></html>");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
	}

	

}
