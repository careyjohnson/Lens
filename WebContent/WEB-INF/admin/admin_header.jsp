<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.bean.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>
    <% String uri = request.getRequestURI(); %>
    <%
	String[] title = {"Admin home","Add product","All products & edit"};
	int activeUri = 0;
	if ("/ECWeb/admin".equals(uri)) {
		activeUri = 0;
	}
	if ("/ECWeb/admin/addnewproduct".equals(uri)) {
		activeUri = 1;
	}
	if("/ECWeb/admin/MangerProduct".equals(uri)){
		activeUri = 2;
	}if("/ECWeb/admin/MangerCategory".equals(uri)){
		activeUri = 3;
	}
	%>
	<br>
    <div class="topnav sticky">
   
            <center><h2>Lin's Lens</h2></center>
            <% AdminBean admin=(AdminBean)(session.getAttribute("admin")); %>
            <h4 style="margin: 25px; font-size: 30px;font-weight:bold"><%= admin.getUsername() %></h4>
            <a <%= activeUri == 1 ? "class='active-nav'" : ""%> href="/ECWeb/admin/addnewproduct">Add New Product <i class='fas fa-plus-square'></i></a>
            <a <%= activeUri == 2 ? "class='active-nav'" : ""%> href="/ECWeb/admin/ManagerProduct">All Products & Edit Products <i class='fab fa-elementor'></i></a>
            <a <%= activeUri == 3 ? "class='active-nav'" : ""%> href="/ECWeb/admin/ManagerCategory">Manage Category <i class='fas fa-comment-alt'></i></a>
            <a href="">Messages Received <i class='fas fa-comment-alt'></i></a>
            <a href="">Orders Received <i class="fas fa-archive"></i></a>
            <a href="">Cancel Orders <i class='fas fa-window-close'></i></a>
            <a href="">Delivered Orders <i class='fas fa-dolly'></i></a>
            <a href="sigout">Logout <i class='fas fa-share-square'></i></a>
          </div>
           <br>
</body>
</html>