package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;

@Entity
public class AddressEntity extends AbstractEntity {

	private String country;
	@NotNull
	private String city;
	private String postCode;
	@NotNull
	private String street;
	@NotNull
	private String streetNumber;
	private String localNumber;
	private String floor;
	private String comments;

	public AddressEntity() {
	}

	public AddressEntity(Long id) {
		super(id);
	}

	public AddressEntity(Long id, String country, String city, String postCode, String street, String streetNumber,
			String localNumber, String floor, String comments) {
		super(id);
		this.country = country;
		this.city = city;
		this.postCode = postCode;
		this.street = street;
		this.streetNumber = streetNumber;
		this.localNumber = localNumber;
		this.floor = floor;
		this.comments = comments;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
