package com.tyss.myresturantapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.myresturantapplication.dao.SuperAdminDao;
import com.tyss.myresturantapplication.dto.SuperAdmin;

@WebServlet("/superadminlogin")
public class SuperAdminLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		SuperAdminDao dao = new SuperAdminDao();
		SuperAdmin sadmin = dao.verifySuperAdmin(email, password);
		RequestDispatcher dispatcher = null;
		PrintWriter writer = resp.getWriter();
		if (sadmin != null) {
			HttpSession session = req.getSession();
			session.setAttribute("sadmin", sadmin);
			session.setAttribute("role", "SuperAdmin");
			session.setAttribute("name", sadmin.getName());
			resp.sendRedirect("superadminhome.jsp");
		} else {
			writer.write("<html><body><h1 style='color=red;'>Invalid Credentials</h1></body></html>");
			dispatcher = req.getRequestDispatcher("superadminlogin.jsp");
			dispatcher.include(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
