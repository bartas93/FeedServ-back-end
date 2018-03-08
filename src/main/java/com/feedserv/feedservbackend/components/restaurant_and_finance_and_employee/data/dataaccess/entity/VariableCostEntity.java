package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.PaymentMethod;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.enums.CostStatus;

@Entity
public class VariableCostEntity extends AbstractEntity {

	@NotNull
	private String name;
	private String description;
	@NotNull
	private BigDecimal cost;
	@NotNull
	private PaymentMethod paymentMethod;
	@NotNull
	private LocalDateTime createdOn;
	@NotNull
	private CostStatus costStatus;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employeeEntity;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	public VariableCostEntity(Long id, String name, String description, BigDecimal cost, PaymentMethod paymentMethod,
			LocalDateTime createdOn, CostStatus costStatus, EmployeeEntity employeeEntity,
			RestaurantEntity restaurantEntity) {
		super(id);
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.paymentMethod = paymentMethod;
		this.createdOn = createdOn;
		this.costStatus = costStatus;
		this.employeeEntity = employeeEntity;
		this.restaurantEntity = restaurantEntity;
	}

	public VariableCostEntity() {
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

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public CostStatus getCostStatus() {
		return costStatus;
	}

	public void setCostStatus(CostStatus costStatus) {
		this.costStatus = costStatus;
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