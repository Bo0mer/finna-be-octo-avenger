package com.finna.be.octo.avenger.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.impl.RoleDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.UserDAO;
import com.finna.be.octo.avenger.core.db.model.DBRole;
import com.finna.be.octo.avenger.core.db.model.DBUser;
import com.finna.be.octo.avenger.dao.exceptions.DAOException;

@WebServlet("/CreateUser")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UserDAO userDAO = new UserDAO();
		RoleDAO roleDAO = new RoleDAO();
		
		DBUser user = createUser(request);
		DBRole role = new DBRole();
		role.setRoleName("user");
		role.setUserName(user.getUsername());
		
		
		try {
			userDAO.createUser(user);
			roleDAO.createRole(role);
		} catch (DAOException e) {
			e.printStackTrace();
			// TODO: redirect to error page.
			response.sendRedirect("error.jsp");
			return;
		}
				
		response.sendRedirect("projects.jsp");
		return;
	}

	private DBUser createUser(HttpServletRequest request) {
		// TODO: Validations
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		DBUser user = new DBUser();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setFullName(name);
		return user;
	}
}
