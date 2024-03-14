<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<div id="sidebar-container" class="sidebar-expanded d-none d-md-block">
	<!-- d- * verbirgt die Sidebar in kleineren Geräten. Die Einträge können im Navbar-Menü gespeichert werden -->
	<!-- Bootstrap-Listengruppe -->
	<ul class="list-group">
		<!-- Trennzeichen mit Titel -->
		<li
			class="list-group-item sidebar-separator-title text-muted d-flex align-items-center menu-collapsed">
			<small>MAIN MENU</small>
		</li>
		<!-- / END Separator -->
		<!-- Menü mit Untermenü -->

		<a href="#submenu1" data-bs-toggle="collapse" aria-expanded="false"
			class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
			<div class="d-flex w-100 justyfy-content-start align-items-center">
				<span class="fa-solid fa-computer fa-fw me-3"></span> <span
					class="menu-collapsed">Computer</span> <span
					class="fas fa-angle-down ms-auto"></span>
			</div>
		</a>
		<!-- Inhalt des Untermenüs -->
		<div id="submenu1" class="collapse sidebar-submenu">
			<a href="${pageContext.request.contextPath}/may/newMay"
				class="list-group-item list-group-item-action bg-dark text-white">
				<span class="menu-collapsed">Add New Computer</span>
			</a> <a href="${pageContext.request.contextPath}/may/listMay"
				class="list-group-item list-group-item-action bg-dark text-white">
				<span class="menu-collapsed">Show All Computers</span>
			</a>
		</div>
		<a href="#submenu2" data-bs-toggle="collapse" aria-expanded="false"
			class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
			<div class="d-flex w-100 justify-content-start align-items-center">
				<span class="fas fa-user fa-fw me-3"></span> <span
					class="menu-collapsed">Customer</span> <span
					class="fas fa-angle-down ms-auto"></span>
			</div>
		</a>
		<!-- Inhalt des Untermenüs -->
		<div id='submenu2' class="collapse sidebar-submenu">
			<a href="${pageContext.request.contextPath}/khachhang/newKH"
				class="list-group-item list-group-item-action bg-dark text-white">
				<span class="menu-collapsed">Add New Customer</span>
			</a> <a href="${pageContext.request.contextPath}/khachhang/listKH"
				class="list-group-item list-group-item-action bg-dark text-white">
				<span class="menu-collapsed">Show All Customers</span>
			</a>
		</div>

		<a href="#submenu3" data-bs-toggle="collapse" aria-expanded="false"
			class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
			<div class="d-flex w-100 justyfy-content-start align-items-center">
				<span class="fas fa-tasks fa-fw me-3"></span> <span
					class="menu-collapsed">Service</span> <span
					class="fas fa-angle-down ms-auto"></span>
			</div>
		</a>
		<!-- Inhalt des Untermenüs -->
		<div id="submenu3" class="collapse sidebar-submenu">
			<a href="${pageContext.request.contextPath}/dichvu/newDV"
				class="list-group-item list-group-item-action bg-dark text-white">
				<span class="menu-collapsed">Add New Service</span>
			</a> <a href="${pageContext.request.contextPath}/dichvu/listDV"
				class="list-group-item list-group-item-action bg-dark text-white">
				<span class="menu-collapsed">Show All Services</span>
			</a>
		</div>
		

		<a href="#submenu4" data-bs-toggle="collapse" aria-expanded="false"
			class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
			<div class="d-flex w-100 justyfy-content-start align-items-center">
				<span class="fas fa-tasks fa-fw me-3"></span> <span
					class="menu-collapsed">Task</span> <span
					class="fas fa-angle-down ms-auto"></span>
			</div>
		</a>
		<!-- Inhalt des Untermenüs -->
		<div id="submenu4" class="collapse sidebar-submenu" >
			<a href="${pageContext.request.contextPath}/Services/regUseCP"
				class="list-group-item list-group-item-action bg-dark text-white">
				<span class="menu-collapsed">Đăng ký SD Máy</span>
			</a> <a href="${pageContext.request.contextPath}/Services/regUseService"
				class="list-group-item list-group-item-action bg-dark text-white">
				<span class="menu-collapsed">Đăng ký SD DV</span>
			</a> <a href="${pageContext.request.contextPath}/Services/listFullInfo"
				class="list-group-item list-group-item-action bg-dark text-white">
				<span class="menu-collapsed">Liệt Kê Thông Tin</span>
			</a>
			</a> <a href="${pageContext.request.contextPath}/Services/listFullInfo1"
				class="list-group-item list-group-item-action bg-dark text-white">
				<span class="menu-collapsed">New Task</span>
			</a>
		</div>


		<!-- Separator with title -->
		<li
			class="list-group-item sidebar-separator-title text-muted d-flex align-items-center menu-collapsed">
			<small>OPTIONS</small>
		</li>
		<!-- /END Separator -->
		<a href="#" class="bg-dark list-group-item list-group-item-action">
			<div class="d-flex w-100 justify-content-start align-items-center">
				<span class="fas fa-calendar fa-fw me-3"></span> <span
					class="menu-collapsed">Calendar</span>
			</div>
		</a>
		<a href="#" class="bg-dark list-group-item list-group-item-action">
			<div class="d-flex w-100 justify-content-start align-items-center">
				<span class="far fa-envelope fa-fw me-3"></span> 
				<span class="menu-collapsed">Messages 
				<span class="badge badge-pill badge-primary ms-2">5</span>
				</span>
			</div>
		</a>
		<!-- Separator without title -->
		<li class="list-group-item sidebar-separator menu-collapsed"></li>
		<!-- /END Separator -->
		<a href="#" class="bg-dark list-group-item list-group-item-action">
			<div class="d-flex w-100 justify-content-start align-items-center">
				<span class="fa fa-question fa-fw me-3"></span> <span
					class="menu-collapsed">Help</span>
			</div>
		</a>
		<a href="#top" data-bs-toggle="sidebar-colapse"
			class="bg-dark list-group-item list-group-item-action d-flex align-items-center">
			<div class="d-flex w-100 justify-content-start align-items-center">
				<span id="collapse-icon" class="fa fa-2x me-3"></span> <span
					id="collapse-text" class="menu-collapsed">Collapse</span>
			</div>
		</a>
	</ul>
	<!-- List Group END-->
</div>