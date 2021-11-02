<%@ page import="java.sql.*"%>
<%@ page import="com.trinh.bookmanager.dbmodels.*"%>
<%@ page import="com.trinh.bookmanager.servlets.*"%>
<%@ page import="com.trinh.bookmanager.helpers.*"%>
<%@ page import="com.trinh.bookmanager.models.*"%>
<%@ page import="java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List books</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.l-main {
	max-width: 1024px;
	margin: 0 auto;
	padding: 50px 0;
}

.bg-dark {
	background-color: #343a40 !important;
}

table {
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

.btn-primary {
	color: #fff;
	background-color: #ff9cae;
	border: 2px solid #ff9cae;
	font-size: 90%;
	font-weight: 600;
	padding: 10px;
	text-decoration: none;
}

.btn-primary:active, .btn-primary:hover {
	color: #ff9cae;
	background-color: transparent;
	border: 2px solid #ff9cae;
}

td img {
	width: 100px
}
</style>
</head>
<body>
	<c:import url="../header.jsp" />
	<main class="l-main">
		<c:choose>
			<c:when test="${sessionScope.bookData == null}">
				<c:redirect url="../bookcontroller.do" />
			</c:when>
			<c:otherwise>
				<h1>
					<c:out
						value="Welcome back ${sessionScope.authorized_user.tenTaiKhoan}" />
				</h1>
			</c:otherwise>
		</c:choose>


		<c:if test="${sessionScope.authorized_user.authLevel eq 2}">
			<a class="btn-primary"
				href="${initParam.hostURL}${pageContext.request.contextPath}/Protected/addBook.jsp">Add
				book here</a>
		</c:if>

		<section class="ftco-section">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-5">
						<h2 class="heading-section">List books</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div border="1" class="table-wrap">
							<table class="table table-dark">
								<thead>
									<tr class="bg-dark">
										<th>ID</th>
										<th>Tên sản phẩm</th>
										<th>Tác giả</th>
										<th>Mô tả</th>
										<th>Ngày phát hành</th>
										<th>Giá tiền</th>
										<th>Mã Loại</th>
										<th>Ảnh minh họa</th>
										<c:if test="${sessionScope.authorized_user.authLevel eq 2}">
											<th>Chỉnh sửa</th>
											<th>Xóa</th>
										</c:if>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="tempBook" items="${sessionScope.bookData}"
										varStatus="iterationCount">
										<c:url var="updateLink"
											value="${initParam.hostURL}${pageContext.request.contextPath}/bookcontroller.do">
											<c:param name="command" value="LOAD" />
											<c:param name="bookId" value="${tempBook.ID}" />
										</c:url>
										<c:url var="deleteLink"
											value="${initParam.hostURL}${pageContext.request.contextPath}/bookcontroller.do">
											<c:param name="command" value="DELETE" />
											<c:param name="bookId" value="${tempBook.ID}" />
										</c:url>
										<tr class="bg-primary">
											<td>${tempBook.ID}</td>
											<td>${tempBook.tenSP}</td>
											<td>${tempBook.tacGia}</td>
											<td>${tempBook.moTa}</td>
											<c:set var="date" value="${tempBook.ngayPhatHanh}" />
											<td><fmt:formatDate value="${date}" pattern="dd/MM/yyyy" /></td>
											<c:set var="price" value="${tempBook.giaTien}" />
											<td><fmt:formatNumber type="number"
													maxFractionDigits="3" value="${price}" />VND</td>
											<td>${tempBook.maLoaiSP}</td>
											<td><img
												src="${initParam.hostURL}${pageContext.request.contextPath}/FileDisplayServlet/${tempBook.anhMinhHoa}"></td>
											
											<c:if test="${sessionScope.authorized_user.authLevel eq 2}">
												<td><a href="${updateLink}"><i class="fa fa-edit"></i></a></td>
												<td><a href="${deleteLink}"
												onclick="if(!confirm('Are you chắc chưa?')) return false;"><i
													class="fa fa-trash-o"></i></a></td>
											</c:if>
											
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