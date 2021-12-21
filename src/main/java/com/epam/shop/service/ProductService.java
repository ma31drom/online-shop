package com.epam.shop.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.shop.domain.Category;
import com.epam.shop.domain.Product;
import com.epam.shop.domain.ProductPicture;
import com.epam.shop.dto.ProductWithImages;
import com.epam.shop.repo.ProductPictureRepo;
import com.epam.shop.repo.ProductRepo;

public class ProductService {

	public static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	private static ProductService instance;

	private ProductService() {

		instance = this;
	}

	public static ProductService getInstance() {
		if (instance == null) {
			ProductService.instance = new ProductService();
		}
		return instance;
	}

	public Product createProduct(String name, String description, Category catogory, Integer price) {

		Product product = new Product();

		product.setName(name);
		product.setDescription(description);
		product.setPrice(BigDecimal.valueOf(price));
		product.setCategory(catogory);

		Product save = ProductRepo.getInstance().save(product);

		return save;
	}

	public Product updateProduct(Long id, String name, String description, Category catogory, Integer price) {

		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(BigDecimal.valueOf(price));
		product.setCategory(catogory);

		Product save = ProductRepo.getInstance().save(product);

		return save;
	}

	public List<Product> getProducts() {
		return ProductRepo.getInstance().findAll();
	}

	public List<ProductWithImages> getProductsWithImg() {
		List<Product> findAll = ProductRepo.getInstance().findAll();
		return findAll.stream().map(product -> {

			List<ProductPicture> pics = ProductPictureRepo.getInstance().findByProductId(product.getId());

			ProductWithImages productWithImages = new ProductWithImages();
			productWithImages.setId(product.getId());
			productWithImages.setCategory(product.getCategory());
			productWithImages.setName(product.getName());
			productWithImages.setDescription(product.getDescription());
			productWithImages.setPrice(product.getPrice());
			productWithImages.setImgs(pics);
			return productWithImages;
		}).collect(Collectors.toList());

	}

	public Product getById(Long id) {

		return ProductRepo.getInstance().getById(id);
	}

}
