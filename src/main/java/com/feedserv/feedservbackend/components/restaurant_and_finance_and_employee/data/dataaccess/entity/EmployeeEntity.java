package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.embeded.EmployeeInfo;

@Entity
public class EmployeeEntity extends AbstractEntity {

	@NotNull
	private String email;
	private String phoneNumber;
	@NotNull
	private String password;

	@NotNull
	private boolean isActive;
	private boolean isOnline;
	private String imageUrl;

	private String fullName;
	private boolean rememberMe;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;
	@Embedded
	@NotNull
	private EmployeeInfo employeeInfo;

	@OneToMany(mappedBy = "employeeEntity", fetch = FetchType.EAGER)
	private List<EmployeeRoleEntity> employeeRoleEntities;
	@OneToMany(mappedBy = "employeeEntity")
	private List<WorkingTimeEntity> workingTimeEntities;

	public EmployeeEntity() {
	}

	public EmployeeEntity(Long id) {
		super(id);
	}

	public EmployeeEntity(Long id, String email, String phoneNumber, String password, boolean isActive, String imageUrl,
			String fullName, boolean rememberMe, RestaurantEntity restaurantEntity, EmployeeInfo employeeInfo,
			List<EmployeeRoleEntity> employeeRoleEntities, List<WorkingTimeEntity> workingTimeEntities,
			boolean isOnline) {
		super(id);
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.isActive = isActive;
		this.imageUrl = imageUrl;
		this.fullName = fullName;
		this.rememberMe = rememberMe;
		this.restaurantEntity = restaurantEntity;
		this.employeeInfo = employeeInfo;
		this.employeeRoleEntities = employeeRoleEntities;
		this.workingTimeEntities = workingTimeEntities;
		this.isOnline = isOnline;
	}

	public EmployeeEntity(EmployeeEntity employeeEntity) {
		this.id = employeeEntity.getId();
		this.fullName = employeeEntity.getFullName();
		this.email = employeeEntity.getEmail();
		this.phoneNumber = employeeEntity.getPhoneNumber();
		this.password = employeeEntity.getPassword();
		this.isActive = employeeEntity.isActive();
		this.restaurantEntity = employeeEntity.getRestaurantEntity();
		this.employeeInfo = employeeEntity.getEmployeeInfo();
		this.employeeRoleEntities = employeeEntity.getEmployeeRoleEntities();
		this.workingTimeEntities = employeeEntity.getWorkingTimeEntities();
		this.rememberMe = employeeEntity.isRememberMe();
		this.imageUrl = employeeEntity.getImageUrl();
		this.isOnline = employeeEntity.getIsOnline();
	}

	public boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public List<EmployeeRoleEntity> getEmployeeRoleEntities() {
		return employeeRoleEntities;
	}

	public void setEmployeeRoleEntities(List<EmployeeRoleEntity> employeeRoleEntities) {
		this.employeeRoleEntities = employeeRoleEntities;
	}

	public List<WorkingTimeEntity> getWorkingTimeEntities() {
		return workingTimeEntities;
	}

	public void setWorkingTimeEntities(List<WorkingTimeEntity> workingTimeEntities) {
		this.workingTimeEntities = workingTimeEntities;
	}

}