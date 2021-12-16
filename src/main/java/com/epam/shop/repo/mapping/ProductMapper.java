package com.epam.shop.repo.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.shop.domain.Category;
import com.epam.shop.domain.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product toObject(ResultSet rs) throws SQLException {
		Product p = new Product();

		p.setId(rs.getLong("id"));

		p.setCategory(Category.getByOrdinal(rs.getInt("category")));
		p.setDescription(rs.getString("description"));
		p.setName(rs.getString("name"));
		p.setPrice(rs.getBigDecimal("price"));

		return p;
	}

}
