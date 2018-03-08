package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.mapper;

import java.util.ArrayList;
import java.util.List;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.OpeningTimesEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.OpeningTimesTo;

public class OpeningTimesMapper {

	public static List<OpeningTimesEntity> tos2Entities(List<OpeningTimesTo> openingTimesTos) {
		List<OpeningTimesEntity> openingTimesEntities = new ArrayList<>();
		if (openingTimesTos != null && openingTimesTos.size() > 0) {
			openingTimesTos.forEach(otTo -> {
				openingTimesEntities.add(to2Entity(otTo));
			});
		}
		return openingTimesEntities;
	}

	// TODO null czy nie trzeba zamienic na instancje RestaurantInfoEntity?!
	public static OpeningTimesEntity to2Entity(OpeningTimesTo openingTimesTo) {
		if (openingTimesTo != null) {
			return new OpeningTimesEntity(openingTimesTo.getId(), null, openingTimesTo.getDayOfWeek(),
					openingTimesTo.getOpenFrom(), openingTimesTo.getOpenTo());
		} else {
			return null;
		}
	}

	public static List<OpeningTimesTo> entities2Tos(List<OpeningTimesEntity> openingTimesEntities) {
		List<OpeningTimesTo> openingTimesTos = new ArrayList<>();
		if (openingTimesEntities != null && openingTimesEntities.size() > 0) {
			openingTimesEntities.forEach(otEntity -> {
				openingTimesTos.add(entity2To(otEntity));
			});
		}
		return openingTimesTos;
	}

	public static OpeningTimesTo entity2To(OpeningTimesEntity openingTimesEntity) {
		if (openingTimesEntity != null) {
			return new OpeningTimesTo(openingTimesEntity.getId(), openingTimesEntity.getDayOfWeek(),
					openingTimesEntity.getOpenFrom(), openingTimesEntity.getOpenTo());
		} else {
			return null;
		}
	}

}
