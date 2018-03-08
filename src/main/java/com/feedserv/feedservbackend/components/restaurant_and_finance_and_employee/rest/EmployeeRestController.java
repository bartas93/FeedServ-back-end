package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feedserv.feedservbackend.auth.InvalidRestaurantIdException;
import com.feedserv.feedservbackend.auth.JWTDecoder;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.enums.RoleNames;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.SimpleEmployeeTo;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.service.EmployeeService;

//TODO zmienic request mapping!!
@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/online-drivers", method = RequestMethod.GET)
	public List<SimpleEmployeeTo> getOnlineDriversEmployees(@RequestHeader(value = "Authorization") String bearerToken)
			throws InvalidRestaurantIdException {
		boolean isOnline = true;
		Long restaurantId = JWTDecoder.getJwtEntity(bearerToken).getRestaurantId();
		return employeeService.getEmployeeByOnlineAndRoleName(restaurantId, isOnline, RoleNames.DRIVER);
	}

}
