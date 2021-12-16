package com.epam.shop.domain;

import com.epam.shop.repo.WithId;

public class Cart implements WithId{

	private Long id;
	private Long personId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

}
