<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function isValid(data) {
	return (data != null && data != "");
}
function submitForm() {
	var form = document.forms["createTask"];
	var data = [form["name"].value, form["description"].value,
	            form["dueDate"].value, form["priority"].value,
				form["project"].value];
	for (var i = 0; i < data.length; ++i) {
		if (!isValid(data[i])) {
			alert("You have entered invalid data!");
			return false;
		}
	}	
	
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new task</title>
</head>
<body>
<%@ include file="templates/header.jsp" %>
	<form name="createTask" action="CreateTask" method="post" onsubmit="return submitForm()">
	<label>Name</label>
	<input type="text"  name="name" required>
	<br/>
	<label>Description</label>
	<input type="text" name="description">
	<br/>
	<label>Date</label>
	<input type="date" name="dueDate" required>
	<label>Priority</label>
	<input type="text" name="priority">
	<br/> <select name="project">
			<c:choose>
				<c:when test="${not empty selectedProject }">
					<option value="${selectedProject.id }">${selectedProject.name }</option>
				</c:when>
				<c:otherwise>
					<c:forEach var="project" items="${projects}">
						<option value="${project.id }">${project.name }</option>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</select> <br/>
		<select name="user">
		<option value="">**Unassigned**</option>
		<c:forEach var="user" items="${users}">
		<option value="${user.id }">${user.username }</option>
		</c:forEach>
		</select> 
		<input type="submit">
	</form>
</body>
</html>