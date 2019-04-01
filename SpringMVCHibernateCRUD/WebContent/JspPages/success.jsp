<%@page import="com.cjc.model.Student"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<h1>Success Page</h1>
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
	document.my.action="register";
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
<br>
<table border="1">
<tr>
<th>Select</th>
<th>Name</th>
<th>Email</th>
<th>Gender</th>
<th>UserName</th>
<th>PassWord</th>
<th>Language</th>
<th>Country</th>
</tr>
<c:forEach items="${data}" var="user">
<tr>
<td><input type="radio" name="id" id="rollno" value="${user.rollno}"></td>
<td>${user.name}</td>
<td>${user.email}</td>
<td>${user.gender}</td>
<td>${user.uname}</td>
<td>${user.pass}</td>
<td>${user.lang}</td>
<td>${user.country}</td>
</tr>
</c:forEach>
</table>
<br><br>
<input type="button" onclick="add()" value="Add">
<input type="button" onclick="edit()" value="Edit">
<input type="button" onclick="deleteRecord()" value="Delete"><br><br>
<input type="button" onclick="logout()" value="LogOut">
</form>
</center>
</body>
</html>