package com.trinh.bookmanager.helpers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

import com.trinh.bookmanager.dbmodels.DBManager;
import com.trinh.bookmanager.dbmodels.IConnectionBehavior;
import com.trinh.bookmanager.dbmodels.MySQLConnectionBehavior;

/**
 * Application Lifecycle Listener implementation class DBManagerSetUp
 *
 */
@WebListener
public class DBManagerSetUp implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

	private DBManager dbm = null;

	public DBManagerSetUp() {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String uid = sce.getServletContext().getInitParameter("dbuserid");
		String pwd = sce.getServletContext().getInitParameter("dbuserpwd");
		String cat = sce.getServletContext().getInitParameter("dbinitcat");

		IConnectionBehavior icb = new MySQLConnectionBehavior(uid, pwd, cat);

		dbm = new DBManager(icb);
		sce.getServletContext().setAttribute("BookDBManager", dbm);
		System.out.println("BookDBManager has been created!");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (dbm != null) {
			if (dbm.isConnected())
				dbm.closeConnection(false);
		}
		dbm = null;
	}
}
