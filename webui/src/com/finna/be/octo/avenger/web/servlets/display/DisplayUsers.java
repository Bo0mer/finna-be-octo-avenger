package com.finna.be.octo.avenger.web.servlets.display;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.UserDAO;
import com.finna.be.octo.avenger.core.db.model.DBUser;

public class DisplayUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayUsers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("users", getAllUsers());
		request.getRequestDispatcher("users.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private List<DBUser> getAllUsers() {
		final IUserDAO userDAO = new UserDAO();
		return userDAO.getUsers();
	}

}
