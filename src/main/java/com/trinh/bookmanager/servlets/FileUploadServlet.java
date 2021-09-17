package com.trinh.bookmanager.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.trinh.bookmanager.models.Book;

@WebServlet("/fileuploadservlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 100 // 100MB
)
public class FileUploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();

		for (Part part : request.getParts()) {
			part.write(getServletContext().getInitParameter("uploadPath") + fileName);
		}

		HttpSession s = request.getSession();
		Book tempBook = (Book) s.getAttribute("theBook");
		tempBook.setAnhMinhHoa(fileName);

		s.setAttribute("theBook", tempBook);

		// response.getWriter().print(getServletContext().getInitParameter("uploadPath")
		// + fileName);
		response.sendRedirect(getServletContext().getInitParameter("hostURL") + getServletContext().getContextPath()
				+ "/Protected/updateBook.jsp");
	}
}
