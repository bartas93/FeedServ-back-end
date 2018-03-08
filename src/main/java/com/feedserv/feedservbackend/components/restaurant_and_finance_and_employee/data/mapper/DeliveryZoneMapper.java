package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.mapper;

import java.util.ArrayList;
import java.util.List;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.DeliveryZoneEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.DeliveryZoneTo;

public class DeliveryZoneMapper {

	public static List<DeliveryZoneEntity> tos2Entities(List<DeliveryZoneTo> deliveryZoneTos) {
		List<DeliveryZoneEntity> deliveryZoneEntities = new ArrayList<>();
		if (deliveryZoneTos != null && deliveryZoneTos.size() > 0) {
			deliveryZoneTos.forEach(dzTo -> {
				deliveryZoneEntities.add(to2Entity(dzTo));
			});
		}
		return deliveryZoneEntities;
	}

	// TODO null czy nie trzeba zamienic na instancje RestaurantInfoEntity?!
	public static DeliveryZoneEntity to2Entity(DeliveryZoneTo deliveryZoneTo) {
		if (deliveryZoneTo != null) {
			return new DeliveryZoneEntity(deliveryZoneTo.getId(), deliveryZoneTo.getKilometrRadious(),
					deliveryZoneTo.getCost(), null);
		} else {
			return null;
		}
	}

	public static List<DeliveryZoneTo> entities2Tos(List<DeliveryZoneEntity> deliveryZoneEntities) {
		List<DeliveryZoneTo> deliveryZoneTos = new ArrayList<>();
		if (deliveryZoneEntities != null && deliveryZoneEntities.size() > 0) {
			deliveryZoneEntities.forEach(dzEntity -> {
				deliveryZoneTos.add(entity2To(dzEntity));
			});
		}
		return deliveryZoneTos;
	}

	public static DeliveryZoneTo entity2To(DeliveryZoneEntity deliveryZoneEntity) {
		if (deliveryZoneEntity != null) {
			return new DeliveryZoneTo(deliveryZoneEntity.getId(), deliveryZoneEntity.getKilometrRadious(),
					deliveryZoneEntity.getCost());
		} else {
			return null;
		}
	}
}
