package com.finna.be.octo.avenger.web.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.IActionDAO;
import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.dao.impl.ActionDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.UserDAO;
import com.finna.be.octo.avenger.core.db.model.ActionType;
import com.finna.be.octo.avenger.core.db.model.DBAction;
import com.finna.be.octo.avenger.core.db.model.DBUser;

public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createUser(request, response);
	}

	private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IUserDAO userDAO = new UserDAO();
		IActionDAO actionDAO = new ActionDAO();
		
		DBUser user = getUser(request);
		if (!isValidUser(user, userDAO)) {
			response.getWriter().println("<html><meta http-equiv=\"refresh\" content=\"0;url=./CreateUser?error=1\" />");
			return;
		}
		
		try {
			userDAO.createUser(user);
			try {
				actionDAO.createAction(createAction(user, request.getRemoteUser()));
			} catch (DAOException e) {
				e.printStackTrace();
			}
		} catch (DAOException e) {
			response.getWriter().println("<html><meta http-equiv=\"refresh\" content=\"1;url=./updateProfile.jsp\" />");
		}
		response.getWriter().println("<html><meta http-equiv=\"refresh\" content=\"1;url=./\" />");
        response.getWriter().println("<body>Registration successful. Redirecting you to the home page in 1 second.</body></html>");
	}

	private DBUser getUser(HttpServletRequest request) {
		DBUser user = new DBUser();
		user.setUsername(request.getRemoteUser());
		user.setFullName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		return user;
	}
	
	private boolean isValidUser(DBUser user, IUserDAO userDAO) {
		if (!hasValidFields(user)) {
			return false;
		}
		if (userAlreadyExists(user, userDAO)) {
			return false;
		}
		return true;
	}

	private boolean hasValidFields(DBUser user) {
		if (!isValidString(user.getUsername())) {
			return false;
		}
		if (!isValidString(user.getEmail())) {
			return false;
		}
		return true;
	}
	
	private boolean isValidString(String string) {
		return string != null && !string.trim().isEmpty() && string.indexOf(' ') == -1;
	}
	
	private boolean userAlreadyExists(DBUser user, IUserDAO userDAO) {
		return userDAO.getByUsername(user.getUsername()) != null;
	}
	
	private DBAction createAction(DBUser user, String username) {
		DBAction action = new DBAction();
		action.setAction(ActionType.INSERT);
		action.setObject("USER");
		action.setPerformedAt(new Timestamp((new Date()).getTime()));
		action.setUsername(username);
		action.setNewValue(String.valueOf(user.getId()));
		action.setObjectId(user.getId());
		return action;
	}

}
