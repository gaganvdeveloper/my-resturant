<%@page import="com.tyss.myresturantapplication.dto.Staff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff Home Page</title>
</head>
<%
Staff staff = (Staff) request.getAttribute("staff");

if (staff != null) {
%>
<body>




	<h1>Welcome To Staff Home</h1>
	<h2>Mr.${staff.getName() }</h2>







</body>
<%
} else {
response.sendRedirect("stafflogin.jsp");
}
%>
</html>