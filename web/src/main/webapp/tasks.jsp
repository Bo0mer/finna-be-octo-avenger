<%@page import="com.finna.be.octo.avenger.core.db.dao.IProjectDAO"%>
<%@page import="com.finna.be.octo.avenger.core.db.dao.impl.ProjectDAO"%>
<%@page import="com.finna.be.octo.avenger.core.db.model.DBProject"%>
<%@page import="com.finna.be.octo.avenger.core.db.model.DBTask"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tasks</title>
</head>
<body>
<%
	try {
		long projectId = Long.valueOf(request.getParameter("projectId"));
		IProjectDAO projectDAO = new ProjectDAO();
		DBProject project = projectDAO.getById(projectId);
		for (DBTask task : project.getTasks()) {
			out.print(task.getName() + " assigned to " + task.getUser().getFullName() + "<br/>");
		}
	} catch (NumberFormatException e) {
		out.print("Wrong project Id: " + request.getParameter("projectId"));
	}
%>	
	
</body>
</html>