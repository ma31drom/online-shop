package com.epam.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.shop.dto.ProductWithImages;
import com.epam.shop.service.ProductService;

@WebServlet(value = "/catalog", name = "catalog")
public class CatalogProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<ProductWithImages> products = ProductService.getInstance().getProductsWithImg();

		req.setAttribute("products", products);

		req.getRequestDispatcher("/catalog.jsp").forward(req, resp);
	}

}
