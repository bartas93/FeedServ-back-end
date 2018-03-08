
package com.feedserv.feedservbackend.components.inventory_and_menu.data.to;

import java.math.BigDecimal;

public class ShowSimpleMenuItemDishLargenessTo {
	private Long id;
	private String dishLargenessName;
	private BigDecimal cost;
	private BigDecimal costAfterPromotion;

	public ShowSimpleMenuItemDishLargenessTo() {
	}

	public ShowSimpleMenuItemDishLargenessTo(Long id, String dishLargenessName, BigDecimal cost,
			BigDecimal costAfterPromotion) {
		super();
		this.id = id;
		this.dishLargenessName = dishLargenessName;
		this.cost = cost;
		this.costAfterPromotion = costAfterPromotion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDishLargenessName() {
		return dishLargenessName;
	}

	public void setDishLargenessName(String dishLargenessName) {
		this.dishLargenessName = dishLargenessName;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getCostAfterPromotion() {
		return costAfterPromotion;
	}

	public void setCostAfterPromotion(BigDecimal costAfterPromotion) {
		this.costAfterPromotion = costAfterPromotion;
	}

}
