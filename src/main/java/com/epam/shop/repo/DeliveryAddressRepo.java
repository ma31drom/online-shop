package com.epam.shop.repo;

import java.util.Map;

import com.epam.shop.domain.DeliveryAddress;
import com.epam.shop.repo.mapping.DeliveryAddressMapper;

public class DeliveryAddressRepo extends AbstractCRUDRepository<DeliveryAddress> {

	private static DeliveryAddressRepo instance;

	private DeliveryAddressRepo() {
		super(new DeliveryAddressMapper(), "delivery_address");
		instance = this;
	}

	public static DeliveryAddressRepo getInstance() {
		if (instance == null) {
			DeliveryAddressRepo.instance = new DeliveryAddressRepo();
		}
		return instance;
	}

	protected Map<String, String> updateValues(DeliveryAddress cartProduct) {
		return Map.of(
				"city", cartProduct.getCity().toString(), 
				"street", cartProduct.getStreet().toString(),
				"house_num", cartProduct.getHouseNum().toString(), 
				"flat_num", cartProduct.getFlatNum().toString(), 
				"person_id", cartProduct.getPersonId().toString()
				);
	}
}
