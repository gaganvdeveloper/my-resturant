package com.tyss.myresturantapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.myresturantapplication.dao.AdminDao;

@WebServlet("/deleteadmin")
public class DeleteAdminServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (new AdminDao().deleteAdmin(Integer.parseInt(req.getParameter("id")))) {
			resp.sendRedirect("superadminhome.jsp");
		} else {
			PrintWriter writer = resp.getWriter();
			writer.write("<html><body><h1 style='color:red;'>Unable to delete Admin</h1><body><html>");
			resp.sendRedirect("superadminhome.jsp");
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
