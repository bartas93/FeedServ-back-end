package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to;

import java.util.List;

public class CustomerWithoutOrdersTo {
	private Long id;
	private String phoneNumber;
	private String name;
	private String email;
	private String description;
	private Boolean isOnBlackList;
	private List<AddressTo> addressTos;

	public CustomerWithoutOrdersTo() {
	}

	public CustomerWithoutOrdersTo(Long id, String phoneNumber, String name, String email, String description, Boolean isOnBlackList,
			List<AddressTo> addressTos) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
		this.description = description;
		this.isOnBlackList = isOnBlackList;
		this.addressTos = addressTos;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsOnBlackList() {
		return isOnBlackList;
	}

	public void setIsOnBlackList(Boolean isOnBlackList) {
		this.isOnBlackList = isOnBlackList;
	}

	public List<AddressTo> getAddressTos() {
		return addressTos;
	}

	public void setAddressTos(List<AddressTo> addressTos) {
		this.addressTos = addressTos;
	}

}
