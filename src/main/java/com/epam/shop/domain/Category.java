package com.epam.shop.domain;

import java.util.Arrays;

public enum Category {

	KITCHEN, BATHROOM, GARDEN;

	public static Category getByOrdinal(int ordinal) {
		return Arrays.asList(Category.values()).stream().filter(pr -> ordinal == pr.ordinal()).findFirst().get();
	}
}
