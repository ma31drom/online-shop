package com.epam.shop.repo.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.shop.domain.Payment;
import com.epam.shop.domain.PaymentStatus;

public class PaymentMapper implements RowMapper<Payment> {

	@Override
	public Payment toObject(ResultSet rs) throws SQLException {
		Payment p = new Payment();

		p.setId(rs.getLong("id"));

		p.setOrderId(rs.getLong("order_id"));
		p.setStatus(PaymentStatus.getByOrdinal(rs.getInt("status")));

		return p;
	}

}
