<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list of registrations</title>
<style type="text/css">
	body{
		background-image: url('registration.jpg');
	}
</style>
</head>
<body>
	
	<h2> All registration</h2>
	<table border='10'>
		<tr>
			<th> Name</th>
			<th> City</th>
			<th> Email</th>
			<th> Phone</th>
			<th> Delete</th>
		</tr>
		<% 
			ResultSet result = (ResultSet)request.getAttribute("result");
			while(result.next()){%>
		<tr>
			<td><%=result.getString(1) %></td>
			<td><%=result.getString(2) %></td>
			<td><%=result.getString(3) %></td>
			<td><%=result.getString(4) %></td>
			<td> <a href="delete?emailId=<%=result.getString(3)%>">delete</a>
			<td> <a href="update?emailId=<%=result.getString(3)%>&mobile=<%=result.getString(4)%>">update</a>
		</tr>
			<%}%>
	</table>
</body>
</html>