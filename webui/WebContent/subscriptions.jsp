<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="templates/header.jsp"%>

	<c:forEach var="task" items="${tasks }">
		<div class="divBlock">
			Task name: <a href='./DisplayTask?id=${task.id}'> ${task.name}</a><br />
			Description: ${task.description}<br /> Due date: ${task.dueDate }<br />
			Priority: ${task.priority } <br/>
			Status: ${task.status }<br /> Assigned to: <a href='./DisplayUser?userName=${task.user.username}'>${task.user.username}</a><br />
			Project: ${task.project.name } <br/>
		</div>
	</c:forEach>

</body>
</html>