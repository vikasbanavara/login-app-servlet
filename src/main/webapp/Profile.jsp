<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = (String) session.getAttribute("userName");
	if (name == null) {
		response.sendRedirect("Login.jsp");
	}
	%>

	<h1>Hi welcome to the profile page</h1>
	<h2><a href="Home.jsp">Home</a></h2>
	<h2><a href="logout">Logout</a></h2>
</body>
</html>