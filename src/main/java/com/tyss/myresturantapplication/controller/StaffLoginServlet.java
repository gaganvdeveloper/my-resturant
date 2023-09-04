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

import com.tyss.myresturantapplication.dao.StaffDao;
import com.tyss.myresturantapplication.dto.Staff;

@WebServlet(value = "/stafflogin")
public class StaffLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StaffDao dao = new StaffDao();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		PrintWriter writer=resp.getWriter();
		
		Staff staff = dao.verifyStaffByEmailAndPassword(email, password);
		if (staff != null) {
			req.setAttribute("satff", staff);
			RequestDispatcher dispatcher = req.getRequestDispatcher("staffhome.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			writer.write("<html><body>");
			writer.write("<h1 style='color='red';'>Login Fail Invalid Credentials</h1>");
			writer.write("</body></html>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("stafflogin.jsp");
			dispatcher.include(req, resp);
		}

	}

}
