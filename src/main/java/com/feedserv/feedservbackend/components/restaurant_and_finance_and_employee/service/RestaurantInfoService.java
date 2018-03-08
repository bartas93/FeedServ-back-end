package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.service;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.RestaurantInfoTo;

public interface RestaurantInfoService {
	RestaurantInfoTo saveRestaurantInfo(RestaurantInfoTo restaurantInfoTo);

	RestaurantInfoTo findById(Long id);

}
