package com.epam.shop.repo;

import java.util.Map;

import com.epam.shop.domain.ProductPicture;
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
		return Map.of(
				"name", o.getName(), 
				"picture_path", o.getPicturePath(), 
				"product_id", o.getProductId().toString()
				);
	}
}
