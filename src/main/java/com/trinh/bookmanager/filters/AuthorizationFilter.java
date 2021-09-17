package com.trinh.bookmanager.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trinh.bookmanager.models.WebUser;

@WebFilter("/Protected/*")
public class AuthorizationFilter implements Filter {
	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession s = req.getSession();

		String dest = req.getServletContext().getContextPath() + "/login.jsp";

		if (req.getRequestURI().toLowerCase().contains("cit")) {
			dest = dest + "?dest=Protected/listBooks.jsp";
		} else if (req.getRequestURI().toLowerCase().contains("books")) {
			dest = dest + "?dest=Protected/listBooks.jsp";
		}

		if (s.getAttribute("authorized_user") == null) {
			res.sendRedirect(dest);
			return;
		} else {
			WebUser wu = (WebUser) s.getAttribute("authorized_user");
			if (wu.getTenTaiKhoan() == null || wu.getTenTaiKhoan().equals("") || wu.getMatKhau() == null
					|| wu.getMatKhau().equals("")) {
				res.sendRedirect(dest);
				return;
			}
		}

		chain.doFilter(request, response);
	}
}
