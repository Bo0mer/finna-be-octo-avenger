package com.finna.be.octo.avenger.web.servlets.display;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.TaskDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.UserDAO;
import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.core.db.model.DBUser;

public class DisplayUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		DBUser user = getUser(username);
		if (user != null) {
			request.setAttribute("user", user);
			request.setAttribute("tasks", getTasks(user));
		}
		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private DBUser getUser(String username) {
		IUserDAO userDAO = new UserDAO();
		return userDAO.getByUsername(username);
	}
	
	private Collection<DBTask> getTasks(DBUser user) {
		ITaskDAO taskDAO = new TaskDAO();
		return taskDAO.getTasksWithUserId(user.getId());
	}

}
