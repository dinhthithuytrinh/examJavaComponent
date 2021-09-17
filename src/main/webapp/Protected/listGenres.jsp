<%@ page import="java.sql.*"%>
<%@ page import="com.trinh.bookmanager.dbmodels.*"%>
<%@ page import="com.trinh.bookmanager.servlets.*"%>
<%@ page import="com.trinh.bookmanager.helpers.*"%>
<%@ page import="com.trinh.bookmanager.models.*"%>
<%@ page import="java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List genres</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.l-main {
	max-width: 1024px;
	margin: 0 auto;
	padding: 50px 0;
}

.bg-dark {
	background-color: #343a40 !important;
}
table{
border-collapse: collapse;
}

.bg-dark th {
	border: 1px solid #fff;
	color: #fff;
	border-collapse: collapse;
	padding: 20px 10px;
}

td {
	border: 1px solid #fff;
    padding: 20px 10px;
    border-collapse: collapse;
    background: #ff9cae;
    color: #fff;
}
</style>
</head>
<body>
	<c:import url="../header.jsp" />
	<main class="l-main">
		<c:choose>
			<c:when test="${sessionScope.genreData == null}">
				<c:redirect url="../getgenredata.do" />
			</c:when>
			<c:otherwise>
				<h1>
					<c:out
						value="Welcome back ${sessionScope.authorized_user.tenTaiKhoan}" />
				</h1>
			</c:otherwise>
		</c:choose>



		<section class="ftco-section">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-5">
						<h2 class="heading-section">List genres</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div border="1" class="table-wrap">
							<table class="table table-dark">
								<thead>
									<tr class="bg-dark">
										<th>Mã loại SP</th>
										<th>Tên Loại SP</th>
										<th>Sửa</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="tempGenre" items="${sessionScope.genreData}"
										varStatus="iterationCount">
										<tr class="bg-primary">
											<td>${tempGenre.maLoaiSP}</td>
											<td>${tempGenre.tenLoaiSP}</td>
											<td><a href="#"><i class="fa fa-edit"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
	<c:import url="../footer.jsp">
		<c:param name="copyright" value="${initParam.copyright}" />
		<c:param name="webLink" value="${initParam.weblink}" />
	</c:import>

</body>
</html>