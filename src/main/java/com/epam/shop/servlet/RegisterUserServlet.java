package com.epam.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.shop.service.UserService;

@WebServlet(value = "/register", name = "register")
public class RegisterUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");

		req.getSession().setAttribute("user",
				UserService.getInstance().registerUser(fname, lname, login, password, email));

		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
