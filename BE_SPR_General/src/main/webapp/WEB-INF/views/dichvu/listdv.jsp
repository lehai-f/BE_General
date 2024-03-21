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
			<h1 class="display-4">All Dịch Vụ</h1>
			<div class="card shadow">
				<h5 class="card-header font-weight-light">List DichVu</h5>
				<div class="card-body">
					<form action="${pageContext.request.contextPath}/dichvu/searchDV"
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
								<th class="col">Mã Dịch Vụ</th>
								<th class="col">Tên Dịch Vụ</th>
								<th class="col">Đơn Vị Tinh</th>
								<th class="col">Đơn Giá</th>
								<th class="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dv" items="${dvList}" varStatus="status">
								<tr>
									<td class="${dv.maDV} col">${dv.maDV}</td>
									<td class="ten${dv.maDV} col">${dv.tenDV}</td>
									<td class="dvt${dv.maDV} col">${dv.donViTinh}</td>
									<td class="dg${dv.maDV} col">${dv.donGia}</td>
									<td class="col-1"><a
										href="${pageContext.request.contextPath}/dichvu/update/${dv.maDV}"><i
											class="fa-solid fa-pen-to-square" style="color: #ffffff;"></i></a>
										<a href="javascript:void(0);"
										onclick="showConfirmation('${dv.maDV}')"
										data-bs-toggle="modal" data-bs-target="#confirmModal"><i
											class="fa-solid fa-trash-can" style="color: #ffffff;"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<c:if test="${ttPage > 0}">
						<nav aria-label="Page navigation" class="p-0">
							<ul class="pagination">
								<c:if test="${crPage > 0}">
									<li class="page-item"><a class="page-link bg-dark"
										href="listDV?page=${crPage-1}" aria-label="Next"> <span
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
												class="page-link bg-dark text-light" href="listDV?page=${i}">${i+1}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:if test="${crPage lt ttPage-1}">
									<li class="page-item"><a class="page-link bg-dark"
										href="listDV?page=${crPage+1}" aria-label="Next"> <span
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
	<!-- body-row END -->
	<!-- Modal form confirm -->
	<div class="modal fade" id="confirmModal" tabindex="-1"
		aria-labelledby="confirmModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header py-2 px-3">
					<h5 class="modal-title text-center" id="confirmModalLabel">Confirm
						Delete</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body py-2 px-3">
					<p class="m-0">Xác nhận xóa máy ?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary btn-sm"
						data-bs-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-dark btn-sm"
						onclick="confirmDel()">Confirm</button>
				</div>
			</div>
		</div>
	</div>



	<!-- Optional: Place to the bottom of scripts -->
	<script>
		const myModal = new bootstrap.Modal(document.getElementById('modalId'),
				options)
	</script>

	<script
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/menu1.js" />"></script>
	<script src="<c:url value="/resources/jQuery/jquery-3.7.0.min.js" />"></script>
	<script>
		function showConfirmation(id) {
			$('#confirmModal').modal('show');
			// Lưu ID vào biến toàn cục để sử dụng trong hàm confirmDelete()
			window.deleteId = id;
		}
		function confirmDel() {
			var id = window.deleteId;
			if (id) {
				window.location.href = "delete?id=" + id;
			}
			$('#confirmModal').modal('hide');
		}
	</script>
</body>

</html>