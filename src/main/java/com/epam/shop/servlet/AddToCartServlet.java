package com.epam.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.shop.domain.Cart;
import com.epam.shop.domain.CartProduct;
import com.epam.shop.domain.Category;
import com.epam.shop.domain.Person;
import com.epam.shop.domain.Product;
import com.epam.shop.exception.UnauthorizedException;
import com.epam.shop.repo.CartProductRepo;
import com.epam.shop.repo.CartRepo;
import com.epam.shop.service.ProductService;

@WebServlet(value = "/add-to-cart", name = "add-to-cart")
public class AddToCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Long pId = Long.valueOf(req.getParameter("pid"));
		Long quantity = Long.valueOf(req.getParameter("quant"));

		Cart attribute = (Cart) req.getSession().getAttribute("cart");

		if (attribute == null) {
			Person person = (Person) req.getSession().getAttribute("user");

			if (person == null) {
				throw new UnauthorizedException();
			}

			Cart findByPersonId = CartRepo.getInstance().findByPersonId(person.getId());
			if (findByPersonId == null) {
				Cart cart = new Cart();
				cart.setPersonId(person.getId());
				CartRepo.getInstance().save(cart);
			}
			attribute = findByPersonId;
			req.getSession().setAttribute("cart", findByPersonId);
		}

		CartProduct cartPr = new CartProduct();
		cartPr.setCartId(attribute.getId());
		cartPr.setProductId(pId);
		cartPr.setQuantity(quantity);

		CartProductRepo.getInstance().save(cartPr);

		req.getSession().setAttribute("cartProducts", CartProductRepo.getInstance().findByCartId(attribute.getId()));

		req.getRequestDispatcher("/cart").forward(req, resp);
	}

}
