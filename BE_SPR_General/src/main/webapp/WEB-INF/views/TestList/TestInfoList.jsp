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
								<th class="col-1">MãKH</th>
								<th class="col-1">TênKH</th>
								<th class="col-1">MãMáy</th>
								<th class="col-1">ViTri</th>
								<th class="col-1">TT</th>
								<th class="col-1">NgàySDM</th>
								<th class="col-1">TGSDM</th>
								<th class="col-1">MãDV</th>
								<th class="col-1">NgàySDDV</th>
								<th class="col-1">GiờSDDV</th>
								<th class="col-1">SL</th>
								<th class="col-1">Tổng Tiền</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="info" items="${khList}" varStatus="status">
								<tr>
									<td class="col text-start">${info.maKH}</td>
									<td class="col text-start">${info.tenKH}</td>
									<td class="col" colspan="5">
										<div class="row m-0 p-0">
											<c:forEach var="sdm" items="${info.sdmList}">
												<!-- Render dữ liệu cho sử dụng máy -->
												<div class ="text-start" style="width: 20%">${sdm.maMay}</div>
												<div class ="text-start" style="width: 20%">${sdm.viTri}</div>
												<div class ="text-start" style="width: 20%">${sdm.trangThai}</div>
												<div class ="text-start" style="width: 20%">${sdm.ngaySD}</div>
												<div style="width: 20%">${sdm.thoiGianSD}</div>
											</c:forEach>
										</div>
									</td>
									<td class="col" colspan="4">
									<div class="row m-0 p-0 ">
											<c:forEach var="sddv" items="${info.sddvList}">
												<!-- Render dữ liệu cho sử dụng máy -->
												<div class ="text-start" style="width: 25%">${sddv.maDV}</div>
												<div class ="text-start" style="width: 25%">${sddv.ngaySD}</div>
												<div class ="text-start"style="width: 25%">${sddv.gioSD}</div>
												<div style="width: 25%">${sddv.soLuong}</div>
											</c:forEach>
										</div>
									</td>
									<td style="width: 20%">${info.tongTien}</td>
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
												class="page-link bg-dark text-light" href="list?page=${i}">${i+1}</a></li>
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