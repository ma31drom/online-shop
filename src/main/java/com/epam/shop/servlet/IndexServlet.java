package com.epam.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.shop.domain.Person;
import com.epam.shop.service.ProductService;
import com.epam.shop.service.UserService;

@WebServlet(value = "/index", name = "index")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("products", ProductService.getInstance().getProductsWithImg());
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
