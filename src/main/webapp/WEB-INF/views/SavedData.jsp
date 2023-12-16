<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered data</title>
<style type="text/css">
	body{
		background-image: url('registration.jpg');
	}
</style>
</head>
<body>
	<% out.println(request.getAttribute("name"));
	out.println(request.getAttribute("city"));
	out.println(request.getAttribute("email"));
	out.println(request.getAttribute("phone"));
	%>
</body>
</html>