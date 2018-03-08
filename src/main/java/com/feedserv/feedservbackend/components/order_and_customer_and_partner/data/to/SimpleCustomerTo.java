package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to;

public class SimpleCustomerTo {

	private Long id;
	private String phoneNumber;
	private String name;

	public SimpleCustomerTo() {
	}

	public SimpleCustomerTo(Long id, String phoneNumber, String name) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
