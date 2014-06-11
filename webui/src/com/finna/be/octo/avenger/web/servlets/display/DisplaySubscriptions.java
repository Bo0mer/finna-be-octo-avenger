package com.finna.be.octo.avenger.web.servlets.display;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.impl.UserDAO;
import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.core.db.model.DBUser;

public class DisplaySubscriptions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplaySubscriptions() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("tasks", getSubscribedTasks(request.getRemoteUser()));
		request.getRequestDispatcher("subscriptions.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private Collection<DBTask> getSubscribedTasks(String username) {
		DBUser user = (new UserDAO()).getByUsername(username);
		return user.getSubscribedTasks();
	}

}
