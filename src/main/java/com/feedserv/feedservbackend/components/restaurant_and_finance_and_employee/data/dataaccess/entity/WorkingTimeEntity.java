package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.enums.WorkingTimeStatus;

@Entity
public class WorkingTimeEntity extends AbstractEntity {

	@NotNull
	private LocalDateTime loginTime;
	private LocalDateTime logoutTime;

	@Enumerated(EnumType.STRING)
	@NotNull
	private WorkingTimeStatus workingTimeStatus;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEntity workingAs;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employeeEntity;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	public WorkingTimeEntity(Long id, LocalDateTime loginTime, LocalDateTime logoutTime,
			WorkingTimeStatus workingTimeStatus, RoleEntity workingAs, EmployeeEntity employeeEntity,
			RestaurantEntity restaurantEntity) {
		super(id);
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.workingTimeStatus = workingTimeStatus;
		this.workingAs = workingAs;
		this.employeeEntity = employeeEntity;
		this.restaurantEntity = restaurantEntity;
	}

	public WorkingTimeEntity() {
	}

	public LocalDateTime getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}

	public LocalDateTime getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(LocalDateTime logoutTime) {
		this.logoutTime = logoutTime;
	}

	public WorkingTimeStatus getWorkingTimeStatus() {
		return workingTimeStatus;
	}

	public void setWorkingTimeStatus(WorkingTimeStatus workingTimeStatus) {
		this.workingTimeStatus = workingTimeStatus;
	}

	public RoleEntity getWorkingAs() {
		return workingAs;
	}

	public void setWorkingAs(RoleEntity workingAs) {
		this.workingAs = workingAs;
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