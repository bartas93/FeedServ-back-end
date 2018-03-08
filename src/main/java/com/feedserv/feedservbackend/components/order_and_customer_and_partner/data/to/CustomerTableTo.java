package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to;

import java.math.BigDecimal;

public class CustomerTableTo {
	private Long customerId;
	private String phoneNumber;
	private String name;
	private String email;
	private Boolean isOnBlackList;
	private BigDecimal totalPaidMoney;
	private int quantityOfOrders;
	private String addresses;

	public CustomerTableTo() {
	}

	public CustomerTableTo(Long customerId, String phoneNumber, String name, String email, Boolean isOnBlackList,
			BigDecimal totalPaidMoney, int quantityOfOrders, String addresses) {
		super();
		this.customerId = customerId;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
		this.isOnBlackList = isOnBlackList;
		this.totalPaidMoney = totalPaidMoney;
		this.quantityOfOrders = quantityOfOrders;
		this.addresses = addresses;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public Boolean getIsOnBlackList() {
		return isOnBlackList;
	}

	public void setIsOnBlackList(Boolean isOnBlackList) {
		this.isOnBlackList = isOnBlackList;
	}

	public BigDecimal getTotalPaidMoney() {
		return totalPaidMoney;
	}

	public void setTotalPaidMoney(BigDecimal totalPaidMoney) {
		this.totalPaidMoney = totalPaidMoney;
	}

	public int getQuantityOfOrders() {
		return quantityOfOrders;
	}

	public void setQuantityOfOrders(int quantityOfOrders) {
		this.quantityOfOrders = quantityOfOrders;
	}

	public String getAddresses() {
		return addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

}
