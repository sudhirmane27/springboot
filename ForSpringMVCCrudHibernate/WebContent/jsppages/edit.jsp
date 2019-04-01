<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.cjc.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<form action=register>
<center>
<%Student s=(Student)request.getAttribute("editdata"); %>
<input type="hidden" name="rollno" value=<%=s.getRollno()%>>

Username:<input type="text" name="username" value=<%=s.getUsername()%>>
<br>
Password:<input type="password" name="password" value=<%=s.getPassword() %>>
<br>
Address:<input type="text" name="address" value=<%=s.getAddress() %>>
<br>
Mobile:<input type="number" name="mobile" value=<%=s.getMobile() %>>
<br>
<input type="submit" value="Submit">
</center>
</form>
</body>
</html>