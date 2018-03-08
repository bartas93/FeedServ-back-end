package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to;

import java.util.List;

public class RestaurantInfoTo {
	private Long id;
	private List<OpeningTimesTo> openingTimesTos;
	private List<DeliveryZoneTo> deliveryZoneTos;

	public RestaurantInfoTo() {
	}

	public RestaurantInfoTo(Long id, List<OpeningTimesTo> openingTimesTos, List<DeliveryZoneTo> deliveryZoneTos) {
		super();
		this.id = id;
		this.openingTimesTos = openingTimesTos;
		this.deliveryZoneTos = deliveryZoneTos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OpeningTimesTo> getOpeningTimesTos() {
		return openingTimesTos;
	}

	public void setOpeningTimesTos(List<OpeningTimesTo> openingTimesTos) {
		this.openingTimesTos = openingTimesTos;
	}

	public List<DeliveryZoneTo> getDeliveryZoneTos() {
		return deliveryZoneTos;
	}

	public void setDeliveryZoneTos(List<DeliveryZoneTo> deliveryZoneTos) {
		this.deliveryZoneTos = deliveryZoneTos;
	}

}
