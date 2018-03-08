package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to;

public class EmployeeRegistrationTo {

	private String fullName;
	private String password;
	private String email;

	public EmployeeRegistrationTo(String fullName, String password, String email) {
		super();
		this.fullName = fullName;
		this.password = password;
		this.email = email;
	}

	public EmployeeRegistrationTo() {
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
