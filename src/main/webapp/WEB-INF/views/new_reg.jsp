<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration page</title>
<style type="text/css">
	body{
		background-image: url('registration.jpg');
	}
</style>
</head>
<body>
		<h2>New Registration</h2>
		<form action="saveReg" method="post">
			<pre>
			Name<input type="text" name = "name"/> <br> <br>
			City<input type="text" name = "city"/> <br> <br>
			Email<input type="text" name = "email"/> <br> <br>
			Mobile<input type="text" name = "mobile"/> <br> <br>
			<input type="submit" value="save"/>
			</pre>
		</form>
		<% 
	if(request.getAttribute("msg")!=null){
		out.println(request.getAttribute("msg"));
	}
	%>
</body>
</html>