<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>main</title>
<script type="text/javascript" src="/resources/js/jquery/jquery.min.js"></script>
<script type="text/javascript">
var isLogout = false;
var ws = new WebSocket('ws://localhost:8080/session/check');
ws.onclose = function(event) {
	if (!isLogout) {
		alert("Session timeout.");
	}
	
    location.href = "/login";
};
</script>
</head>
<body>
<h1>Welcome main!</h1>

<div>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		name: <b>${pageContext.request.userPrincipal.name}</b> (${timestamp})
		<form id="form" method="get" action="/logout"><input type="submit" value="logout"></form>
	</c:if> 
</div>

<script type="text/javascript">
$("#form").submit(function(event) {
	isLogout = true;
});
</script>

</body>
</html>
