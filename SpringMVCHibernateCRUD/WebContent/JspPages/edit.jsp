<%@page import="com.cjc.model.Student"%>
<%@page import="java.util.List"%>
<html>
<head>
<h1>Update Page</h1>
</head>
<body>
<center>
<form action="regi" method="post">
<%Student s = (Student)request.getAttribute("data");%>
<input type="hidden" name="rollno" value="<%=s.getRollno()%>">
<br>
Name  : <input type="text" name="name" value="<%=s.getName()%>" >
<br><br>
Email : <input type="text" name="email" value="<%=s.getEmail()%>" >
<br><br>
Gender :
<%if(s.getGender().equalsIgnoreCase("Male")){ %>
 <input type="radio" name="gender" value="Male" checked> Male<br>
  <input type="radio" name="gender" value="Female"> Female<br>
<%}else{ %>
<input type="radio" name="gender" value="Male"> Male<br>
  <input type="radio" name="gender" value="Female" checked> Female<br>
<%} %>
<br>
<%String [] str = s.getLang().split(",");%>
<label for="lang">Language :</label><br>

<%if(str.length==1){ %>
<%if(str[0].equals("English")){ %>
  <input type="checkbox" name="lang" value="English" checked>English<br>
  <input type="checkbox" name="lang" value="Hindi">Hindi<br>
  <input type="checkbox" name="lang" value="Marathi">Marathi<br>
  <%}%>
  <%if(str[0].equals("Hindi")){ %>
  <input type="checkbox" name="lang" value="English" >English<br>
  <input type="checkbox" name="lang" value="Hindi" checked>Hindi<br>
  <input type="checkbox" name="lang" value="Marathi">Marathi<br>
  <%}%>
  <%if(str[0].equals("Marathi")){ %>
  <input type="checkbox" name="lang" value="English" >English<br>
  <input type="checkbox" name="lang" value="Hindi">Hindi<br>
  <input type="checkbox" name="lang" value="Marathi" checked>Marathi<br>
  <%}%>
  <%} %>
  <%if(str.length==2){ %>
  <%if((str[0].equals("English") && str[1].equals("Hindi"))||(str[0].equals("Hindi") && str[1].equals("English"))){ %>
  <input type="checkbox" name="lang" value="English" checked>English<br>
  <input type="checkbox" name="lang" value="Hindi" checked>Hindi<br>
  <input type="checkbox" name="lang" value="Marathi">Marathi<br>
  <%}%>
  <%if((str[0].equals("English") && str[1].equals("Marathi"))||(str[0].equals("Marathi") && str[1].equals("English"))){ %>
  <input type="checkbox" name="lang" value="English" checked >English<br>
  <input type="checkbox" name="lang" value="Hindi" >Hindi<br>
  <input type="checkbox" name="lang" value="Marathi" checked>Marathi<br>
  <%}%>
  <%if((str[0].equals("Hindi") && str[1].equals("Marathi"))||(str[0].equals("Marathi") && str[1].equals("Hindi"))){ %>
  <input type="checkbox" name="lang" value="English"  >English<br>
  <input type="checkbox" name="lang" value="Hindi" checked>Hindi<br>
  <input type="checkbox" name="lang" value="Marathi" checked>Marathi<br>
  <%}%>
  <%} %>
  <%if(str.length==3){ %>
  <input type="checkbox" name="lang" value="English" checked>English<br>
  <input type="checkbox" name="lang" value="Hindi" checked>Hindi<br>
  <input type="checkbox" name="lang" value="Marathi" checked>Marathi<br>
  <%} %>
  <%if(s.getLang().length()== 0){ %>
  <input type="checkbox" name="lang" value="English" >English<br>
  <input type="checkbox" name="lang" value="Hindi" >Hindi<br>
  <input type="checkbox" name="lang" value="Marathi" >Marathi<br>
  <%} %>
<br><br>
Country : <select name="country" value ="<%=s.getCountry()%>">
    <option value="India">India</option>
    <option value="SriLanka">SriLanka</option>
    <option value="USA">USA</option>
    <option value="England">England</option>
    <option value="Japan">Japan</option>
    <option value="Dubai">Dubai</option>
    <option value="SouthAfrika">SouthAfrika</option>
    <option value="Malesia">Malesia</option>
  </select>
<br><br>
UserName  : <input type="text" name ="uname" value="<%=s.getUname()%>" >
<br><br>
PassWord : <input type="text" name ="pass" value="<%=s.getPass()%>" >
<br><br>
<input type="submit" value="Update">
</form>
</center>
</body>
</html>