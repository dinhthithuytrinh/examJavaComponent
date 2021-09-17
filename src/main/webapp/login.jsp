<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
.l-main {
	max-width: 1024px;
	margin: 0 auto;
	padding: 50px 0;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

form {
	border: 3px solid #f1f1f1;
	width: 50%;
	margin: 0 auto;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: dodgerblue;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	display: block;
}

button:hover {
	opacity: 0.8;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

.container {
	padding: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body>
	<c:import url="header.jsp" />
	<main class="l-main">

		<form id="login" action="login.do" method="post">
			<div class="container">
				<label for="uname"><b>UserName</b></label>
				<input type="text"
					placeholder="Enter Username" name="tendangnhap"
					value="${cookie.credentials_tdn.value}" required> 
				<label for="psw"><b>Password</b></label>
				<input type="password" placeholder="Enter Password" name="matkhau"
					value="${cookie.credentials_pwd.value}" required> 
				<label> 
					<input
					type="checkbox" checked="checked" name="rememberMe">
					Remember me
				</label>
				<button type="submit">Login</button>
			</div>
			<input type="hidden" name="dest" value="${param.dest}"/>
		</form>
	</main>

	<c:import url="footer.jsp">
		<c:param name="copyright" value="${initParam.copyright}" />
		<c:param name="webLink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>