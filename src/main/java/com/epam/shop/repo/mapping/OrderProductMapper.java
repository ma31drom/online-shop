package com.epam.shop.repo.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.shop.domain.OrderProduct;

public class OrderProductMapper implements RowMapper<OrderProduct> {

	@Override
	public OrderProduct toObject(ResultSet rs) throws SQLException {
		OrderProduct p = new OrderProduct();

		p.setId(rs.getLong("id"));

		p.setItemAmount(rs.getBigDecimal("itemAmount"));
		p.setOrderId(rs.getLong("order_id"));
		p.setProductId(rs.getLong("product_id"));
		p.setQuatity(rs.getLong("quantity"));

		return p;
	}

}
