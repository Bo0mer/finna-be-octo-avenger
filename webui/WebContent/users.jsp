<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
</head>
<body>
<%@ include file="templates/header.jsp" %>
	<div class="divBlock">
		<c:forEach var="user" items="${users}">
			<a href='./DisplayUser?userName=${user.username}'>${user.username}</a><br/>
		</c:forEach>
	</div>
</body>
</html>