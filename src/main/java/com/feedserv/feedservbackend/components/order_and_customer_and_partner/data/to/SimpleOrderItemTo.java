package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to;

import java.math.BigDecimal;

public class SimpleOrderItemTo {

	private Long id;
	private String menuItemName;
	private String menuItemImageUrl;
	private String dishTypeName;
	private String dishLargenessName;
	private BigDecimal totalCostWithAdditionalProducts;
	private boolean isOrderItemChanged;
	private boolean isCooked;
	private boolean isPromoted;

	public SimpleOrderItemTo() {
	}

	public SimpleOrderItemTo(Long id, String menuItemName, String menuItemImageUrl, String dishTypeName,
			String dishLargenessName, BigDecimal totalCostWithAdditionalProducts, boolean isOrderItemChanged,
			boolean isCooked, boolean isPromoted) {
		super();
		this.id = id;
		this.menuItemName = menuItemName;
		this.menuItemImageUrl = menuItemImageUrl;
		this.dishTypeName = dishTypeName;
		this.dishLargenessName = dishLargenessName;
		this.totalCostWithAdditionalProducts = totalCostWithAdditionalProducts;
		this.isOrderItemChanged = isOrderItemChanged;
		this.isCooked = isCooked;
		this.isPromoted = isPromoted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public String getMenuItemImageUrl() {
		return menuItemImageUrl;
	}

	public void setMenuItemImageUrl(String menuItemImageUrl) {
		this.menuItemImageUrl = menuItemImageUrl;
	}

	public String getDishTypeName() {
		return dishTypeName;
	}

	public void setDishTypeName(String dishTypeName) {
		this.dishTypeName = dishTypeName;
	}

	public String getDishLargenessName() {
		return dishLargenessName;
	}

	public void setDishLargenessName(String dishLargenessName) {
		this.dishLargenessName = dishLargenessName;
	}

	public BigDecimal getTotalCostWithAdditionalProducts() {
		return totalCostWithAdditionalProducts;
	}

	public void setTotalCostWithAdditionalProducts(BigDecimal totalCostWithAdditionalProducts) {
		this.totalCostWithAdditionalProducts = totalCostWithAdditionalProducts;
	}

	public boolean isOrderItemChanged() {
		return isOrderItemChanged;
	}

	public void setOrderItemChanged(boolean isOrderItemChanged) {
		this.isOrderItemChanged = isOrderItemChanged;
	}

	public boolean isCooked() {
		return isCooked;
	}

	public void setCooked(boolean isCooked) {
		this.isCooked = isCooked;
	}

	public boolean isPromoted() {
		return isPromoted;
	}

	public void setPromoted(boolean isPromoted) {
		this.isPromoted = isPromoted;
	}

}