package com.finna.be.octo.avenger.web.servlets;

import java.io.IOException;
import java.sql.Timestamp;
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
import com.finna.be.octo.avenger.core.db.model.ActionType;
import com.finna.be.octo.avenger.core.db.model.DBAction;
import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.core.db.model.TaskStatus;

public class ProcessTaskStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessTaskStatus() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBTask task = getTask(request);
		try {
			processTask(task, request.getRemoteUser());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		response.sendRedirect("./DisplayTask?id=" + task.getId());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	private DBTask getTask(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		ITaskDAO task = new TaskDAO();
		return task.getById(id);
	}
	
	private void processTask(DBTask task, String username) throws DAOException {
		TaskStatus status = task.getStatus();
		if (status == TaskStatus.COMPLETED) {
			return;
		}
		if (status == TaskStatus.IN_PROCESS) {
			task.setStatus(TaskStatus.COMPLETED);
		}
		if (status == TaskStatus.INITIAL) {
			task.setStatus(TaskStatus.IN_PROCESS);
		}
		saveTask(task, status, username);
	}
	
	private void saveTask(DBTask task, TaskStatus oldStatus, String username) throws DAOException {
		ITaskDAO taskDAO = new TaskDAO();
		taskDAO.updateTask(task);
		
		IActionDAO actionDAO = new ActionDAO();
		try {
			actionDAO.createAction(createAction(task, oldStatus, username));
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	private DBAction createAction(DBTask task, TaskStatus oldStatus, String username) {
		DBAction action = new DBAction();
		action.setAction(ActionType.UPDATE);
		action.setObject("TASK");
		action.setObjectId(task.getId());
		action.setField("STATUS");
		action.setPerformedAt(new Timestamp((new Date()).getTime()));
		action.setUsername(username);
		action.setOldValue(oldStatus.toString());
		action.setNewValue(task.getStatus().toString());
		return action;
	}

}
