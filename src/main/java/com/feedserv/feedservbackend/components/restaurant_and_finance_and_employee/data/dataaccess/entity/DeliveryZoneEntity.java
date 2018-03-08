package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity;

import java.math.BigDecimal;
import java.time.temporal.ValueRange;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;

@Entity
public class DeliveryZoneEntity extends AbstractEntity {

	private ValueRange kilometrRadious;
	private BigDecimal cost;
	@ManyToOne
	@JoinColumn(name = "restaurant_info_id")
	private RestaurantInfoEntity restaurantInfoEntity;

	public DeliveryZoneEntity() {
	}

	public DeliveryZoneEntity(Long id) {
		super(id);
	}

	public DeliveryZoneEntity(Long id, ValueRange kilometrRadious, BigDecimal cost,
			RestaurantInfoEntity restaurantInfoEntity) {
		super(id);
		this.kilometrRadious = kilometrRadious;
		this.cost = cost;
		this.restaurantInfoEntity = restaurantInfoEntity;
	}

	public ValueRange getKilometrRadious() {
		return kilometrRadious;
	}

	public void setKilometrRadious(ValueRange kilometrRadious) {
		this.kilometrRadious = kilometrRadious;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public RestaurantInfoEntity getRestaurantInfoEntity() {
		return restaurantInfoEntity;
	}

	public void setRestaurantInfoEntity(RestaurantInfoEntity restaurantInfoEntity) {
		this.restaurantInfoEntity = restaurantInfoEntity;
	}

}
