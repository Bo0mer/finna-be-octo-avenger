package com.finna.be.octo.avenger.web.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.IActionDAO;
import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.dao.impl.ActionDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.TaskDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.UserDAO;
import com.finna.be.octo.avenger.core.db.model.ActionType;
import com.finna.be.octo.avenger.core.db.model.DBAction;
import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.core.db.model.DBUser;
import com.finna.be.octo.avenger.core.db.model.TaskStatus;

public class AssignTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AssignTask() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("users", getUsers());
		request.setAttribute("taskId", request.getParameter("taskId"));
		request.getRequestDispatcher("assigntask.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ITaskDAO taskDAO = new TaskDAO();
		IActionDAO actionDAO = new ActionDAO();
		
		DBTask task = getTask(request.getParameter("taskId"), taskDAO);
		DBUser user = getUser(request.getParameter("user"));
		DBAction action = createAction(task, request.getRemoteUser(), user);

		int userActiveTasks = getUserActiveTasksCount(user, taskDAO);
		
		task.setUser(user);
		try {
			taskDAO.updateTask(task);
			try {
				actionDAO.createAction(action);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		} catch (DAOException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}

		if (userActiveTasks > 1) {
			response.getWriter().println(
					String.format(
							"<body>Warning! The user %s has more than 1 active tasks! <a href='./DisplayUser?userName=%s'>Details</a></body></html>",
							user.getUsername(),
							user.getUsername()));
		} else {
			response.getWriter().println(String.format("<html><meta http-equiv=\"refresh\" content=\"1;url=./DisplayTask?id=%s\" />", task.getId()));
			response.getWriter().println("<body>Task created successful. Redirecting you to the task page in 1 second.</body></html>");
		}
	}

	private DBAction createAction(DBTask task, String username, DBUser user) {
		final DBAction action = new DBAction();
		action.setAction(ActionType.UPDATE);
		action.setObject("TASK");
		action.setObjectId(task.getId());
		action.setField("USER");
		action.setPerformedAt(new Timestamp((new Date()).getTime()));
		action.setUsername(username);
		action.setOldValue("");
		action.setNewValue(String.valueOf(user.getId()));
		return action;
	}

	private Collection<DBUser> getUsers() {
		return (new UserDAO()).getUsers();
	}
	
	private DBTask getTask(String taskId, ITaskDAO taskDAO) {
		long id = Long.parseLong(taskId);
		return taskDAO.getById(id);
	}
	
	private DBUser getUser(String userId) {
		long id = Long.parseLong(userId);
		return (new UserDAO()).getById(id);
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

}
