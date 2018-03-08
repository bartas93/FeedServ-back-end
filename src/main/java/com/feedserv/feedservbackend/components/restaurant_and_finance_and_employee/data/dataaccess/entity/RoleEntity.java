package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.enums.RoleNames;

@Entity
public class RoleEntity extends AbstractEntity {

	@NotNull
	@Enumerated(EnumType.STRING)
	private RoleNames name;
	private String description;
	@OneToMany(mappedBy = "roleEntity")
	private List<EmployeeRoleEntity> employeeRoleEntities;

	public RoleEntity(Long id, RoleNames name, String description, List<EmployeeRoleEntity> employeeRoleEntities) {
		super(id);
		this.name = name;
		this.description = description;
		this.employeeRoleEntities = employeeRoleEntities;
	}

	public RoleEntity() {
	}

	public RoleNames getName() {
		return name;
	}

	public void setName(RoleNames name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<EmployeeRoleEntity> getEmployeeRoleEntities() {
		return employeeRoleEntities;
	}

	public void setEmployeeRoleEntities(List<EmployeeRoleEntity> employeeRoleEntities) {
		this.employeeRoleEntities = employeeRoleEntities;
	}

}