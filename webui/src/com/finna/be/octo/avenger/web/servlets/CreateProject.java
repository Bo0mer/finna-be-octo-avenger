package com.finna.be.octo.avenger.web.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.IActionDAO;
import com.finna.be.octo.avenger.core.db.dao.IProjectDAO;
import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.dao.impl.ActionDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.ProjectDAO;
import com.finna.be.octo.avenger.core.db.model.ActionType;
import com.finna.be.octo.avenger.core.db.model.DBAction;
import com.finna.be.octo.avenger.core.db.model.DBProject;

public class CreateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateProject() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		createProject(request, response);
	}

	private void createProject(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		IProjectDAO projectDAO = new ProjectDAO();
		IActionDAO actionDAO = new ActionDAO();
		try {
			DBProject project = getProject(request, response);
			if (project != null) {
				try {

					projectDAO.createProject(project);
					try {
						actionDAO.createAction(createAction(project,
								request.getRemoteUser()));
					} catch (DAOException e) {
						e.printStackTrace();
					}

				} catch (DAOException e) {
					response.sendRedirect("error.jsp");
				} catch (NullPointerException e) {
					response.sendRedirect("error.jsp");
				}
				response.sendRedirect("DisplayProjects");
			} else {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			response.getWriter().print("Project name can not be empty!");
		}
	}

	private DBProject getProject(HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter("name");
		DBProject project = new DBProject();
		if (validateProject(name)) {
			project.setName(name);
			return project;
		} else {
			return null;
		}
	}

	private DBAction createAction(DBProject project, String username) {
		DBAction action = new DBAction();
		action.setAction(ActionType.INSERT);
		action.setObject("PROJECT");
		action.setPerformedAt(new Timestamp((new Date()).getTime()));
		action.setUsername(username);
		action.setNewValue(String.valueOf(project.getId()));
		action.setObjectId(project.getId());
		return action;
	}

	private boolean validateProject(String name) {
		if (name != null && !name.equals("")) {
			return true;
		} else {
			return false;
		}
	}
}
