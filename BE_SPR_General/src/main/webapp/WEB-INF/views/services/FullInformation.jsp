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
<link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/resources/css/menu1.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/fontawesome/css/all.css'/>"
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
			<h1 class="display-4">All Customer</h1>
			<div class="card shadow">
				<h5 class="card-header font-weight-light">Requirements</h5>
				<div class="card-body">
					<form action="${pageContext.request.contextPath}/khachhang/search"
						class="mb-3">
						<div class="row m-0 justify-content-end">
							<div class="col-3">
								<input type="text" name="searchKey"
									class="form-control form-control-sm" placeholder="Tìm Kiếm"
									value="${searchKey}">
							</div>
							<button class="btn btn-dark btn-sm col-1" type="submit">Tìm
								kiếm</button>
						</div>
					</form>
					<table
						class="table table-hover table-dark table-striped text-center">
						<thead>
							<tr class="">
								<th class="col">Mã KH</th>
								<th class="col">Tên KH</th>
								<th class="col">Mã Máy</th>
								<th class="col">Vị Trí</th>
								<th class="col">Trạng Thái</th>
								<th class="col">Ngày BĐ SDM</th>
								<th class="col">TG SDM</th>
								<th class="col">Mã DV</th>
								<th class="col">Ngày SDDV</th>
								<th class="col">Giờ SDDV</th>
								<th class="col">SL</th>
								<th class="col">Tổng Tiền</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="info" items="${khList}" varStatus="status">
								<tr>
									<td class="col">${info.maKH}</td>
	 								<td class="col">${info.tenKH}</td>
									<td class="col">${info.maMay}</td>
									<td class="col">${info.viTri}</td>
									<td class="col">${info.trangThai}</td>
									<td class="col">${info.ngayBatDauSDMay}</td>
									<td class="col">${info.gioBatDauSDMay}</td>
									<td class="col">${info.thoiGianSDMay}</td>
									<td class="col">${info.maDV}</td>
									<td class="col">${info.ngaySuDungDV}</td>
									<td class="col">${info.soLuongSDDV}</td>
									<td class="col">${info.tongTien}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<c:if test="${ttPage > 0}">
						<nav aria-label="Page navigation" class="p-0">
							<ul class="pagination">
								<c:if test="${crPage > 0}">
									<li class="page-item"><a class="page-link bg-dark"
										href="list?page=${crPage-1}" aria-label="Next"> <span
											aria-hidden="true" class="text-light">&laquo;</span>
									</a></li>
								</c:if>
								<c:forEach begin="0" end="${ttPage-1}" var="i">
									<c:choose>
										<c:when test="${crPage eq i}">
											<li class="page-item" aria-current="page"><a
												class="page-link text-light active" href="#">${i+1}</a></li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a
												class="page-link bg-dark text-light"
												href="list?page=${i}">${i+1}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:if test="${crPage lt ttPage-1}">
									<li class="page-item"><a class="page-link bg-dark"
										href="list?page=${crPage+1}" aria-label="Next"> <span
											aria-hidden="true" class="text-light">&raquo;</span>
									</a></li>
								</c:if>
							</ul>
						</nav>
					</c:if>
					<c:if test="${ttPage == 0}">
						<p class="text-danger text-center fw-bold">Không có kết quả
							tìm kiếm.</p>
					</c:if>
				</div>
			</div>
		</div>
		<!-- Main Col END -->
	</div>

	<script
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/menu1.js" />"></script>
	<script src="<c:url value="/resources/jQuery/jquery-3.7.0.min.js" />"></script>
</body>

</html>