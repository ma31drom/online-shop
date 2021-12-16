package com.epam.shop.repo;

import java.util.Map;

import com.epam.shop.domain.CartProduct;
import com.epam.shop.repo.mapping.CartProductMapper;

public class CartProductRepo extends AbstractCRUDRepository<CartProduct> {

	private static CartProductRepo instance;

	private CartProductRepo() {
		super(new CartProductMapper(), "cart_product");
		instance = this;
	}

	public static CartProductRepo getInstance() {
		if (instance == null) {
			CartProductRepo.instance = new CartProductRepo();
		}
		return instance;
	}

	protected Map<String, String> updateValues(CartProduct cartProduct) {
		return Map.of("product_id", cartProduct.getProductId().toString(), "cart_id",
				cartProduct.getCartId().toString(), "quantity", cartProduct.getQuantity().toString());
	}
}
