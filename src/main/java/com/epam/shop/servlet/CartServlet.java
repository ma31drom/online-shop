package com.epam.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.shop.domain.CartProduct;
import com.epam.shop.dto.ProductWithImages;
import com.epam.shop.dto.QuantifiedProduct;
import com.epam.shop.service.ProductService;

@WebServlet(value = "/cart", name = "cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		@SuppressWarnings("unchecked")
		List<CartProduct> cartProducts = (List<CartProduct>) req.getSession().getAttribute("cartProducts");

		List<QuantifiedProduct> qProducts = new ArrayList<QuantifiedProduct>();
		if (cartProducts != null) {
			qProducts = cartProducts.stream().map(cp -> {
				ProductWithImages byIdWithImg = ProductService.getInstance().getByIdWithImg(cp.getProductId());
				QuantifiedProduct result = new QuantifiedProduct();
				result.setCategory(byIdWithImg.getCategory());
				result.setDescription(byIdWithImg.getDescription());
				result.setId(byIdWithImg.getId());
				result.setImgs(byIdWithImg.getImgs());
				result.setName(byIdWithImg.getName());
				result.setPrice(byIdWithImg.getPrice());
				result.setQuantity(cp.getQuantity());
				return result;
			}).collect(Collectors.toList());
		}
		req.setAttribute("productsInCart", qProducts);

		req.getRequestDispatcher("/cart.jsp").forward(req, resp);
	}

}
