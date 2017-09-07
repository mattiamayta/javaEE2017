package com.bari.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bari.BusinessDelegate;
import com.bari.model.User;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_USER = "/listuser.jsp";
	private BusinessDelegate bd;

	public UserController() {
		super();
		bd = new BusinessDelegate();
		bd.setServiceType("dao");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("listuser")) {
			forward = LIST_USER;
			request.setAttribute("users", bd.getAllUsers());
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setUname(request.getParameter("uname"));
		user.setPassword(request.getParameter("pass"));
		try {
			Date reg = new SimpleDateFormat("dd/mm/yyyy").parse(request.getParameter("dob"));
			System.out.println("Registrato: " + reg);
			user.setRegisteredon(reg);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setEmail(request.getParameter("email"));
		String userid = request.getParameter("uname");
		if (userid == null || userid.isEmpty()) {
			bd.addUser(user);
		} else {
			user.setUname(userid);
			bd.checkUser(user);
		}
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("users", bd.getAllUsers());
		view.forward(request, response);
	}
}