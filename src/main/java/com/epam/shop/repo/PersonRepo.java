package com.epam.shop.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.epam.shop.domain.Person;
import com.epam.shop.exception.EntityNotFoundException;
import com.epam.shop.repo.jdbc.ConnectionPoolProvider;
import com.epam.shop.repo.mapping.PersonMapper;

public class PersonRepo extends AbstractCRUDRepository<Person> {

	private static PersonRepo instance;

	private PersonRepo() {
		super(new PersonMapper(), "person");
		instance = this;
	}

	public static PersonRepo getInstance() {
		if (instance == null) {
			PersonRepo.instance = new PersonRepo();
		}
		return instance;
	}

	protected Map<String, String> updateValues(Person person) {
		return Map.of("last_name", "'" + person.getLastName() + "'", "first_name", "'" + person.getFirstName() + "'",
				"locked", person.getLocked().toString(), "login", "'" + person.getLogin() + "'", "password",
				"'" + person.getPassword() + "'", "email", "'" + person.getEmail() + "'", "role",
				String.valueOf(person.getRole().ordinal()));
	}

	public Person findByLogin(String login) {
		String SELECT_BY_LOGIN = String.format(SELECT_STATEMENT, " person ").concat("WHERE login = ").concat("'")
				.concat(login).concat("'");
		try (Connection connection = ConnectionPoolProvider.getConnection()) {

			ResultSet resultSet = connection.createStatement().executeQuery(SELECT_BY_LOGIN);

			if (resultSet.next()) {

				Person entity = getRm().toObject(resultSet);
				return entity;
			} else {
				return null;
			}

		} catch (SQLException e) {
			LOGGER.error("Something went wrong during user retrieval by login=" + login, e);
			throw new EntityNotFoundException(e);
		}
	}
}
