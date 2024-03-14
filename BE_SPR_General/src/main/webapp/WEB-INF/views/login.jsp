<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous"></script>
</head>

<body>
	<div class="container">
		<div class="row justify-content-center bg-dark-subtle p-5">
			<div class="col-4 bg-light border-danger-subtle p-4 rounded">
				<form:form action="login" method="POST" modelAttribute="userForm">
					<h2 class="text-center">Admin Login</h2>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1"><i
							class="bi bi-person-fill"></i></span>
						<form:input type="text" class="form-control"
							placeholder="Username" aria-label="Username"
							aria-describedby="basic-addon1" name="userName" id="userName" path="userName" />
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1"><i
							class="bi bi-lock-fill"></i></span>
						<form:input type="password" class="form-control"
							placeholder="Password" aria-label="Password"
							aria-describedby="basic-addon1" name="password" id="password" path="password"/>
					</div>
					<button type="submit"
						class="btn btn-success w-100 align-items-center">Button</button>
					<div>
						<small id="helpId" class="form-text text-danger"></small>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>

</html>