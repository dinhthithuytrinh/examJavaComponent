<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
<%@ page import="com.trinh.bookmanager.dbmodels.*"%>
<%@ page import="com.trinh.bookmanager.servlets.*"%>
<%@ page import="com.trinh.bookmanager.helpers.*"%>
<%@ page import="com.trinh.bookmanager.models.*"%>
<%@ page import="java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  overflow: hidden;
  background-color: #343a40;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: white;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ff9cae;
  color: black;
}

.header a.active {
  background-color: #ff9cae;
  color: white;
} 

.header-right {
  float: right;
}
.l-section{
max-width: 1024px;
	margin: 0 auto;
	}

</style>
</head>
<body>

<div class="header">
<div class="l-section">
  <a href="${initParam.hostURL}${pageContext.request.contextPath}/index.jsp" class="logo">BookManager</a>
  <div class="header-right">
    <a class="active" href="${initParam.hostURL}${pageContext.request.contextPath}/index.jsp">Home</a>
    <a href="${initParam.hostURL}${pageContext.request.contextPath}/Protected/listBooks.jsp">List San Pham</a>
    <a href="${initParam.hostURL}${pageContext.request.contextPath}/Protected/listGenres.jsp">List Loai SP</a>
    <a href="${initParam.hostURL}${pageContext.request.contextPath}/login.jsp">Login</a>
    <a href="#about">Register</a>
    <a href="${initParam.hostURL}${pageContext.request.contextPath}/invalidatesessionandremovecookies.do">Clear</a>
    <a href="${initParam.hostURL}${pageContext.request.contextPath}/signout.do">Sign out</a>
  </div>
  </div>
</div>

</body>
</html>