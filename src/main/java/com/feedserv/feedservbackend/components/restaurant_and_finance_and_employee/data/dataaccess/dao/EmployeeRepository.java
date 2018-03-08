package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.EmployeeEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	Optional<EmployeeEntity> findByEmail(String email);

	List<EmployeeEntity> findByIsOnlineAndRestaurantEntity(boolean isOnline, RestaurantEntity restaurantEntity);
}
