package com.finna.be.octo.avenger.web.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.IActionDAO;
import com.finna.be.octo.avenger.core.db.dao.IProjectDAO;
import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.dao.impl.ActionDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.ProjectDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.TaskDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.UserDAO;
import com.finna.be.octo.avenger.core.db.model.ActionType;
import com.finna.be.octo.avenger.core.db.model.DBAction;
import com.finna.be.octo.avenger.core.db.model.DBProject;
import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.core.db.model.DBUser;
import com.finna.be.octo.avenger.core.db.model.TaskStatus;

public class CreateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateTask() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("projects", getProjects());
		request.setAttribute("users", getUsers());
		String projectId = request.getParameter("projectId");
		if (projectId != "" && projectId != null) {
			request.setAttribute("selectedProject", getProject(projectId));
		}
		request.getRequestDispatcher("newtask.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		createTask(request, response);
	}

	private Collection<DBProject> getProjects() {
		IProjectDAO projectDAO = new ProjectDAO();
		return projectDAO.getProjects();
	}

	private Collection<DBUser> getUsers() {
		IUserDAO userDAO = new UserDAO();
		return userDAO.getUsers();
	}

	private void createTask(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException {
		ITaskDAO taskDAO = new TaskDAO();
		IActionDAO actionDAO = new ActionDAO();
		
		int userActiveTasks = 0;
		
		DBUser user = null;
		DBTask task = null;
		
		try {
			task = getTask(request);
			user = task.getUser();

			userActiveTasks = (user != null) ? getUserActiveTasksCount(user, taskDAO) : 0;

			taskDAO.createTask(task);
			try {
				actionDAO.createAction(createAction(task, request.getRemoteUser()));
			} catch (DAOException e) {
				e.printStackTrace();
			}
		} catch (DAOException e) {
			request.setAttribute("errorMessage", String.format("Unable to create task %s", task.getName()));
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		if (userActiveTasks > 1) {
			response.getWriter()
					.println(
							String.format(
									"<body>Warning! The user %s has more than 1 active tasks! <a href='./DisplayUser?userName=%s'>Details</a></body></html>",
									user.getUsername(), user.getUsername()));
		} else {
			response.getWriter()
					.println(
							String.format(
									"<html><meta http-equiv=\"refresh\" content=\"1;url=./DisplayProject?id=%s\" />",
									task.getProject().getId()));
			response.getWriter()
					.println(
							"<body>Task created successful. Redirecting you to the projects page in 1 second.</body></html>");
		}

	}

	private DBTask getTask(HttpServletRequest request) {
		if (validateDueDate(getDueDate(request.getParameter("dueDate")))) {
			DBTask task = new DBTask();
			task.setName(request.getParameter("name"));
			task.setDescription(request.getParameter("description"));
			task.setStatus(TaskStatus.INITIAL);
			task.setPriority(Integer.parseInt(request.getParameter("priority")));
			task.setDueDate(getDueDate(request.getParameter("dueDate")));
			task.setUser(getUser(request.getParameter("user")));
			task.setProject(getProject(request.getParameter("project")));
			return task;
		} else {
			return null;
		}
	}

	private java.util.Date getDueDate(String dateString) {
		return Date.valueOf(dateString);
	}

	private boolean validateDueDate(java.util.Date dueDate) {
		java.util.Date todayIs = new java.util.Date();
		if (dueDate.before(todayIs)) {
			return false;
		}
		return true;

	}

	private DBUser getUser(String userId) {
		if (userId == "" || userId == null) {
			return null;
		}
		IUserDAO userDAO = new UserDAO();
		return userDAO.getById(Long.parseLong(userId));
	}

	private DBProject getProject(String projectId) {
		IProjectDAO projectDAO = new ProjectDAO();
		return projectDAO.getById(Long.parseLong(projectId));
	}

	private int getUserActiveTasksCount(DBUser user, ITaskDAO taskDAO) {
		Collection<DBTask> tasks = taskDAO.getTasksWithUserId(user.getId());
		int activeTasks = 0;
		for (DBTask task : tasks) {
			if (task.getStatus() != TaskStatus.COMPLETED) {
				++activeTasks;
			}
		}
		return activeTasks;
	}

	private DBAction createAction(DBTask task, String username) {
		DBAction action = new DBAction();
		action.setAction(ActionType.INSERT);
		action.setObject("TASK");
		action.setUsername(username);
		action.setPerformedAt(new Timestamp((new java.util.Date()).getTime()));
		action.setNewValue(String.valueOf(task.getId()));
		action.setObjectId(task.getId());
		return action;
	}
}
