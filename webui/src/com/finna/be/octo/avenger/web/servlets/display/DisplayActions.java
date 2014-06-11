package com.finna.be.octo.avenger.web.servlets.display;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.IActionDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.ActionDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.UserDAO;
import com.finna.be.octo.avenger.core.db.model.DBAction;
import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.core.db.model.DBUser;

public class DisplayActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayActions() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("actions", getActionsForSubscribedTasks(request.getRemoteUser(), 1));
		request.getRequestDispatcher("actions.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final int rollbackDays = Integer.parseInt(request.getParameter("rollbackDays"));
		if (request.getParameter("suscribedOnly") != null) {
			request.setAttribute("actions", getActionsForSubscribedTasks(request.getRemoteUser(), rollbackDays));
		} else {
			request.setAttribute("actions", getActions(rollbackDays));
		}
		request.getRequestDispatcher("actions.jsp").forward(request, response);
	}
	
	private Collection<DBAction> getActionsForSubscribedTasks(String username, int rollbackDays) {
		Collection<DBAction> actionsForSubscribedTasks = new ArrayList<DBAction>();
		Collection<DBAction> actions = getActions(rollbackDays);
		for (DBAction action : actions) {
			if (action.getObject() == "TASK" && isUserSubscribedTo(action.getObjectId(), username)) {
				actionsForSubscribedTasks.add(action);
			}
		}
		return actionsForSubscribedTasks;
	}
	
	private boolean isUserSubscribedTo(long objectId, String username) {
		DBUser user = (new UserDAO()).getByUsername(username);
		for (DBTask subcribedTask : user.getSubscribedTasks()) {
			if (objectId == subcribedTask.getId()) {
				return true;
			}
		}
		return false;
	}

	private Collection<DBAction> getActions(int rollbackDays) {
		final IActionDAO actionDAO = new ActionDAO();
		final Collection<DBAction> actions = actionDAO.getFilteredTaskActions(rollbackDays);
		return actions;
	}

}
