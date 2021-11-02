<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Add Book</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<!-- https://fonts.google.com/specimen/Roboto -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- https://fontawesome.com/ -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css"
	type="text/css">
<!-- http://api.jqueryui.com/datepicker/ -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- https://getbootstrap.com/ -->
<link rel="stylesheet" href="css/templatemo-style.css">

<style>
.l-main {
	max-width: 1024px;
	margin: 0 auto;
	padding: 50px 0;
}
/*

Product Admin CSS Template

https://templatemo.com/tm-524-product-admin

*/
html {
	font-size: 16px;
	overflow-x: hidden;
}

body {
	font-family: Roboto, Helvetica, Arial, sans-serif;
	overflow-x: hidden;
}

a {
	transition: all 0.3s ease;
}

a:focus, a:hover {
	text-decoration: none;
}

button:focus {
	outline: 0;
}

.navbar-brand {
	display: flex;
	align-items: center;
}

.tm-site-icon {
	color: #656565;
}

.tm-site-title {
	display: inline-block;
	text-transform: uppercase;
	font-size: 1.3rem;
	font-weight: 700;
	color: #fff;
}

.navbar {
	height: 100px;
	background-color: #567086;
	padding: 0;
}

.navbar .container {
	position: relative;
}

.tm-logout-icon {
	font-size: 1.5em;
}

.tm-mt-big {
	margin-top: 57px;
}

.tm-mb-big {
	margin-bottom: 60px;
}

.tm-mt-small {
	margin-top: 20px;
}

.tm-block-col {
	margin-bottom: 30px;
}

.tm-block {
	padding: 40px;
	-webkit-box-shadow: 1px 1px 5px 0 #455c71;
	-moz-box-shadow: 1px 1px 5px 0 #455c71;
	box-shadow: 1px 1px 5px 0 #455c71;
	min-height: 350px;
	height: 100%;
	max-height: 450px;
}

.tm-block-avatar, .tm-block-settings {
	max-height: none;
}

.tm-block-avatar {
	height: auto;
}

.tm-block-h-auto {
	min-height: 1px;
	max-height: none;
	height: auto;
}

.tm-block-scroll {
	overflow-y: scroll;
}

.tm-block-overflow {
	overflow: hidden;
}

.tm-block-title {
	font-size: 1.1rem;
	font-weight: 700;
	color: #fff;
	margin-bottom: 30px;
}

.nav-link {
	color: #fff;
	height: 100%;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	font-size: 90%;
}

.nav-link>i {
	margin-bottom: 10px;
	margin-right: 0;
	font-size: 1.5rem;
}

.dropdown-item, .nav-link {
	padding: 15px 20px;
}

.dropdown-menu {
	font-size: 90%;
	color: #fff;
	background-color: #567086;
	border-radius: 0;
	padding-top: 10px;
	padding-bottom: 10px;
	min-width: auto;
}

.dropdown-item {
	color: #fff;
	padding: 15px 30px;
}

.navbar-nav .active>.nav-link, .navbar-nav .nav-link.active {
	background-color: #ff9cae;
	color: #fff;
}

.navbar-nav .nav-link.active i {
	color: #fff;
}

.dropdown-item:focus, .dropdown-item:hover {
	background-color: #567086;
}

.navbar-nav a:hover, .navbar-nav a:hover i {
	color: #ff9cae;
}

.nav-item {
	text-align: center;
}

.nav-item:last-child {
	margin-right: 0;
}

.dropdown-toggle::after {
	display: none;
}

.dropdown-menu {
	margin-top: 0;
	border: 0;
}

.tm-content-row {
	justify-content: space-between;
	margin-left: -20px;
	margin-right: -20px;
}

.tm-col {
	padding-left: 20px;
	padding-right: 20px;
	margin-bottom: 50px;
}

.tm-col-big {
	width: 39%;
}

.tm-col-small {
	width: 21.95%;
}

.tm-gray-circle {
	width: 80px;
	height: 80px;
	background-color: #aaa;
	border-radius: 50%;
	margin-right: 15px;
}

.tm-notification-items {
	overflow-y: scroll;
	height: 90%;
}

.tm-notification-item {
	padding: 15px;
	background-color: #4e657a;
	color: #fff;
	font-size: 95%;
	margin-bottom: 15px;
}

