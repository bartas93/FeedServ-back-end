package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.enums.CostStatus;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.enums.Repeatability;

@Entity
public class FixedCostEntity extends AbstractEntity {

	@NotNull
	private String name;
	private String description;
	@NotNull
	private BigDecimal cost;
	@NotNull
	private Repeatability repeatability;
	@NotNull
	private CostStatus costStatus;
	@Min(0)
	@Max(31)
	private Integer payment_day;

	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	public FixedCostEntity(Long id, String name, String description, BigDecimal cost, Repeatability repeatability,
			CostStatus costStatus, Integer payment_day, RestaurantEntity restaurantEntity) {
		super(id);
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.repeatability = repeatability;
		this.costStatus = costStatus;
		this.payment_day = payment_day;
		this.restaurantEntity = restaurantEntity;
	}

	public FixedCostEntity() {
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

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Repeatability getRepeatability() {
		return repeatability;
	}

	public void setRepeatability(Repeatability repeatability) {
		this.repeatability = repeatability;
	}

	public CostStatus getCostStatus() {
		return costStatus;
	}

	public void setCostStatus(CostStatus costStatus) {
		this.costStatus = costStatus;
	}

	public Integer getPayment_day() {
		return payment_day;
	}

	public void setPayment_day(Integer payment_day) {
		this.payment_day = payment_day;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

}