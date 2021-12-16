package com.epam.shop.domain;

import java.util.Arrays;

public enum OrderStatus {

	NEW, PAYED, DELIVERED;

	public static OrderStatus getByOrdinal(int ordinal) {
		return Arrays.asList(OrderStatus.values()).stream().filter(pr -> ordinal == pr.ordinal()).findFirst().get();
	}
}
