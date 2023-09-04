package com.tyss.myresturantapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.tyss.myresturantapplication.dao.AdminDao;
import com.tyss.myresturantapplication.dto.Admin;

@MultipartConfig
@WebServlet(urlPatterns = "/createadmin", loadOnStartup = 1)
public class CreateAdminServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		Part p = req.getPart("image");
		byte[] img = new byte[p.getInputStream().available()];

		p.getInputStream().read(img);

		AdminDao dao = new AdminDao();
		Admin admin = new Admin();
		admin.setName(name);
		admin.setEmail(email);
		admin.setPassword(password);
		admin.setRole(role);
		admin.setBranchs(null);
		admin.setImage(img);
		dao.saveAdmin(admin);
		resp.sendRedirect("superadminhome.jsp");
//		RequestDispatcher dispatcher  = req.getRequestDispatcher("superadminhome.jsp");
//		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
