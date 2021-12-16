package com.epam.shop.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.shop.exception.EntityDeleteException;
import com.epam.shop.exception.EntityNotFoundException;
import com.epam.shop.exception.EntityRetrieveException;
import com.epam.shop.exception.EntitySaveException;
import com.epam.shop.repo.jdbc.ConnectionPoolProvider;
import com.epam.shop.repo.mapping.RowMapper;

public abstract class AbstractCRUDRepository<T extends WithId> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCRUDRepository.class);
	private static final String SELECT_STATEMENT = "SELECT * FROM %s";
	private static final String DELETE_STATEMENT = "DELETE FROM %s WHERE id = %d";
	private static final String SELECT_BY_ID_SQL = SELECT_STATEMENT + " WHERE id = %d";
	private static final String ORDERED_PAGINATED = SELECT_STATEMENT + " ORDER BY %s LIMIT %d OFFSET %d";

	private static final String INSERT_STATEMENT = "INSERT INTO %s (%s) VALUES (%s)";
	private static final String UPDATE_STATEMENT = "UPDATE %s SET %s WHERE id = %s";

	private RowMapper<T> rs;
	private String tableName;

	public AbstractCRUDRepository(RowMapper<T> rs, String tableName) {
		super();
		this.rs = rs;
		this.tableName = tableName;
	}

	public T getById(Long id) {

		try (Connection connection = ConnectionPoolProvider.getConnection()) {

			ResultSet resultSet = connection.createStatement()
					.executeQuery(String.format(SELECT_BY_ID_SQL, tableName, id));

			if (resultSet.next()) {

				T entity = rs.toObject(resultSet);
				return entity;
			} else {
				return null;
			}

		} catch (SQLException e) {
			LOGGER.error("Something went wrong during user retrieval by id=" + id, e);
			throw new EntityNotFoundException();
		}
	}

	public List<T> findAll() {

		try (Connection connection = ConnectionPoolProvider.getConnection()) {

			ResultSet resultSet = connection.createStatement().executeQuery(String.format(SELECT_STATEMENT, tableName));

			List<T> entities = new ArrayList<>();

			while (resultSet.next()) {
				entities.add(rs.toObject(resultSet));
			}

			return entities;

		} catch (SQLException e) {
			LOGGER.error("Something whent wrong during users retrieval", e);
			throw new EntityRetrieveException(e);
		}
	}

	public void deleteById(Long id) {

		try (Connection connection = ConnectionPoolProvider.getConnection()) {

			int rowsAffected = connection.createStatement()
					.executeUpdate(String.format(DELETE_STATEMENT, tableName, id));

			if (rowsAffected != 1) {
				throw new EntityDeleteException("Entity not deleted");
			}

		} catch (SQLException e) {
			LOGGER.error("Something whent wrong during users retrieval", e);
			throw new EntityRetrieveException(e);
		}
	}

	public List<T> findAllSorded(String fieldName, Integer limit, Integer offset) {
		try (Connection connection = ConnectionPoolProvider.getConnection()) {

			ResultSet resultSet = connection.createStatement()
					.executeQuery(String.format(ORDERED_PAGINATED, tableName, fieldName, limit, offset));

			List<T> entities = new ArrayList<>();

			while (resultSet.next()) {
				entities.add(rs.toObject(resultSet));
			}

			return entities;

		} catch (SQLException e) {
			LOGGER.error("Something whent wrong during users retrieval", e);
			throw new EntityRetrieveException(e);
		}
	}

	protected void update(Long id, Map<String, String> toSet) {
		PreparedStatement ps = null;
		try (Connection connection = ConnectionPoolProvider.getConnection()) {

			String pairs = toSet.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue())
					.collect(Collectors.joining(","));

			ps = connection.prepareStatement(String.format(UPDATE_STATEMENT, tableName, pairs, id));

			if (ps.executeUpdate() != 1) {
				throw new EntitySaveException("Something went wrong");
			}

		} catch (SQLException e) {
			LOGGER.error("Something whent wrong during data saving", e);
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

	protected Long create(Map<String, String> toSet) {

		PreparedStatement ps = null;
		try (Connection connection = ConnectionPoolProvider.getConnection();) {

			String csvColumns = toSet.entrySet().stream().map(e -> e.getKey()).collect(Collectors.joining(","));
			String csvValues = toSet.entrySet().stream().map(e -> e.getValue()).collect(Collectors.joining(","));

			ps = connection.prepareStatement(String.format(INSERT_STATEMENT, tableName, csvColumns, csvValues),
					Statement.RETURN_GENERATED_KEYS);

			if (ps.executeUpdate() != 1) {
				throw new EntitySaveException("Something went wrong");
			}

			ResultSet generatedKeys = ps.getGeneratedKeys();

			if (generatedKeys.next()) {
				return generatedKeys.getLong(1);
			} else {
				throw new EntitySaveException("Something went wrong");
			}
		} catch (SQLException e) {
			LOGGER.error("Something whent wrong during data saving retrieval", e);
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

	public T save(T person) {
		if (person.getId() == null) {
			Long create = create(updateValues(person));
			person.setId(create);
			return person;
		} else {
			update(person.getId(), updateValues(person));
			return person;
		}
	}

	protected abstract Map<String, String> updateValues(T person);
}
