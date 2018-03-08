package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to;

import java.math.BigDecimal;
import java.time.temporal.ValueRange;

public class DeliveryZoneTo {
	private Long id;
	private ValueRange kilometrRadious;
	private BigDecimal cost;

	public DeliveryZoneTo() {
	}

	public DeliveryZoneTo(Long id, ValueRange kilometrRadious, BigDecimal cost) {
		super();
		this.id = id;
		this.kilometrRadious = kilometrRadious;
		this.cost = cost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ValueRange getKilometrRadious() {
		return kilometrRadious;
	}

	public void setKilometrRadious(ValueRange kilometrRadious) {
		this.kilometrRadious = kilometrRadious;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

}
