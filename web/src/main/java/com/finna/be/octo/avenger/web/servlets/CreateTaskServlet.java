package com.finna.be.octo.avenger.web.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.IProjectDAO;
import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.ProjectDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.TaskDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.UserDAO;
import com.finna.be.octo.avenger.core.db.model.DBProject;
import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.core.db.model.DBUser;
import com.finna.be.octo.avenger.dao.exceptions.DAOException;

/**
 * Servlet implementation class CreateTaskServlet
 */
public class CreateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		// TODO : fix conversion from string to date
		//Date dueDate = Date.parse(request.getParameter("date"));
		long userId = Long.parseLong(request.getParameter("user"));
		long projectId = Long.parseLong(request.getParameter("project"));
		
		DBTask task = new DBTask();
		task.setName(name);
		task.setDescription(description);
		task.setDueDate(new Date());
		task.setUser(getUser(userId));
		task.setProject(getProject(projectId));
		
		ITaskDAO taskDAO = new TaskDAO();
		try {
			taskDAO.createTask(task);
		} catch (DAOException e) {
			response.getWriter().write(e.getMessage());
		}
		
	}

	private DBProject getProject(long projectId) {
		IProjectDAO projectDAO = new ProjectDAO();
		return projectDAO.getById(projectId);
	}

	private DBUser getUser(long userId) {
		IUserDAO userDAO = new UserDAO();
		return userDAO.getById(userId);
	}

}
