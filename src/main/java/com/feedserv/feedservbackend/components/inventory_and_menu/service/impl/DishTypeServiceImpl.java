package com.feedserv.feedservbackend.components.inventory_and_menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.dao.DishTypeRepository;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.mapper.DishTypeMapper;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.to.ShowMenuDishTypeTo;
import com.feedserv.feedservbackend.components.inventory_and_menu.service.DishTypeService;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

@Service
public class DishTypeServiceImpl implements DishTypeService {

	@Autowired
	private DishTypeRepository dishTypeRepository;

	@Override
	public List<ShowMenuDishTypeTo> getSimpleDishTypeTos(Long restaurantId) {
		RestaurantEntity restaurantEntity = new RestaurantEntity(restaurantId);
		return DishTypeMapper.entities2ShowTos(dishTypeRepository.findByRestaurantEntity(restaurantEntity));
	}
}
