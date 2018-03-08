package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.enums.SalaryType;

@Entity
public class EmployeeRoleEntity extends AbstractEntity {

	@Enumerated(EnumType.STRING)
	@NotNull
	private SalaryType salaryType;

	@NotNull
	@DecimalMin("0,00")
	private BigDecimal rate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private RoleEntity roleEntity;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employeeEntity;

	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	public EmployeeRoleEntity(Long id, SalaryType salaryType, BigDecimal rate, RoleEntity roleEntity,
			EmployeeEntity employeeEntity, RestaurantEntity restaurantEntity) {
		super(id);
		this.salaryType = salaryType;
		this.rate = rate;
		this.roleEntity = roleEntity;
		this.employeeEntity = employeeEntity;
		this.restaurantEntity = restaurantEntity;
	}

	public EmployeeRoleEntity() {
	}

	public SalaryType getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(SalaryType salaryType) {
		this.salaryType = salaryType;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
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