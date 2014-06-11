package com.finna.be.octo.avenger.web.servlets.display;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finna.be.octo.avenger.core.db.dao.ICommentDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.CommentDAO;
import com.finna.be.octo.avenger.core.db.model.DBComment;

public class DisplayComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayComment() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("comment", getComment(request.getParameter("id")));
		request.getRequestDispatcher("comment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	private DBComment getComment(String commentId) {
		long id = 0;
		
		try {
			id = Long.parseLong(commentId);
		} catch (NumberFormatException e) {
			return null;
		}
		
		ICommentDAO commentDAO = new CommentDAO();
		return commentDAO.getById(id);
	}
}
