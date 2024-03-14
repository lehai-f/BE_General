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
					<form:form action="save" class="d-flex row justify-content-center"
						method="POST" modelAttribute="formMay">
						<div class="col-4">
							<div class="mb-3">
								<label for="" class="form-label">Mã Máy</label>
								<form:input type="text" class="form-control" placeholder=""
									aria-describedby="helpId" path="maMay" />
								<form:errors id="helpId" class="text-danger" path="maMay"></form:errors>
							</div>
						</div>
						<div class="col-4">
							<div class="mb-3">
								<label for="" class="form-label">Vị Trí</label>
								<form:input type="text" class="form-control"
									aria-describedby="helpId" path="viTri" />
								<form:errors id="helpId" class="text-danger" path="viTri"></form:errors>
							</div>
						</div>
						<div class="col-4">
							<div class="mb-3">
								<label for="" class="form-label">Trang Thai</label>
								<form:select path="trangThai" class="form-select">
									<form:option value="" disabled="true" selected="true">Select one</form:option>
									<form:option value="ranh">Rảnh</form:option>
									<form:option value="ban">Bận</form:option>
								</form:select>
								<form:errors id="helpId" class="text-danger" path="trangThai"></form:errors>
							</div>
						</div>

						<c:if test="${not empty tontai}">
							<div class="error-message">
								<p class="text-danger">${tontai}</p>
							</div>
						</c:if>
						<button type="submit" class="col-2 btn btn-primary">Save KH</button>
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