package com.feedserv.feedservbackend.components.inventory_and_menu.service;

import java.util.List;

import com.feedserv.feedservbackend.components.inventory_and_menu.data.to.ShowMenuDishTypeTo;

public interface DishTypeService {
	List<ShowMenuDishTypeTo> getSimpleDishTypeTos(Long restaurantId);
}
