package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.AddressEntity;

@Entity
public class RestaurantEntity extends AbstractEntity {

	@NotNull
	private String name;
	@NotNull
	private String description;
	@NotNull
	private String ownerName;
	@NotNull
	private String phoneNumber;
	@Email
	private String email;
	@ManyToOne
	@JoinColumn(name = "address_id")
	private AddressEntity addressEntity;
	@OneToOne
	@JoinColumn(name = "restaurant_info_id")
	private RestaurantInfoEntity restaurantInfoEntity;

	public RestaurantEntity() {
	}

	public RestaurantEntity(Long id) {
		super(id);
	}

	public RestaurantEntity(Long id, String name, String description, String ownerName, String phoneNumber,
			String email, AddressEntity addressEntity, RestaurantInfoEntity restaurantInfoEntity) {
		super(id);
		this.name = name;
		this.description = description;
		this.ownerName = ownerName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.addressEntity = addressEntity;
		this.restaurantInfoEntity = restaurantInfoEntity;
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

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

	public RestaurantInfoEntity getRestaurantInfoEntity() {
		return restaurantInfoEntity;
	}

	public void setRestaurantInfoEntity(RestaurantInfoEntity restaurantInfoEntity) {
		this.restaurantInfoEntity = restaurantInfoEntity;
	}

}