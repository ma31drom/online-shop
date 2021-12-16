package com.epam.shop.repo.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.shop.domain.ProductAttribute;

public class ProductAttributeMapper implements RowMapper<ProductAttribute> {

	@Override
	public ProductAttribute toObject(ResultSet rs) throws SQLException {
		ProductAttribute p = new ProductAttribute();

		p.setId(rs.getLong("id"));

		p.setName(rs.getString("name"));
		p.setValue(rs.getString("value"));

		p.setProductId(rs.getLong("product_id"));

		return p;
	}

}
