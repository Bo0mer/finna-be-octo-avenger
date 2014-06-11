package com.finna.be.octo.avenger.web.servlets.display;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.IActionDAO;
import com.finna.be.octo.avenger.core.db.dao.ICommentDAO;
import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.dao.impl.ActionDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.CommentDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.TaskDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.UserDAO;
import com.finna.be.octo.avenger.core.db.model.ActionType;
import com.finna.be.octo.avenger.core.db.model.DBAction;
import com.finna.be.octo.avenger.core.db.model.DBComment;
import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.core.db.model.DBUser;

public class DisplayTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayTask() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		initPage(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			createAndAddCommentForTask(getTask(request), request);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		initPage(request, response);
	}
	
	private void initPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		DBTask task = getTask(request);
		request.setAttribute("task", task);
		request.setAttribute("subscribed", isUserSubscribed(task, request.getRemoteUser()));
		request.setAttribute("comments", getComments(task));
		request.getRequestDispatcher("task.jsp").forward(request, response);
	}

	private DBTask getTask(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		ITaskDAO task = new TaskDAO();
		return task.getById(id);
	}
	
	private boolean isUserSubscribed(DBTask task, String username) {
		DBUser currentUser = getUser(username);
		for (DBTask subscribedTask : currentUser.getSubscribedTasks()) {
			if (subscribedTask.getId() == task.getId()) {
				return true;
			}
		}
		return false;
	}

	private Collection<DBComment> getComments(DBTask task) {
		ICommentDAO commentDAO = new CommentDAO();
		return commentDAO.getCommentsWithTaskId(task.getId());
	}

	private void createAndAddCommentForTask(DBTask task, HttpServletRequest request) throws DAOException {
		ICommentDAO commentDAO = new CommentDAO();
		IActionDAO actionDAO = new ActionDAO();
		
		DBComment comment = createComment(task, request);
		commentDAO.createComment(comment);
		try {
			actionDAO.createAction(createAction(comment));
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

	private DBComment createComment(DBTask task, HttpServletRequest request) {
		DBComment comment = new DBComment();
		comment.setContent(request.getParameter("comment"));
		comment.setTask(task);
		comment.setTimestamp(new Timestamp(new Date().getTime()));
		comment.setUser(getUser(request.getRemoteUser()));
		return comment;
	}

	private DBUser getUser(String username) {
		IUserDAO userDAO = new UserDAO();
		return userDAO.getByUsername(username);
	}
	
	private DBAction createAction(DBComment comment) {
		DBAction action = new DBAction();
		action.setAction(ActionType.INSERT);
		action.setObject("COMMENT");
		action.setPerformedAt(new Timestamp((new Date()).getTime()));
		action.setNewValue(String.valueOf(comment.getId()));
		action.setUsername(comment.getUser().getUsername());
		action.setObjectId(comment.getId());
		return action;
	}
}
