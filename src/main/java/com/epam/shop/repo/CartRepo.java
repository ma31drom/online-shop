package com.epam.shop.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.shop.domain.Cart;
import com.epam.shop.domain.ProductPicture;
import com.epam.shop.exception.EntityNotFoundException;
import com.epam.shop.repo.jdbc.ConnectionPoolProvider;
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

	public Cart findByPersonId(Long id) {
		try (Connection connection = ConnectionPoolProvider.getConnection()) {

			ResultSet resultSet = connection.createStatement()
					.executeQuery(String.format(SELECT_STATEMENT + " WHERE person_id=%s", tableName, id));

			while (resultSet.next()) {

				Cart entity = rm.toObject(resultSet);
				return entity;
			}
			return null;

		} catch (SQLException e) {
			LOGGER.error("Something went wrong during product pictures retrieval by id=" + id, e);
			throw new EntityNotFoundException();
		}
	}
}
