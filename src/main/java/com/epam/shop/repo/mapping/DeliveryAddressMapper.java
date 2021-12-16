package com.epam.shop.repo.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.shop.domain.DeliveryAddress;

public class DeliveryAddressMapper implements RowMapper<DeliveryAddress> {

	@Override
	public DeliveryAddress toObject(ResultSet rs) throws SQLException {
		DeliveryAddress p = new DeliveryAddress();

		p.setId(rs.getLong("id"));

		p.setCity(rs.getString("city"));
		p.setStreet(rs.getString("street"));
		p.setHouseNum(rs.getString("house_num"));
		p.setFlatNum(rs.getString("flat_num"));

		p.setPersonId(rs.getLong("person_id"));

		return p;
	}

}
