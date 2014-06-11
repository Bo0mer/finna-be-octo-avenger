<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task info</title>
</head>
<body>
	<%@ include file="templates/header.jsp"%>
	<div class="divBlock">
						Project: <a href='DisplayProject?id=${task.project.id }'>${task.project.name }</a><br/>
		Task name: ${task.name}
		<c:if test="${subscribed }">
			<a href='./Unsubscribe?id=${task.id }'>[Unsubscribe]</a>
		</c:if>
		<c:if test="${!subscribed }">
			<a href='./Subscribe?id=${task.id }'>[Subscribe]</a>
		</c:if>
		<br /> Task description: ${task.description}<br />
		Due date: ${task.dueDate }<br /> 
		Priority: ${task.priority } <br/>
		Status: ${task.status } 
		<a href="./ProcessTaskStatus?id=${task.id}"> [Process task]</a><br />
		Assigned to: 
		<c:choose>
			<c:when test="${empty task.user }">
				**Unassigned** <a href='./AssignTask?taskId=${task.id }'>Assign...</a><br/>
			</c:when>
			<c:otherwise>
				<a href='./DisplayUser?userName=${task.user.username}'>${task.user.username}</a>
				<br />
			</c:otherwise>
		</c:choose>
		
	</div>
	<c:forEach var="comment" items="${comments}">
	<a id="${comment.id }"></a>
	<div class="divBlock">
	<a href="./DisplayComment?id=${comment.id}">
	Posted by: ${comment.user.username} on ${comment.timestamp}<br/>
	</a>
	<hr/>
	${comment.content}<br />
	</div>
	</c:forEach>
	<form action="" method="post">
		<label for="comment">Add Comment:</label><br> <input type="text"
			id="comment" name="comment"> <input type="submit">
	</form>
</body>
</html>