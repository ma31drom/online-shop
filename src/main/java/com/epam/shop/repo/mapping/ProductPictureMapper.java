package com.epam.shop.repo.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.shop.domain.ProductPicture;

public class ProductPictureMapper implements RowMapper<ProductPicture> {

	@Override
	public ProductPicture toObject(ResultSet rs) throws SQLException {
		ProductPicture p = new ProductPicture();

		p.setId(rs.getLong("id"));

		p.setPicturePath(rs.getString("picture_path"));
		p.setName(rs.getString("name"));

		p.setProductId(rs.getLong("product_id"));

		return p;
	}

}
