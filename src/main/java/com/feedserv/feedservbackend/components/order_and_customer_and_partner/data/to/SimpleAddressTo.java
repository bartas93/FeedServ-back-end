package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to;

public class SimpleAddressTo {
	private Long id;
	private String city;
	private String street;
	private String streetNumber;
	private String localNumber;

	public SimpleAddressTo() {
	}

	public SimpleAddressTo(Long id, String city, String street, String streetNumber, String localNumber) {
		super();
		this.id = id;
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.localNumber = localNumber;
	}

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

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getLocalNumber() {
		return localNumber;
	}

	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}

}
