package com.epam.shop.repo;

import java.util.Map;

import com.epam.shop.domain.ProductAttribute;
import com.epam.shop.repo.mapping.ProductAttributeMapper;

public class ProductAttributeRepo extends AbstractCRUDRepository<ProductAttribute> {

	private static ProductAttributeRepo instance;

	private ProductAttributeRepo() {
		super(new ProductAttributeMapper(), "product_attribute");
		instance = this;
	}

	public static ProductAttributeRepo getInstance() {
		if (instance == null) {
			ProductAttributeRepo.instance = new ProductAttributeRepo();
		}
		return instance;
	}

	protected Map<String, String> updateValues(ProductAttribute o) {
		return Map.of(
				"name", o.getName(), 
				"value", o.getValue(), 
				"product_id", o.getProductId().toString()
				);
	}
}
