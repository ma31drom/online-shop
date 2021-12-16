package com.epam.shop.domain;

import java.util.Arrays;

public enum PaymentStatus {

	NEW, EXECUTED;

	public static PaymentStatus getByOrdinal(int ordinal) {
		return Arrays.asList(PaymentStatus.values()).stream().filter(pr -> ordinal == pr.ordinal()).findFirst().get();
	}
}
