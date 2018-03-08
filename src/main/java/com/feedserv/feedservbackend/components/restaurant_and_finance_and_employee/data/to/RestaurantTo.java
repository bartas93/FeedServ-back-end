package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.AddressTo;

public class RestaurantTo {
	private Long id;
	private String name;
	private String description;
	private String ownerName;
	private String phoneNumber;
	private String email;
	private AddressTo addressTo;
	private RestaurantInfoTo restaurantInfoTo;

	public RestaurantTo() {
	}

	public RestaurantTo(Long id, String name, String description, String ownerName, String phoneNumber, String email,
			AddressTo addressTo, RestaurantInfoTo restaurantInfoTo) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ownerName = ownerName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.addressTo = addressTo;
		this.restaurantInfoTo = restaurantInfoTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressTo getAddressTo() {
		return addressTo;
	}

	public void setAddressTo(AddressTo addressTo) {
		this.addressTo = addressTo;
	}

	public RestaurantInfoTo getRestaurantInfoTo() {
		return restaurantInfoTo;
	}

	public void setRestaurantInfoTo(RestaurantInfoTo restaurantInfoTo) {
		this.restaurantInfoTo = restaurantInfoTo;
	}

}
