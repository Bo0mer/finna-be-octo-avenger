package com.finna.be.octo.avenger.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.dao.impl.TaskDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.UserDAO;
import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.core.db.model.DBUser;

public class Unsubscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Unsubscribe() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBTask task = getTask(request.getParameter("id"));
		if (task == null) {
			request.setAttribute("errorMessage", String.format("Task with id %s does not exist.", request.getParameter("id")));
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		IUserDAO userDAO = new UserDAO();
		DBUser user = getUser(request.getRemoteUser(), userDAO);
		removeSubscription(user, task);
		try {
			userDAO.updateUser(user);
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Sorry, but there is a problem removing task from your subscriptions.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		response.sendRedirect("./DisplayTask?id=" + task.getId());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void removeSubscription(DBUser user, DBTask task) {
		List<DBTask> newSubscribed = new ArrayList<DBTask>();
		for (DBTask subscribedTask : user.getSubscribedTasks()) {
			if (task.getId() != subscribedTask.getId()) {
				newSubscribed.add(subscribedTask);
			}
		}
		user.setSubscribedTasks(newSubscribed);
	}

	private DBUser getUser(String username, IUserDAO userDAO) {
		return userDAO.getByUsername(username);
	}
	
	private DBTask getTask(String taskId) {
		long id = 0;
		try {
			id = Long.parseLong(taskId);
		} catch (NumberFormatException e) {
			return null;
		}
		ITaskDAO task = new TaskDAO();
		return task.getById(id);
	}
}
