<html>
<head>
<h1>Register Page</h1>
</script>
</head>
<body>
	<center>
		<form action="regi" method="post">
			Name : <input type="text" name="name"
				placeholder="Enter Ur Name Here"> <br> Email : <input
				type="text" name="email" placeholder="Enter Ur Email"> <br>
			Gender : <input type="radio" name="gender" value="male"> Male<br>
			<input type="radio" name="gender" value="female"> Female<br>
			<input type="radio" name="gender" value="other"> Other <br>
			Language : <label for="lang">Language :</label><br> <input
				type="checkbox" name="lang" value="English">English<br>
			<input type="checkbox" name="lang" value="Hindi">Hindi<br>
			<input type="checkbox" name="lang" value="Marathi">Marathi<br>
			<br> Country : <select name="country">
				<option value="India">India</option>
				<option value="SriLanka">SriLanka</option>
				<option value="USA">USA</option>
				<option value="England">England</option>
				<option value="Japan">Japan</option>
				<option value="Dubai">Dubai</option>
				<option value="SouthAfrika">SouthAfrika</option>
				<option value="Malesia">Malesia</option>
			</select> <br> <br> UserName : <input type="text" name="uname"
				id="t1" onblur="data()" placeholder="Enter Ur UserName"><br>
			<div id="t2"></div>
			<br> Password : <input type="password" name="pass"
				placeholder="Enter Ur PassWord">
				<br><br>
				 <input type="submit" value="Register">

		</form>
	</center>
</body>
</html>