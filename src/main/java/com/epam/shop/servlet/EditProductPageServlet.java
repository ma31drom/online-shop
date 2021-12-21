package com.epam.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.shop.domain.Category;
import com.epam.shop.domain.Product;
import com.epam.shop.service.ProductService;

@WebServlet(value = "/editProduct", name = "edit-product")
public class EditProductPageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("productId");
		
		Product product = ProductService.getInstance().getById(Long.valueOf(id));

		req.setAttribute("product", product);

		req.getRequestDispatcher("/editProduct.jsp").forward(req, resp);
	}

}
