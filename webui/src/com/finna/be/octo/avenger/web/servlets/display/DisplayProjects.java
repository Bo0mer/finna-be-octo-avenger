package com.finna.be.octo.avenger.web.servlets.display;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.IProjectDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.ProjectDAO;
import com.finna.be.octo.avenger.core.db.model.DBProject;

public class DisplayProjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayProjects() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("projects", getProjects());
		request.getRequestDispatcher("projects.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	private Collection<DBProject> getProjects() {
		IProjectDAO projectDAO = new ProjectDAO();
		return projectDAO.getProjects();
	}

}
