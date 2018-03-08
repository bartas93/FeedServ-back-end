package com.feedserv.feedservbackend.components.inventory_and_menu.data.to;

import java.math.BigDecimal;

public class ChangeableProductTo {
	private Long id;
	private BigDecimal additionalCost;
	private ProductQuantityTo productQuantityTo;
	private DishLargenessTo dishLargenessTo;

	public ChangeableProductTo() {
	}

	public ChangeableProductTo(Long id, BigDecimal additionalCost, ProductQuantityTo productQuantityTo,
			DishLargenessTo dishLargenessTo) {
		super();
		this.id = id;
		this.additionalCost = additionalCost;
		this.productQuantityTo = productQuantityTo;
		this.dishLargenessTo = dishLargenessTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAdditionalCost() {
		return additionalCost;
	}

	public void setAdditionalCost(BigDecimal additionalCost) {
		this.additionalCost = additionalCost;
	}

	public ProductQuantityTo getProductQuantityTo() {
		return productQuantityTo;
	}

	public void setProductQuantityTo(ProductQuantityTo productQuantityTo) {
		this.productQuantityTo = productQuantityTo;
	}

	public DishLargenessTo getDishLargenessTo() {
		return dishLargenessTo;
	}

	public void setDishLargenessTo(DishLargenessTo dishLargenessTo) {
		this.dishLargenessTo = dishLargenessTo;
	}

}
