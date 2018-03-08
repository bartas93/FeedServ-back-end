package com.feedserv.feedservbackend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.EmployeeRegistrationTo;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public void registerNewUser(@RequestBody EmployeeRegistrationTo employeeRegistrationTo)
			throws InvalidRegistrationDataException {
		authService.register(employeeRegistrationTo);
	}
}
