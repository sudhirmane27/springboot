<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<center>
<body>
<form action="login">

Username:<input type="text" name="username">
<br>
Password:<input type="password" name="password">
<br>
<input type="submit" value="Submit">
<br>
<a href="regi">Register here</a>
<br>
<%if(request.getAttribute("msg")!=null) {%>
<%=request.getAttribute("msg") %>
<%} %>
</body>
</form>
</center>
</html>