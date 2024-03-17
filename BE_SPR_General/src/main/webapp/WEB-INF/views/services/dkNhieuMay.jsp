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
			<h1 class="display-4">Add New UseComputers</h1>
			<div class="card shadow">
				<div class="card-header d-flex justify-content-between align-items-center">
					<h5 class="font-weight-light m-0">${idKH}</h5>
					<button type="button" id="addMay" class="btn btn-sm btn-primary">+</button>
				</div>
				<div class="card-body">
					<form:form action="${pageContext.request.contextPath}/Services/saveNhieuMay"
						class="d-flex row justify-content-center" method="POST"
						modelAttribute="sudungMays">
						<form:input type="hidden" name="khachHangId" value="${idKH}" path="maKH"/>
						<div id="render">
							<c:forEach items="${sudungMays.listMay}" var="listMay"
								varStatus="status">
								<div class="sd-may row p-0">
									<div class="col-3">
										<div class="mb-3">
											<label for="" class="form-label">Mã Máy</label>
											<form:select path="listMay[${status.index}].maMay"
												class="form-select">
												<form:option value="" disabled="true" selected="true">Chọn ID May</form:option>
												<form:options items="${listMM}" />
											</form:select>
											<form:errors id="helpId" class="text-danger"
												path="listMay[${status.index}].maMay"></form:errors>
										</div>
									</div>

									<div class="col-3">
										<div class="mb-3">
											<label for="" class="form-label">Ngày SD:</label>
											<form:input type="date" id="ngaySD_${status.index}"
												class="form-control" path="listMay[${status.index}].ngaySD" />
											<form:errors id="helpId" class="text-danger"
												path="listMay[${status.index}].ngaySD"></form:errors>
										</div>
									</div>

									<div class="col-3">
										<div class="mb-3">
											<label for="" class="form-label">Giờ SD:</label>
											<form:input type="time" id="gioSD_${status.index}"
												class="form-control" path="listMay[${status.index}].gioSD" />
											<form:errors id="helpId" class="text-danger"
												path="listMay[${status.index}].gioSD"></form:errors>
										</div>
									</div>

									<div class="col-3">
										<div class="mb-3">
											<label for="" class="form-label">TG SD:</label>
											<form:input type="number" id="thoiGianSD_${status.index}"
												class="form-control"
												path="listMay[${status.index}].thoiGianSD" />
											<form:errors id="helpId" class="text-danger"
												path="listMay[${status.index}].thoiGianSD"></form:errors>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<button type="submit" class="col-2 btn btn-primary">Add
							Nhieu May</button>
					</form:form>
				</div>
			</div>
		</div>
		<!-- Main Col END -->
	</div>
	<!-- body-row END -->
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/jQuery/jquery-3.7.0.min.js"/>"></script>
	<script src="<c:url value="/resources/js/menu1.js"/>"></script>
	<script>
	 var jq = jQuery.noConflict();
	 jq(document).ready(function() {
	    // Hàm thêm đoạn mã HTML vào form
	    var sida = jq('.sd-may').length;
	    function addSDMay() {
	    	console.log(sida)
	        var newSDMayHTML = `
	            <div class="sd-may row p-0">
	               <div class="col-3">
	                   <div class="mb-3">
	                       <label for="" class="form-label">Mã Máy</label>
	                       <select name="listMay[\${sida}].maMay" class="form-select">
	                           <option value="" disabled="true" selected="true">Chọn ID May</option>
	                           <c:forEach items="${listMM}" var="item">
	                               <option value="${item}">${item}</option>
	                           </c:forEach>
	                       </select>
	                   </div>
	               </div>

	               <div class="col-3">
	                   <div class="mb-3">
	                       <label for="" class="form-label">Ngày SD:</label>
	                       <input type="date" id="ngaySD_\${sida}" class="form-control" name="listMay[\${sida}].ngaySD" />
	                   </div>
	               </div>

	               <div class="col-3">
	                   <div class="mb-3">
	                       <label for="" class="form-label">Giờ SD:</label>
	                       <input type="time" id="gioSD_\${sida}" class="form-control" name="listMay[\${sida}].gioSD" />
	                   </div>
	               </div>

	               <div class="col-3">
	                   <div class="mb-3">
	                       <label for="" class="form-label">TG SD:</label>
	                       <input type="number" id="thoiGianSD_\${sida}" class="form-control" name="listMay[\${sida}].thoiGianSD" />
	                   </div>
	               </div>
	           </div> `;

	           jq('#render').append(newSDMayHTML); // Thêm đoạn mã HTML vào container
	        sida ++;
	    }
	    
	    jq('#addMay').click(function() {
	    	addSDMay();
	    });
	});
	</script>
</body>

</html>