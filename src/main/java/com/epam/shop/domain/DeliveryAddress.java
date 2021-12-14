package com.epam.shop.domain;

public class DeliveryAddress {

	private Long id;
	private String city;
	private String street;
	private String houseNum;
	private String flatNum;
	private String personId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getFlatNum() {
		return flatNum;
	}

	public void setFlatNum(String flatNum) {
		this.flatNum = flatNum;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}
