package com.feedserv.feedservbackend.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.dao.EmployeeRepository;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.EmployeeEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.mapper.EmployeeMapper;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.EmployeeRegistrationTo;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void register(EmployeeRegistrationTo employeeRegistrationTo) throws InvalidRegistrationDataException {

		checkIfExists(employeeRegistrationTo);

		employeeRegistrationTo.setPassword(bCryptPasswordEncoder.encode(employeeRegistrationTo.getPassword()));
		EmployeeEntity employeeEntity = EmployeeMapper.registrationTo2Entity(employeeRegistrationTo);
		employeeRepository.save(employeeEntity);
	}

	private void checkIfExists(EmployeeRegistrationTo employeeRegistrationTo) throws InvalidRegistrationDataException {
		Optional<EmployeeEntity> emOptional = employeeRepository.findByEmail(employeeRegistrationTo.getEmail());
		if (emOptional.isPresent()) {
			throw new InvalidRegistrationDataException("User with that email exists!");
		}

	}
}
