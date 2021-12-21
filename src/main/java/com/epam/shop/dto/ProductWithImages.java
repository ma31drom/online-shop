package com.epam.shop.dto;

import java.util.ArrayList;
import java.util.List;

import com.epam.shop.domain.Product;
import com.epam.shop.domain.ProductPicture;

public class ProductWithImages extends Product {

	private List<ProductPicture> imgs = new ArrayList<ProductPicture>();

	public List<ProductPicture> getImgs() {
		return imgs;
	}

	public void setImgs(List<ProductPicture> imgs) {
		this.imgs = imgs;
	}

	public void addImg(ProductPicture pics) {
		imgs.add(pics);
	}

	public void addImgs(List<ProductPicture> pics) {
		imgs.addAll(pics);
	}
}
