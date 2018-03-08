package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.enums.DayOfWeek;

@Entity
public class OpeningTimesEntity extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "restaurant_info_id")
	private RestaurantInfoEntity restaurantInfoEntity;

	private DayOfWeek dayOfWeek;
	private LocalTime openFrom;
	private LocalTime openTo;

	public OpeningTimesEntity() {
	}

	public OpeningTimesEntity(Long id) {
		super(id);
	}

	public OpeningTimesEntity(Long id, RestaurantInfoEntity restaurantInfoEntity, DayOfWeek dayOfWeek,
			LocalTime openFrom, LocalTime openTo) {
		super(id);
		this.restaurantInfoEntity = restaurantInfoEntity;
		this.dayOfWeek = dayOfWeek;
		this.openFrom = openFrom;
		this.openTo = openTo;
	}

	public RestaurantInfoEntity getRestaurantInfoEntity() {
		return restaurantInfoEntity;
	}

	public void setRestaurantInfoEntity(RestaurantInfoEntity restaurantInfoEntity) {
		this.restaurantInfoEntity = restaurantInfoEntity;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getOpenFrom() {
		return openFrom;
	}

	public void setOpenFrom(LocalTime openFrom) {
		this.openFrom = openFrom;
	}

	public LocalTime getOpenTo() {
		return openTo;
	}

	public void setOpenTo(LocalTime openTo) {
		this.openTo = openTo;
	}

}
