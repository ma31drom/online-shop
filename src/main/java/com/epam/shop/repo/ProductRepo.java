package com.epam.shop.repo;

import java.util.Map;

import com.epam.shop.domain.Product;
import com.epam.shop.repo.mapping.ProductMapper;

public class ProductRepo extends AbstractCRUDRepository<Product> {

	private static ProductRepo instance;

	private ProductRepo() {
		super(new ProductMapper(), "product");
		instance = this;
	}

	public static ProductRepo getInstance() {
		if (instance == null) {
			ProductRepo.instance = new ProductRepo();
		}
		return instance;
	}

	protected Map<String, String> updateValues(Product o) {
		return Map.of(
				"name", o.getName(), 
				"description", o.getDescription(), 
				"category", String.valueOf(o.getCategory().ordinal()), 
				"price", o.getPrice().toString()
				);
	}
}
