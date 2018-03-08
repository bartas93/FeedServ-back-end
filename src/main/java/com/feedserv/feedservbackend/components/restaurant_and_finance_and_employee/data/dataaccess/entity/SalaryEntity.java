package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;

@Entity
public class SalaryEntity extends AbstractEntity {

	@NotNull
	private LocalDate salary_date_from;
	@NotNull
	private LocalDate salary_date_to;
	private LocalDate salary_created_date;
	@NotNull
	private BigDecimal paymentAmount;
	private BigDecimal bonus;
	private Integer totalWorkingTimeInHours;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employeeEntity;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	public SalaryEntity(Long id, LocalDate salary_date_from, LocalDate salary_date_to, LocalDate salary_created_date,
			BigDecimal paymentAmount, BigDecimal bonus, Integer totalWorkingTimeInHours, EmployeeEntity employeeEntity,
			RestaurantEntity restaurantEntity) {
		super(id);
		this.salary_date_from = salary_date_from;
		this.salary_date_to = salary_date_to;
		this.salary_created_date = salary_created_date;
		this.paymentAmount = paymentAmount;
		this.bonus = bonus;
		this.totalWorkingTimeInHours = totalWorkingTimeInHours;
		this.employeeEntity = employeeEntity;
		this.restaurantEntity = restaurantEntity;
	}

	public SalaryEntity() {
	}

	public LocalDate getSalary_date_from() {
		return salary_date_from;
	}

	public void setSalary_date_from(LocalDate salary_date_from) {
		this.salary_date_from = salary_date_from;
	}

	public LocalDate getSalary_date_to() {
		return salary_date_to;
	}

	public void setSalary_date_to(LocalDate salary_date_to) {
		this.salary_date_to = salary_date_to;
	}

	public LocalDate getSalary_created_date() {
		return salary_created_date;
	}

	public void setSalary_created_date(LocalDate salary_created_date) {
		this.salary_created_date = salary_created_date;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public Integer getTotalWorkingTimeInHours() {
		return totalWorkingTimeInHours;
	}

	public void setTotalWorkingTimeInHours(Integer totalWorkingTimeInHours) {
		this.totalWorkingTimeInHours = totalWorkingTimeInHours;
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