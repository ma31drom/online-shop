package com.epam.shop.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.shop.domain.ProductPicture;
import com.epam.shop.exception.EntityNotFoundException;
import com.epam.shop.repo.jdbc.ConnectionPoolProvider;
import com.epam.shop.repo.mapping.ProductPictureMapper;

public class ProductPictureRepo extends AbstractCRUDRepository<ProductPicture> {

	private static ProductPictureRepo instance;

	private ProductPictureRepo() {
		super(new ProductPictureMapper(), "product_picture");
		instance = this;
	}

	public static ProductPictureRepo getInstance() {
		if (instance == null) {
			ProductPictureRepo.instance = new ProductPictureRepo();
		}
		return instance;
	}

	protected Map<String, String> updateValues(ProductPicture o) {
		return Map.of("name", "'" + o.getName() + "'", "picture_path", "'" + o.getPicturePath() + "'", "product_id",
				o.getProductId().toString());
	}

	public List<ProductPicture> findByProductId(Long id) {
		try (Connection connection = ConnectionPoolProvider.getConnection()) {

			ResultSet resultSet = connection.createStatement()
					.executeQuery(String.format(SELECT_STATEMENT + " WHERE product_id=%s", tableName, id));

			List<ProductPicture> result = new ArrayList<ProductPicture>();
			while (resultSet.next()) {

				ProductPicture entity = rm.toObject(resultSet);
				result.add(entity);
			}
			return result;

		} catch (SQLException e) {
			LOGGER.error("Something went wrong during product pictures retrieval by id=" + id, e);
			throw new EntityNotFoundException();
		}
	}
}
