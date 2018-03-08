package com.feedserv.feedservbackend.components.inventory_and_menu.data.to;

import java.math.BigDecimal;

public class NewChangeableProductTo {

	private Long id;
	private Long groupOfChangeableProductsId;
	private Long productQuantityId;
	private BigDecimal additionalCost;
	private Long dishLargenessId;

	public NewChangeableProductTo() {
	}

	public NewChangeableProductTo(Long id, Long groupOfChangeableProductsId, Long productQuantityId,
			BigDecimal additionalCost, Long dishLargenessId) {
		super();
		this.id = id;
		this.groupOfChangeableProductsId = groupOfChangeableProductsId;
		this.productQuantityId = productQuantityId;
		this.additionalCost = additionalCost;
		this.dishLargenessId = dishLargenessId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupOfChangeableProductsId() {
		return groupOfChangeableProductsId;
	}

	public void setGroupOfChangeableProductsId(Long groupOfChangeableProductsId) {
		this.groupOfChangeableProductsId = groupOfChangeableProductsId;
	}

	public Long getProductQuantityId() {
		return productQuantityId;
	}

	public void setProductQuantityId(Long productQuantityId) {
		this.productQuantityId = productQuantityId;
	}

	public BigDecimal getAdditionalCost() {
		return additionalCost;
	}

	public void setAdditionalCost(BigDecimal additionalCost) {
		this.additionalCost = additionalCost;
	}

	public Long getDishLargenessId() {
		return dishLargenessId;
	}

	public void setDishLargenessId(Long dishLargenessId) {
		this.dishLargenessId = dishLargenessId;
	}

}
