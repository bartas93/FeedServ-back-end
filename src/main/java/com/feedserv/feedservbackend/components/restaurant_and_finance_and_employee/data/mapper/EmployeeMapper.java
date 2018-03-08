package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.feedserv.feedservbackend.auth.InvalidRegistrationDataException;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.EmployeeEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.EmployeeRegistrationTo;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.SimpleEmployeeTo;

public class EmployeeMapper {

	public static EmployeeEntity registrationTo2Entity(EmployeeRegistrationTo employeeRegistrationTo)
			throws InvalidRegistrationDataException {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		Optional<EmployeeRegistrationTo> opt = Optional.ofNullable(employeeRegistrationTo);
		opt.ifPresent(ert -> {
			employeeEntity.setFullName(ert.getFullName());
			;
			employeeEntity.setPassword(ert.getPassword());
			employeeEntity.setEmail(ert.getEmail());
			employeeEntity.setActive(true);
		});
		opt.orElseThrow(InvalidRegistrationDataException::new);
		return employeeEntity;
	}

	public static SimpleEmployeeTo entity2SimpleTo(EmployeeEntity employeeEntity) {
		if (employeeEntity != null) {
			return new SimpleEmployeeTo(employeeEntity.getId(), employeeEntity.getImageUrl(),
					employeeEntity.getFullName());
		} else {
			return null;
		}
	}

	public static List<SimpleEmployeeTo> entities2SimpleTos(List<EmployeeEntity> employeeEntities) {
		List<SimpleEmployeeTo> simpleEmployeeTos = new ArrayList<>();
		if (employeeEntities != null && employeeEntities.size() > 0) {
			employeeEntities.forEach(employeeEntity -> {
				simpleEmployeeTos.add(entity2SimpleTo(employeeEntity));
			});
		}
		return simpleEmployeeTos;
	}

}
