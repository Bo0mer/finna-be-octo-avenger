package com.finna.be.octo.avenger.web.servlets.display;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.TaskDAO;
import com.finna.be.octo.avenger.core.db.model.DBTask;

public class DisplayTasks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public DisplayTasks() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setTasks(request, response);
		request.getRequestDispatcher("project.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	private void setTasks(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Collection<DBTask> tasks = getTasksWithProjectId(getProjectId(request));
		request.setAttribute("tasks", tasks);
	}

	private Collection<DBTask> getTasksWithProjectId(long projectId) {
		ITaskDAO taskDAO = new TaskDAO();
		return taskDAO.getTasksWithProjectId(projectId);
	}

	private long getProjectId(HttpServletRequest request) {
		return Long.parseLong(request.getParameter("id"));
	}

	
}
