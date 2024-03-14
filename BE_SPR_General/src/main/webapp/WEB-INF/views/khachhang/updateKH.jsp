<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!doctype html>
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS v5.2.1 -->
<link
	href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet">
<link href="<c:url value='/resources/css/menu1.css' />" rel="stylesheet">
<link href="<c:url value='/resources/fontawesome/css/all.css' />"
	rel="stylesheet">

</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- Bootstrap row -->
	<div class="row" id="body-row">
		<!-- Seitenleiste -->
		<jsp:include page="../leftmenu.jsp"></jsp:include>
		<!-- Seitenleiste-container END -->
		<!-- MAIN -->
		<div class="col p-4">
			<h1 class="display-4">Add New Customer</h1>
			<div class="card shadow">
				<h5 class="card-header font-weight-light">Requirements</h5>
				<div class="card-body">
					<form:form action="${pageContext.request.contextPath}/khachhang/update" class="d-flex row justify-content-center"
						method="POST" modelAttribute="khFormUD">
						<div class="col-4">
							<div class="mb-3">
								<label for="" class="form-label">Mã Khách Hàng</label>
								<form:input type="hidden" name="maKH" id="maKH"
									class="form-control" placeholder="" aria-describedby="helpId"
									path="maKH" />
								<input type="text" name="displayMaKH" class="form-control"
									value="${maKH}" disabled="disabled" />
								<form:errors id="helpId" class="text-danger" path="maKH"></form:errors>
							</div>
						</div>
						<div class="col-4">
							<div class="mb-3">
								<label for="" class="form-label">Tên KH</label>
								<form:input type="text" name="" id="" class="form-control"
									placeholder="" aria-describedby="helpId" path="tenKH" />
								<form:errors id="helpId" class="text-danger" path="tenKH"></form:errors>
							</div>
						</div>
						<div class="col-4">
							<div class="mb-3">
								<label for="" class="form-label">Số Điện Thoại</label>
								<form:input type="text" name="" id="" class="form-control"
									placeholder="" aria-describedby="helpId" path="soDT" />
								<form:errors id="helpId" class="text-danger" path="soDT"></form:errors>
							</div>
						</div>
						<div class="col-6">
							<div class="mb-3">
								<label for="" class="form-label">Địa Chỉ Email</label>
								<form:input type="text" name="" id="" class="form-control"
									placeholder="" aria-describedby="helpId" path="email" />
								<form:errors id="helpId" class="text-danger" path="email"></form:errors>
							</div>
						</div>
						<div class="col-6">
							<div class="mb-3">
								<label for="" class="form-label">Địa Chỉ</label>
								<form:input type="text" name="" id="" class="form-control"
									placeholder="" aria-describedby="helpId" path="diaChi" />
								<form:errors id="helpId" class="text-danger" path="diaChi"></form:errors>
							</div>
						</div>
						<button type="submit" class="col-2 btn btn-success">Update KH</button>
					</form:form>
				</div>
			</div>
		</div>
		<!-- Main Col END -->
	</div>
	<!-- body-row END -->
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/menu1.js"/>"></script>
</body>

</html>