package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity.DishTypeEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

public interface DishTypeRepository extends JpaRepository<DishTypeEntity, Long> {
	List<DishTypeEntity> findByRestaurantEntity(RestaurantEntity restaurantEntity);

}
