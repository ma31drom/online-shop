package com.epam.shop.repo.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.shop.domain.CartProduct;

public class CartProductMapper implements RowMapper<CartProduct> {

	@Override
	public CartProduct toObject(ResultSet rs) throws SQLException {
		CartProduct p = new CartProduct();

		p.setId(rs.getLong("id"));
		p.setCartId(rs.getLong("cart_id"));
		p.setProductId(rs.getLong("product_id"));
		p.setQuantity(rs.getLong("quantity"));

		return p;
	}

}
