package com.epam.shop.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.shop.exception.EntityDeleteException;
import com.epam.shop.exception.EntityNotFoundException;
import com.epam.shop.exception.EntityRetrieveException;
import com.epam.shop.repo.jdbc.ConnectionPoolProvider;
import com.epam.shop.repo.mapping.RowMapper;

public abstract class AbstractCRUDRepository<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCRUDRepository.class);
	private static final String SELECT_STATEMENT = "SELECT * FROM %s";
	private static final String DELETE_STATEMENT = "DELETE FROM %s WHERE id = %d";
	private static final String SELECT_BY_ID_SQL = SELECT_STATEMENT + " WHERE id = %d";
	private static final String ORDERED_PAGINATED = SELECT_STATEMENT + " ORDER BY %s LIMIT %d OFFSET %d";

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

}
