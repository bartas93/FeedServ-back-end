package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;

@Entity
public class CustomerEntity extends AbstractEntity {

	private String phoneNumber;
	private String name;
	private String email;
	private String description;
	private Boolean isOnBlackList;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "addressers_customers", joinColumns = {
			@JoinColumn(name = "customer_id") }, inverseJoinColumns = { @JoinColumn(name = "address_id") })
	private List<AddressEntity> addressEntities;

	@OneToMany(mappedBy = "customerEntity")
	private List<OrderEntity> orderEntities;

	public CustomerEntity() {
	}

	public CustomerEntity(Long id) {
		super(id);
	}

	public CustomerEntity(Long id, String phoneNumber, String name, String email, String description,
			boolean isOnBlackList, List<AddressEntity> addressEntities, List<OrderEntity> orderEntities) {
		super(id);
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
		this.description = description;
		this.isOnBlackList = isOnBlackList;
		this.addressEntities = addressEntities;
		this.orderEntities = orderEntities;
	}

	public CustomerEntity(Long id, String phoneNumber, String name, String email, String description,
			Boolean isOnBlackList, List<AddressEntity> addressEntities) {
		super(id);
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
		this.description = description;
		this.isOnBlackList = isOnBlackList;
		this.addressEntities = addressEntities;
	}

	public void addAddressEntity(AddressEntity addressEntity) {
		addressEntities.add(addressEntity);
	}

	public void removeAddressEntity(AddressEntity addressEntity) {
		addressEntities.remove(addressEntity);
	}

	public void addOrderEntity(OrderEntity orderEntity) {
		orderEntities.add(orderEntity);
		orderEntity.setCustomerEntity(this);
	}

	public void removeOrderEntity(OrderEntity orderEntity) {
		orderEntities.remove(orderEntity);
		orderEntity.setCustomerEntity(null);
	}

	public boolean isOnBlackList() {
		return isOnBlackList;
	}

	public void setOnBlackList(boolean isOnBlackList) {
		this.isOnBlackList = isOnBlackList;
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

	public List<AddressEntity> getAddressEntities() {
		return addressEntities;
	}

	public void setAddressEntities(List<AddressEntity> addressEntities) {
		this.addressEntities = addressEntities;
	}

	public List<OrderEntity> getOrderEntities() {
		return orderEntities;
	}

	public void setOrderEntities(List<OrderEntity> orderEntities) {
		this.orderEntities = orderEntities;
	}

}