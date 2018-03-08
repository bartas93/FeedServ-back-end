package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;

@Entity
public class RestaurantInfoEntity extends AbstractEntity {

	@OneToMany(mappedBy = "restaurantInfoEntity", cascade = CascadeType.ALL)
	private List<OpeningTimesEntity> openingTimesEntities;

	@OneToMany(mappedBy = "restaurantInfoEntity", cascade = CascadeType.ALL)
	private List<DeliveryZoneEntity> deliveryZoneEntities;

	@OneToOne(mappedBy = "restaurantInfoEntity")
	private RestaurantEntity restaurantEntity;

	public RestaurantInfoEntity() {
	}

	public RestaurantInfoEntity(Long id) {
		super(id);
	}

	public RestaurantInfoEntity(Long id, List<OpeningTimesEntity> openingTimesEntities,
			List<DeliveryZoneEntity> deliveryZoneEntities, RestaurantEntity restaurantEntity) {
		super(id);
		this.openingTimesEntities = openingTimesEntities;
		this.deliveryZoneEntities = deliveryZoneEntities;
		this.restaurantEntity = restaurantEntity;
	}

	public void addOpeningTimesEntity(OpeningTimesEntity openingTimesEntity) {
		openingTimesEntities.add(openingTimesEntity);
		openingTimesEntity.setRestaurantInfoEntity(this);
	}

	public void removeOpeningTimesEntity(OpeningTimesEntity openingTimesEntity) {
		openingTimesEntities.remove(openingTimesEntity);
		openingTimesEntity.setRestaurantInfoEntity(null);
	}

	public void addDeliveryZoneEntity(DeliveryZoneEntity deliveryZoneEntity) {
		deliveryZoneEntities.add(deliveryZoneEntity);
		deliveryZoneEntity.setRestaurantInfoEntity(this);
	}

	public void removeDeliveryZoneEntity(DeliveryZoneEntity deliveryZoneEntity) {
		deliveryZoneEntities.remove(deliveryZoneEntity);
		deliveryZoneEntity.setRestaurantInfoEntity(null);
	}

	public List<OpeningTimesEntity> getOpeningTimesEntities() {
		return openingTimesEntities;
	}

	public void setOpeningTimesEntities(List<OpeningTimesEntity> openingTimesEntities) {
		this.openingTimesEntities = openingTimesEntities;
	}

	public List<DeliveryZoneEntity> getDeliveryZoneEntities() {
		return deliveryZoneEntities;
	}

	public void setDeliveryZoneEntities(List<DeliveryZoneEntity> deliveryZoneEntities) {
		this.deliveryZoneEntities = deliveryZoneEntities;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

}
