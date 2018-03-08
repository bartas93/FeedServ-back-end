package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.mapper;

import java.util.ArrayList;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantInfoEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.RestaurantInfoTo;

public class RestaurantInfoMapper {

	public static RestaurantInfoEntity to2Entity(RestaurantInfoTo restaurantInfoTo) {
		if (restaurantInfoTo != null) {
			RestaurantInfoEntity riE = new RestaurantInfoEntity(restaurantInfoTo.getId(), new ArrayList<>(),
					new ArrayList<>(), null);
			restaurantInfoTo.getDeliveryZoneTos().forEach(deliveryZoneTo -> {
				riE.addDeliveryZoneEntity(DeliveryZoneMapper.to2Entity(deliveryZoneTo));
			});
			restaurantInfoTo.getOpeningTimesTos().forEach(openingTimesTo -> {
				riE.addOpeningTimesEntity(OpeningTimesMapper.to2Entity(openingTimesTo));
			});
			return riE;
		} else {
			return null;
		}
	}

	public static RestaurantInfoTo entity2To(RestaurantInfoEntity restaurantInfoEntity) {
		if (restaurantInfoEntity != null) {
			return new RestaurantInfoTo(restaurantInfoEntity.getId(),
					OpeningTimesMapper.entities2Tos(restaurantInfoEntity.getOpeningTimesEntities()),
					DeliveryZoneMapper.entities2Tos(restaurantInfoEntity.getDeliveryZoneEntities()));
		} else {
			return null;
		}
	}
}
