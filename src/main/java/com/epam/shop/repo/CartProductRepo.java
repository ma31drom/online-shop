package com.epam.shop.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.shop.domain.CartProduct;
import com.epam.shop.exception.EntityNotFoundException;
import com.epam.shop.repo.jdbc.ConnectionPoolProvider;
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

	public List<CartProduct> findByCartId(Long id) {
		try (Connection connection = ConnectionPoolProvider.getConnection()) {

			ResultSet resultSet = connection.createStatement()
					.executeQuery(String.format(SELECT_STATEMENT + " WHERE cart_id=%s", tableName, id));

			List<CartProduct> result = new ArrayList<CartProduct>();
			while (resultSet.next()) {

				CartProduct entity = rm.toObject(resultSet);
				result.add(entity);
			}
			return result;

		} catch (SQLException e) {
			LOGGER.error("Something went wrong during cartItems retrieval by cartId id=" + id, e);
			throw new EntityNotFoundException();
		}
	}

}
