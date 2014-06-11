<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function submitForm() {
		var user = document.forms["assignTask"]["user"];
		if (user == "" || user == null) {
			alert("You have not selected user.");
			return false;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign task...</title>
</head>
<body>
	<%@ include file="templates/header.jsp"%>
	<form name="assignTask" action="AssignTask" method="post" onsubmit="return submitForm()">
		<input type="hidden" name="taskId" value="${taskId }">
		<select name="user">
			<c:forEach var="user" items="${users }">
				<option value="${user.id }">${user.username }</option>
			</c:forEach>
		</select>
		<input type="submit">
	</form>

</body>
</html>