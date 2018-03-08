package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.mapper;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.mapper.AddressMapper;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.RestaurantTo;

public class RestaurantMapper {

	// TODO null
	public static RestaurantEntity to2Entity(RestaurantTo restaurantTo) {
		if (restaurantTo != null) {
			return new RestaurantEntity(restaurantTo.getId(), restaurantTo.getName(), restaurantTo.getDescription(),
					restaurantTo.getOwnerName(), restaurantTo.getPhoneNumber(), restaurantTo.getEmail(),
					AddressMapper.to2Entity(restaurantTo.getAddressTo()), null);
		} else {
			return null;

		}
	}

	public static RestaurantTo entity2To(RestaurantEntity restaurantEntity) {
		if (restaurantEntity != null) {
			return new RestaurantTo(restaurantEntity.getId(), restaurantEntity.getName(),
					restaurantEntity.getDescription(), restaurantEntity.getOwnerName(),
					restaurantEntity.getPhoneNumber(), restaurantEntity.getEmail(),
					AddressMapper.entity2To(restaurantEntity.getAddressEntity()),
					RestaurantInfoMapper.entity2To(restaurantEntity.getRestaurantInfoEntity()));
		} else {
			return null;

		}
	}

}
