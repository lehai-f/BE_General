<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Bootstrap row -->
	<div class="row" id="body-row">
		<!-- Seitenleiste -->
<jsp:include page="leftmenu.jsp"></jsp:include>
		<!-- Seitenleiste-container END -->
		<!-- MAIN -->
		<div class="col p-4">
			<h1 class="display-4">Wellcome</h1>
			<div class="card shadow">
				<h5 class="card-header font-weight-light">Requirements</h5>
				<div class="card-body">
					<ul>
						<li>JQuery</li>
						<li>Bootstrap 5.3</li>
						<li>FontAwesome</li>
						<li>	Server Version: <%= application.getServerInfo() %><br>
								Servlet Version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %>
								JSP Version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %> <br>
						</li>
					</ul>
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