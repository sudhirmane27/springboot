<html>
<head>
<h1>Login Page</h1>
</head>
<body>
<center>
<form action="login">
<%if(request.getAttribute("msg")!=null){ %>
<%= request.getAttribute("msg") %>
<%} %>
<br>
UserName :-<input type="text" name= "uname" placeholder="UserName"><br>
<br>
Password :-<input type="password" name= "pass" placeholder="Password"><br>
<br>
<input type="submit" value="Login">
<br>
<br>
<a href="register">Register Here !!!</a>
</form>
</center>
</body>
</html>