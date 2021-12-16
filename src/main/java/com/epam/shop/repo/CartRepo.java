package com.epam.shop.repo;

import java.util.Map;

import com.epam.shop.domain.Cart;
import com.epam.shop.repo.mapping.CartMapper;

public class CartRepo extends AbstractCRUDRepository<Cart> {

	private static CartRepo instance;

	private CartRepo() {
		super(new CartMapper(), "cart");
		instance = this;
	}

	public static CartRepo getInstance() {
		if (instance == null) {
			CartRepo.instance = new CartRepo();
		}
		return instance;
	}

	protected Map<String, String> updateValues(Cart cart) {
		return Map.of("person_id", cart.getPersonId().toString());
	}
}
