<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.cjc.model.Student"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homee</title>
<script type="text/javascript">
function edit() {
	var id = document.getElementById("rollno").value;
	document.my.action="edit";
	document.my.submit();
}
function deleteRecord() {
	var id = document.getElementById("rollno").value;
	document.my.action="delete";
	document.my.submit();
}
function add() {
	document.my.action="regi";
	document.my.submit();
}
function logout() {
	document.my.action="logout";
	document.my.submit();
} 
</script>
</head>
<body>
<center>
<form name="my">
<table border="1">
<tr>
<th>Select</th>
<th>Name</th>
<th>Password</th>
<th>Addres</th>
<th>Mobile</th>
</tr>
<c:forEach items="${alldata}" var="user">
<tr>
<td><input type="radio" name="id" id="rollno" value="${user.rollno}"></td>
<td>${user.username}</td>
<td>${user.password}</td>
<td>${user.address}</td>
<td>${user.mobile}</td>
</tr>
</c:forEach>
</table>
<input type="button" onclick="add()" value="Add">
<input type="button" onclick="edit()" value="Edit">
<input type="button" onclick="deleteRecord()" value="Delete">
<input type="button" onclick="logout()" value="Logout"><br><br>
</form>
</center>
</body>
</html>