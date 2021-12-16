package com.epam.shop.repo;

import java.util.Map;

import com.epam.shop.domain.OrderProduct;
import com.epam.shop.repo.mapping.OrderProductMapper;

public class OrderProductRepo extends AbstractCRUDRepository<OrderProduct> {

	private static OrderProductRepo instance;

	private OrderProductRepo() {
		super(new OrderProductMapper(), "order_product");
		instance = this;
	}

	public static OrderProductRepo getInstance() {
		if (instance == null) {
			OrderProductRepo.instance = new OrderProductRepo();
		}
		return instance;
	}

	protected Map<String, String> updateValues(OrderProduct o) {
		return Map.of("quantity", o.getQuatity().toString(), "itemAmount", o.getItemAmount().toString(), "order_id",
				o.getOrderId().toString(), "product_id", o.getProductId().toString());
	}
}
