package com.epam.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.shop.domain.Person;
import com.epam.shop.service.UserService;

@WebServlet(value = "/login", name = "login")
public class LoginUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");

		Person user = UserService.getInstance().login(login, password);

		req.getSession().setAttribute("user", user);

		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
