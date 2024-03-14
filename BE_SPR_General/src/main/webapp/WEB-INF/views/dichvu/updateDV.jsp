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
			<h1 class="display-4">Update DichVu</h1>
			<div class="card shadow">
				<h5 class="card-header font-weight-light">Form Update DichVu</h5>
				<div class="card-body">
					<form:form
						action="${pageContext.request.contextPath}/dichvu/update"
						class="d-flex row justify-content-center" method="POST"
						modelAttribute="formUpDV">
						<div class="col-3">
							<div class="mb-3">
								<label for="" class="form-label">Mã Dich Vu</label>
								<form:input type="hidden" class="form-control" path="maDV"
									required="true" value="${dv.maDV}"/>
								<input type="text" name="displayMaDV" class="form-control"
									value="${maDV}" disabled="disabled" />
								<form:errors class="text-danger" path="maDV"></form:errors>
							</div>
						</div>
						<div class="col-3">
							<div class="mb-3">
								<label for="" class="form-label">Ten Dich Vu</label>
								<form:input type="text" class="form-control" path="tenDV"
									required="true" />
								<form:errors class="text-danger" path="tenDV"></form:errors>
							</div>
						</div>
						<div class="col-3">
							<div class="mb-3">
								<label for="" class="form-label">Đơn Vị Tính</label>
								<form:input type="text" class="form-control" path="donViTinh"
									required="true" />
								<form:errors class="text-danger" path="donViTinh"></form:errors>
							</div>
						</div>
						<div class="col-3">
							<div class="mb-3">
								<label for="" class="form-label">Đơn Gia</label>
								<form:input type="text" class="form-control" path="donGia" />
								<form:errors class="text-danger" path="donGia"></form:errors>
							</div>
						</div>
						<c:if test="${not empty tontai}">
							<div class="error-message">
								<p class="text-danger">${tontai}</p>
							</div>
						</c:if>
						<button type="submit" class="col-2 btn btn-primary">Lưu
							DV</button>
					</form:form>
				</div>
			</div>
		</div>
		<!-- Main Col END -->
	</div>
	<!-- body-row END -->
	<script
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/menu1.js" />"></script>
</body>

</html>