.tm-notification-item:last-child {
	margin-bottom: 0;
}

.tm-notification-link {
	color: #ff9cae;
}

.tm-text-color-secondary {
	color: #bdcbd8;
}

.tm-small {
	font-size: 90%;
}

.table {
	background-color: #50697f;
	color: #fff;
	font-size: 85%;
	margin-bottom: 0;
}

thead {
	background-color: #486177;
	color: #fff;
}

.table thead th {
	border-bottom: 0;
}

.tm-status-circle {
	display: inline-block;
	margin-right: 5px;
	vertical-align: middle;
	width: 5px;
	height: 5px;
	border-radius: 50%;
	margin-top: -3px;
}

.moving {
	background-color: #9be64d;
	box-shadow: 0 0 8px #9be64d, inset 0 0 8px #9be64d;
}

.pending {
	background-color: #efc54b;
	box-shadow: 0 0 8px #efc54b, inset 0 0 8px #efc54b;
}

.cancelled {
	background-color: #da534f;
	box-shadow: 0 0 8px #da534f, inset 0 0 8px #da534f;
}

.tm-avatar {
	width: 345px;
}

.tm-avatar-container {
	position: relative;
	cursor: pointer;
	display: flex;
	align-items: center;
	flex-direction: column;
}

.tm-avatar-delete-link {
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -25px;
	margin-top: -25px;
	z-index: 1000;
	padding: 14px;
	border-radius: 50%;
	background-color: rgba(57, 78, 100, 0.7);
	display: inline-block;
	width: 50px;
	height: 50px;
	text-align: center;
	display: none;
	transition: all 0.2s ease;
}

.tm-avatar-container:hover .tm-avatar-delete-link {
	display: block;
}

.tm-col-avatar {
	max-width: 425px;
	width: 37%;
	padding-left: 15px;
	padding-right: 15px;
}

.tm-col-account-settings {
	max-width: 822px;
	width: 63%;
	padding-left: 15px;
	padding-right: 15px;
}

.form-control {
	background-color: #ff9cae;
	color: #fff;
	border: 0;
}

.form-control:focus {
	background-color: #fff;
	color: #343a40;
	border-color: transparent;
	box-shadow: 0 0 0 0.1rem rgb(180, 206, 233, 0.5);
}

.form-group label {
	color: #fff;
	margin-bottom: 10px;
}

.tm-hide-sm {
	display: block;
}

.tm-list-group {
	counter-reset: myOrderedListItemsCounter;
	padding-left: 0;
}

.tm-list-group>li {
	list-style-type: none;
	position: relative;
	cursor: pointer;
	transition: all 0.3s ease;
	padding: 8px;
}

.tm-list-group>li:hover {
	color: #0266c4;
}

.tm-list-group>li:before {
	counter-increment: myOrderedListItemsCounter;
	content: counter(myOrderedListItemsCounter) ".";
	margin-right: 0.5em;
}

.tm-list {
	padding-left: 30px;
}

.tm-list>li {
	margin-bottom: 20px;
}

.form-control {
	padding: 19px 18px;
	border-radius: 0;
	height: 50px;
}

.form-group {
	margin-bottom: 15px;
}

.btn {
	border-radius: 0;
	padding: 13px 28px;
	transition: all 0.2s ease;
	max-width: 100%;
}

.btn-small {
	padding: 10px 24px;
}

.btn-primary {
	color: #fff;
	background-color: #ff9cae;
	border: 2px solid #ff9cae;
	font-size: 90%;
	font-weight: 600;
}

.btn-primary:active, .btn-primary:hover {
	color: #ff9cae;
	background-color: transparent;
	border: 2px solid #ff9cae;
}

.custom-file-input {
	cursor: pointer;
}

.custom-file-label {
	border-radius: 0;
}

.table td, .table th {
	border-top: 1px solid #415a70;
	padding: 15px 25px;
	vertical-align: middle;
}

.tm-table-small td, .tm-table-small th {
	padding-left: 12px;
	padding-right: 12px;
}

.table-hover tbody tr {
	transition: all 0.2s ease;
}

.table-hover tbody tr:hover {
	color: #a0c0de;
}

.tm-bg-primary-dark {
	background-color: #343a40;
}

