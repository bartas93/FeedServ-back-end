package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.enums.SafeStatus;

@Entity
public class SafeEntity extends AbstractEntity {
	@NotNull
	private String name;
	@NotNull
	@DecimalMin("0,00")
	private BigDecimal cashAmount;
	@NotNull
	private LocalDate date;
	@NotNull
	private SafeStatus safeStatus;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employeeEntity;

	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	public SafeEntity(Long id, String name, BigDecimal cashAmount, LocalDate date, SafeStatus safeStatus,
			EmployeeEntity employeeEntity, RestaurantEntity restaurantEntity) {
		super(id);
		this.name = name;
		this.cashAmount = cashAmount;
		this.date = date;
		this.safeStatus = safeStatus;
		this.employeeEntity = employeeEntity;
		this.restaurantEntity = restaurantEntity;
	}

	public SafeEntity() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public SafeStatus getSafeStatus() {
		return safeStatus;
	}

	public void setSafeStatus(SafeStatus safeStatus) {
		this.safeStatus = safeStatus;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

}