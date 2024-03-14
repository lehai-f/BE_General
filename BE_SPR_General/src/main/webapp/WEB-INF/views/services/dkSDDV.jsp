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
			<h1 class="display-4">Add New UseComputer</h1>
			<div class="card shadow">
				<h5 class="card-header font-weight-light">Requirements</h5>
				<div class="card-body ">
					<form:form action="saveSDMay"
						class="d-flex row justify-content-center" method="POST"
						modelAttribute="dkSDDVForm">
						<div class="col-4">
							<div class="mb-3">
								<label for="" class="form-label">Mã Khách Hàng</label>
								<form:select path="maKH" class="form-select">
									<form:option value="" disabled="true" selected="true">Chọn ID KH</form:option>
									<form:options items="${listKH}" itemValue="maKH" itemLabel="maKH"></form:options>
								</form:select>
								<form:errors class="text-danger" path="maKH"></form:errors>
							</div>
						</div>

						<div class="col-4">
							<div class="mb-3">
								<label for="" class="form-label">Mã DV</label>
								<form:select path="maDV" class="form-select">
									<form:option value="" disabled="true" selected="true">Chọn ID DV</form:option>
									<form:options items="${listDV}" itemValue="maDV"
										itemLabel="maDV" />
								</form:select>
								<form:errors id="helpId" class="text-danger" path="maDV"></form:errors>
							</div>
						</div>

						<div class="col-4">
							<div class="mb-3">
								<label for="" class="form-label">Ngày Bắt Đầu Sử Dụng</label>
								<form:input type="date" name="" id="" class="form-control"
									placeholder="" aria-describedby="helpId"
									path="ngaySD" />
								<form:errors id="helpId" class="text-danger"
									path="ngaySD"></form:errors>
							</div>
						</div>

						<div class="col-6">
							<div class="mb-3">
								<label for="" class="form-label">Giờ Bắt Đầu Sử Dụng</label>
								<form:input type="time" class="form-control"
									path="gioSD" />
								<form:errors class="text-danger" path="gioSD"></form:errors>
							</div>
						</div>

						<div class="col-6">
							<div class="mb-3">
								<label for="" class="form-label">So Luong</label>
								<form:input type="text" name="" id="" class="form-control"
									placeholder="" aria-describedby="helpId" path="soLuong" />
								<form:errors id="helpId" class="text-danger" path="soLuong"></form:errors>
							</div>
						</div>
						<c:if test="${not empty tontai}">
							<div class="error-message">
								<p class="text-danger">${tontai}</p>
							</div>
						</c:if>
						<button type="submit" class="col-2 btn btn-primary">Lưu
							Thông Tin</button>
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