<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Registration</title>
<style type="text/css">
	body{
		background-image: url('registration.jpg');
	}
</style>
</head>
<body>
	<h2>Update registration details</h2>
		<form action="update" method="post">
			Email<input type="text" name="email" value="<%=request.getAttribute("email")%>"/> <br> <br>
			Mobile<input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"/> <br> <br>
			<input type="submit" value="update">
		</form>
</body>
</html>