<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book manager</title>
<style>
.l-main {
	max-width: 1024px;
	margin: 0 auto;
	padding: 50px 0;
}
</style>
</head>
<body>
	<c:import url="header.jsp"/>
	
	<main class="l-main">
	
		<h1>Access denied</h1>
		
	</main>

	<c:import url="footer.jsp">
		<c:param name="copyright" value="${initParam.copyright}" />
		<c:param name="webLink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>