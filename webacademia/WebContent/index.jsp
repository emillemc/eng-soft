<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>P�gina de login</title>
</head>
<body>

<% if(request.getAttribute("msg") != null){%>
 		<%= request.getAttribute("msg")	 %>	
<% } %>
<form method="post" action="/webacademia/login">
Login: <input type="text" name="login" /><br />
Senha: <input type="password" name="senha"/><br />
<input type="submit" value="Logar"/>
</form>
</body>
</html>