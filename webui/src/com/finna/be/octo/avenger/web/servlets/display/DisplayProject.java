package com.finna.be.octo.avenger.web.servlets.display;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.IProjectDAO;
import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.ProjectDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.TaskDAO;
import com.finna.be.octo.avenger.core.db.model.DBProject;
import com.finna.be.octo.avenger.core.db.model.DBTask;

public class DisplayProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayProject() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long projectId = Long.parseLong(request.getParameter("id"));
		DBProject project = getProject(projectId);
		Collection<DBTask> tasks = getTasks(project);
		request.setAttribute("project", project);
		request.setAttribute("tasks", tasks);
		request.getRequestDispatcher("project.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private DBProject getProject(long projectId) {
		IProjectDAO projectDAO = new ProjectDAO();
		return projectDAO.getById(projectId);
	}
	
	private Collection<DBTask> getTasks(DBProject project) {
		ITaskDAO taskDAO = new TaskDAO();
		Collection<DBTask> tasks = taskDAO.getTasksWithProjectId(project.getId());
		return tasks;
	}

}
