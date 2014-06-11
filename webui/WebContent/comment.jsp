<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="templates/header.jsp"%>
	<div class="divBlock">
		Posted by: ${comment.user.username} on ${comment.timestamp}<br/>
	<hr/>
	${comment.content}<br />
	Task: <a href="./DisplayTask?id=${comment.task.id}#${comment.id}" >${comment.task.name}</a>
	</div>
</body>
</html>