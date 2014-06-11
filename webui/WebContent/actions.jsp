<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function submitForm() {
		var rollbackDays = document.forms["displayActions"]["rollbackDays"].value;
		if (isNaN(parseInt(rollbackDays)) || rollbackDays < 0) {
			alert("Incorrect criteria.");
			return false;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="templates/header.jsp"%>
	<form name="displayActions" action="DisplayActions" method="post"
		onsubmit="return submitForm()">
		<label>
		How many days do you want to look back?
		</label>
		<input name="rollbackDays" type="text"> 
		<input type="checkbox" name="suscribedOnly" value="true">Show history only for subscribed tasks
		<input type="submit">
	</form>
	<c:forEach var="action" items="${actions }">
		[${action.performedAt }]
		${action.username } 
		<c:if test="${action.action == 'INSERT' }">
			Added new
		</c:if>
		<c:if test="${action.action == 'UPDATE' }">
			Updated existing
		</c:if>
		
		<c:if test="${action.object == 'COMMENT' }">
			<a href='./DisplayComment?id=${action.objectId }'>comment</a>
		</c:if>
		<c:if test="${action.object == 'TASK' }">
			<a href='./DisplayTask?id=${action.objectId }'>task</a>
		</c:if>
		<c:if test="${action.object == 'PROJECT' }">
			<a href='./DisplayProject?id=${action.objectId }'>project</a>
		</c:if>
		<c:if test="${action.field == 'STATUS' }">
			Change: 
			${action.field } 
			Old value: ${action.oldValue } 
			New value: ${action.newValue }
		</c:if>
		<br/>
	</c:forEach>
</body>
</html>