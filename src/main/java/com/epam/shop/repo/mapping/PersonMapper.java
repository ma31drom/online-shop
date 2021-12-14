package com.epam.shop.repo.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.shop.domain.Person;
import com.epam.shop.domain.PersonRole;

public class PersonMapper implements RowMapper<Person> {

	@Override
	public Person toObject(ResultSet rs) throws SQLException {
		Person p = new Person();

		p.setId(rs.getLong("id"));
		p.setLastName(rs.getString("last_name"));
		p.setFirstName(rs.getString("first_name"));
		p.setLocked(rs.getBoolean("locked"));
		p.setLogin(rs.getString("login"));
		p.setPassword(rs.getString("password"));
		p.setEmail(rs.getString("email"));

		int ordinal = rs.getInt("role");
		p.setRole(PersonRole.getByOrdinal(ordinal));

		return p;
	}

}
