package com.bari.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bari.model.User;
import com.bari.BusinessDelegate;
import com.bari.ServiceType;

/**
 * Servlet implementation class UserModify
 */
public class UserModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_USER = "/listuser.jsp";
	private static String INSERT_OR_EDIT = "/user.jsp";
	private BusinessDelegate bd;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserModify() {
		super();
		bd = new BusinessDelegate();
		bd.setServiceType("dao");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action").toLowerCase();
		String userId = request.getParameter("userId");

		switch (action) {
		case "delete":
			bd.deleteUser(userId);
			forward = LIST_USER;
			request.setAttribute("users", bd.getAllUsers());
			break;
		case "update":
			forward = INSERT_OR_EDIT;
			User user = bd.getUserById(userId);
			request.setAttribute("user", user);
			break;
		case "add new user":
			forward= INSERT_OR_EDIT;
			break;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
