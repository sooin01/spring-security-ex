<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<form action="/login" method="post">
	Username: <input type="text" name="username" value="admin">
	<br>
	Password: <input type="password" name="password" value="admin">
	<br>
	<input type="submit" value="login">
</form>

</body>
</html>