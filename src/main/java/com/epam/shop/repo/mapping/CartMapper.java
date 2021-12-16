package com.epam.shop.repo.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.shop.domain.Cart;

public class CartMapper implements RowMapper<Cart> {

	@Override
	public Cart toObject(ResultSet rs) throws SQLException {
		Cart p = new Cart();

		p.setId(rs.getLong("id"));
		p.setPersonId(rs.getLong("person_id"));

		return p;
	}

}
