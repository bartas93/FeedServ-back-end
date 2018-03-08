package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.service;

import java.util.List;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.enums.RoleNames;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.SimpleEmployeeTo;

public interface EmployeeService {
	List<SimpleEmployeeTo> getEmployeeByOnlineAndRoleName(Long restaurantId, boolean isOnline, RoleNames roleName);
}
