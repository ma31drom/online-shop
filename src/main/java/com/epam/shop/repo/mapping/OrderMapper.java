package com.epam.shop.repo.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.shop.domain.Order;
import com.epam.shop.domain.OrderStatus;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order toObject(ResultSet rs) throws SQLException {
		Order p = new Order();

		p.setId(rs.getLong("id"));

		p.setDate(rs.getTimestamp("date").toLocalDateTime());
		p.setDeliveryAdressId(rs.getLong("delivery_address_id"));
		p.setPersonId(rs.getLong("person_id"));

		int int1 = rs.getInt("status");

		p.setStatus(OrderStatus.getByOrdinal(int1));
		p.setTotalAmount(rs.getBigDecimal("total_amount"));

		return p;
	}

}
