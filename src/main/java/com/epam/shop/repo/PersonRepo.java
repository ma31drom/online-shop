package com.epam.shop.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.shop.domain.Person;
import com.epam.shop.exception.EntitySaveException;
import com.epam.shop.repo.jdbc.ConnectionPoolProvider;
import com.epam.shop.repo.mapping.PersonMapper;

public class PersonRepo extends AbstractCRUDRepository<Person> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonRepo.class);

	private static PersonRepo instance;

	private static final String INSERT_STATEMENT = "INSERT INTO person (last_name, first_name, locked, login, password, email, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STATEMENT = "UPDATE person SET last_name = ?, first_name = ?, locked = ? , login = ?, password = ?, email = ?, role = ? WHERE id = ?";

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

	public Person save(Person person) {
		PreparedStatement ps = null;
		try (Connection connection = ConnectionPoolProvider.getConnection();) {

			if (person.getId() == null) {
				ps = connection.prepareStatement(INSERT_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			} else {
				ps = connection.prepareStatement(UPDATE_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			}

			setValues(person, ps);

			if (person.getId() != null) {
				ps.setLong(8, person.getId());
			}

			if (ps.executeUpdate() != 1) {
				throw new EntitySaveException("Something went wrong");
			}

			ResultSet generatedKeys = ps.getGeneratedKeys();

			if (generatedKeys.next()) {
				person.setId(generatedKeys.getLong(1));
			}

			return person;

		} catch (SQLException e) {
			LOGGER.error("Something whent wrong during users retrieval", e);
			throw new EntitySaveException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new EntitySaveException(e);
				}
			}
		}
	}

	private void setValues(Person person, PreparedStatement ps) throws SQLException {
		ps.setString(1, person.getLastName());
		ps.setString(2, person.getFirstName());
		ps.setBoolean(3, person.getLocked());
		ps.setString(4, person.getLogin());
		ps.setString(5, person.getPassword());
		ps.setString(6, person.getEmail());
		ps.setInt(7, person.getRole().ordinal());
	}
}
