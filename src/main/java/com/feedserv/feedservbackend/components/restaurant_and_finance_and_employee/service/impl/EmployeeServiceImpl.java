package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.dao.EmployeeRepository;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.EmployeeEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.enums.RoleNames;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.mapper.EmployeeMapper;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.SimpleEmployeeTo;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// TODO POPRAWIC REFAKTOR NIE MIESZAC SETOW I LIST!
	@Override
	public List<SimpleEmployeeTo> getEmployeeByOnlineAndRoleName(Long restaurantId, boolean isOnline,
			RoleNames roleName) {
		List<EmployeeEntity> employees = employeeRepository.findByIsOnlineAndRestaurantEntity(isOnline,
				new RestaurantEntity(restaurantId));
		Set<EmployeeEntity> filtredEmployees = getEmployeesByRoleName(employees, roleName);
		List<EmployeeEntity> filtredList = new ArrayList<>();
		filtredList.addAll(filtredEmployees);
		return EmployeeMapper.entities2SimpleTos(filtredList);
	}

	// TODO refaktor - zmienic forEache na stream().filter() + nie mieszac setow i
	// list z poprzedniego
	private Set<EmployeeEntity> getEmployeesByRoleName(List<EmployeeEntity> employees, RoleNames roleName) {
		Set<EmployeeEntity> filtredEmployees = new HashSet<>();
		employees.forEach(em -> {
			em.getEmployeeRoleEntities().forEach(emRole -> {
				if (emRole.getRoleEntity().getName() == roleName) {
					filtredEmployees.add(em);
				}
			});
		});
		return filtredEmployees;
	}

}