.tm-bg-gray {
	background-color: rgba(0, 0, 0, 0.05);
}

.tm-table-mt {
	margin-top: 66px;
}

.page-item:first-child .page-link {
	border-top-left-radius: 0;
	border-bottom-left-radius: 0;
}

.page-item:last-child .page-link {
	border-top-right-radius: 0;
	border-bottom-right-radius: 0;
}

.page-link {
	padding: 12px 18px;
}

.page-link, .page-link:hover {
	color: #000;
}

.page-item {
	margin-right: 18px;
}

.page-item:last-child {
	margin-right: 0;
}

.page-item.active .page-link {
	background-color: #e9ecef;
	border-color: #dee2e6;
	color: #000;
}

input[type="checkbox"] {
	cursor: pointer;
	-webkit-appearance: none;
	appearance: none;
	background-color: #394e64;
	background-position: center;
	border-radius: 50%;
	box-sizing: border-box;
	position: relative;
	box-sizing: content-box;
	width: 24px;
	height: 24px;
	transition: all 0.1s linear;
}

input[type="checkbox"]:checked {
	background: url(../img/check-mark.png) #394e64 center no-repeat;
}

input[type="checkbox"]:focus {
	outline: 0 none;
	box-shadow: none;
}

.tm-block-products {
	min-height: 725px;
}

.tm-block-product-categories {
	min-height: 650px;
}

.tm-product-table-container {
	max-height: 465px;
	margin-bottom: 15px;
	overflow-y: scroll;
}

.tm-product-table tr {
	font-weight: 600;
}

.tm-product-name {
	font-size: 0.95rem;
	font-weight: 600;
}

.tm-product-delete-icon {
	font-size: 1.1rem;
	color: #fff;
}

.tm-product-delete-link {
	padding: 10px;
	border-radius: 50%;
	background-color: #394e64;
	display: inline-block;
	width: 40px;
	height: 40px;
	text-align: center;
}

.tm-product-delete-link:hover .tm-product-delete-icon {
	color: #6d8ca6;
}

.custom-select {
	background-color: ff9cae !important;
	width: 100%;
	border: none;
	color: #fff;
	height: 50px;
	-webkit-appearance: none;
	-moz-appearance: none;
	-ms-appearance: none;
	-o-appearance: none;
	appearance: none;
	-webkit-border-radius: 0;
	-moz-border-radius: 0;
	-ms-border-radius: 0;
	-o-border-radius: 0;
	border-radius: 0;
	padding: 15px;
	background: url(../img/arrow-down.png) 98% no-repeat #50657b;
}

.custom-select:focus {
	outline: 0;
}

.tm-trash-icon {
	color: #6e6c6c;
	cursor: pointer;
}

.tm-trash-icon:hover {
	color: #9f1321;
}

.tm-footer {
	background-color: #567086;
	padding-top: 30px;
	padding-bottom: 30px;
	-webkit-box-shadow: 0 -3px 5px 0 rgba(69, 92, 113, 0.59);
	-moz-box-shadow: 0 -3px 5px 0 rgba(69, 92, 113, 0.59);
	box-shadow: 0 -3px 5px 0 rgba(69, 92, 113, 0.59);
}

.custom-select {
	height: 50px;
	border-radius: 0;
}

