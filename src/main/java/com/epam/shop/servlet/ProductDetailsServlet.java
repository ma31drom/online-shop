package com.epam.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.shop.domain.Product;
import com.epam.shop.dto.ProductWithImages;
import com.epam.shop.service.ProductService;

@WebServlet(value = "/product/details", name = "product-details")
public class ProductDetailsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String parameter = req.getParameter("pId");
		Long valueOf = Long.valueOf(parameter);
		
		ProductWithImages product = ProductService.getInstance().getByIdWithImg(valueOf);

		req.setAttribute("product", product);

		req.getRequestDispatcher("/details.jsp").forward(req, resp);
	}

}
