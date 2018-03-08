package com.feedserv.feedservbackend.auth;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.EmployeeRegistrationTo;

public interface AuthService {

	void register(EmployeeRegistrationTo employeeRegistrationTo) throws InvalidRegistrationDataException;
}