.tm-product-img-dummy {
	max-width: 100%;
	height: 427px;
	display: flex;
	align-items: center;
	justify-content: center;
	color: #fff;
	background: #aaa;
}
.tm-product-img-dummy img{
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.tm-product-img-edit {
	max-width: 100%;
	position: relative;
}

.tm-product-img-edit i {
	display: none;
	position: absolute;
}

.tm-product-img-edit:hover i {
	display: block;
}

.tm-upload-icon {
	background: #455c71;
	width: 55px;
	height: 55px;
	border-radius: 50%;
	text-align: center;
	padding-top: 15px;
	font-size: 22px;
}

.tm-login-col {
	max-width: 470px;
}

.navbar-toggler {
	border-color: #708da8;
	box-shadow: rgba(255, 255, 255, 0.1) 0 1px 1px 2px;
	border-radius: 0;
	padding: 10px 15px;
	transition: all 0.2s ease;
}

.navbar-toggler:hover {
	border-color: #ff9cae;
	color: #ff9cae;
}

.tm-nav-icon {
	color: #fff;
}

.navbar-toggler:hover .tm-nav-icon {
	color: #ff9cae;
}

::-webkit-scrollbar {
	width: 8px;
	height: 8px;
}

::-webkit-scrollbar-track {
	background: #394f62;
}

::-webkit-scrollbar-thumb {
	background: #6d8da6;
}

::-webkit-scrollbar-thumb:hover {
	background: #8ab5d6;
}

.tm-footer-link {
	color: white;
}

.tm-footer-link:hover, .tm-footer-link:focus {
	color: #aacbea;
}
.mb-00{
	margin-bottom: 0px;
}
</style>
</head>
<body>
	<c:import url="../header.jsp" />
	<main class="l-main">
		<c:choose>
			<c:when test="${sessionScope.MaLoaiSP == null}">
				<c:redirect url="../getgenrebook.do" />
			</c:when>
			<c:otherwise>
				<h1>
					<c:out value="Welcome back ${sessionScope.authorized_user.tenTaiKhoan}" />
				</h1>
			</c:otherwise>
		</c:choose>

		<div class="container tm-mt-big tm-mb-big">
			<div class="row">
				<div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
					<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
						<div class="row">
							<div class="col-12">
								<h2 class="tm-block-title d-inline-block">Add Book</h2>
							</div>
						</div>

						<form method="post" action="../bookcontroller.do"
							class="tm-edit-product-form">
							<input type="hidden" name="command" value="UPDATE" />
							<input type="hidden" name="bookId" value="${theBook.ID}" />
							<div class="row tm-edit-product-row">
								<div class="col-xl-6 col-lg-6 col-md-12">
									<div class="form-group mb-3">
										<label for="name">Tên Sản Phẩm </label> 
										<input id="tenSP"
											name="tenSP" type="text" value="${theBook.tenSP}" class="form-control validate" >
										<label for="name">Tác giả </label> 
										<input id="tacgia"
											name="tacGia" type="text" value="${theBook.tacGia}" class="form-control validate">
									</div>
									<div class="form-group mb-3">
										<label for="description">Mô tả</label>
										<textarea name="moTa" class="form-control" rows="3">
										${theBook.moTa}
										</textarea>
									</div>
									<div class="form-group mb-3">
										<label for="category">Loại sách</label> 
										<select
											name="maLoaiSP" class="custom-select tm-select-accounts"
											id="category">
											<option selected>${theBook.maLoaiSP}</option>
											<c:forEach items="${sessionScope.maLoaiSP}" var="maLoai">
												<option>${maLoai}</option>
											</c:forEach>
										</select>
									</div>
									<div class="row">
										<div class="form-group mb-3 col-xs-12 col-sm-6">
											<label for="expire_date">Ngày Phát hành </label> 
											<input
												id="dateTime" name="ngayPhatHanh" type="text"
												value="${theBook.ngayPhatHanh}"
												class="form-control validate hasDatepicker"
												data-large-mode="true">
										</div>
										<div class="form-group mb-3 col-xs-12 col-sm-6">
											<label for="stock">Giá Tiền </label> 
											<input id="stock"
												   name="giaTien" 
												   type="text" 
												   value="${theBook.giaTien}"
												   class="form-control validate">
										</div>
									</div>


								</div>
								<div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
									<div class="form-group mb-00">
										<label for="name">Ảnh Minh Họa</label> 
									</div>
									<div class="tm-product-img-dummy mx-auto">
										<img alt="NONE" src="${initParam.hostURL}${pageContext.request.contextPath}/FileDisplayServlet/${theBook.anhMinhHoa}">
									</div>
									<div class="custom-file mt-3 mb-3">
										<a class="btn btn-primary btn-block mx-auto" href="${initParam.hostURL}${pageContext.request.contextPath}/uploader.jsp">Change</a>
									</div>
								</div>
								<div class="col-12">
									<button name="updateBook" type="submit" class="btn btn-primary btn-block text-uppercase">Update Sách</button>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</main>
	<c:import url="../footer.jsp">
		<c:param name="copyright" value="${initParam.copyright}" />
		<c:param name="webLink" value="${initParam.weblink}" />
	</c:import>

</body>
</html>