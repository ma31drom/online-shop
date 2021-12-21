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

@WebServlet(value = "/create-product", name = "create-product")
public class CreateProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pId = req.getParameter("productId");
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String category = req.getParameter("category");
		String price = req.getParameter("price");
		Category byName = Category.getByName(category);
		Integer valueOf = Integer.valueOf(price);
		if (pId == null) {
			Product product = ProductService.getInstance().createProduct(name, description, byName, valueOf);
			req.setAttribute("createdProduct", product);
		} else {
			Product product = ProductService.getInstance().updateProduct(Long.valueOf(pId), name, description, byName, valueOf);
			req.setAttribute("updatedProduct", product);
		}

		req.getRequestDispatcher("/list-product").forward(req, resp);
	}

}
