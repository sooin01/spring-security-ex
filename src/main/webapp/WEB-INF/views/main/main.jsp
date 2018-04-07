<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>main</title>
</head>
<body>
<h1>Welcome main!</h1>
<div>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		name: <b>${pageContext.request.userPrincipal.name}</b>
		<form method="get" action="logout"><input type="submit" value="logout"></form>
	</c:if> 
</div>
</body>
</html>
