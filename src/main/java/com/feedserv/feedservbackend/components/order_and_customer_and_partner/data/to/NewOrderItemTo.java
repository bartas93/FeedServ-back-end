package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to;

import java.math.BigDecimal;
import java.util.List;

import com.feedserv.feedservbackend.components.inventory_and_menu.data.to.NewChangesInOrderItemTo;

public class NewOrderItemTo {

	private Long id;
	private BigDecimal totalCostWithAdditionalProducts;
	private boolean isCooked;
	private String menuItemName;
	private String dishLargenessName;
	private Long menuItemDishLargenessId;
	private List<NewChangesInOrderItemTo> newChangesInOrderItemTos;
	private String imageUrl;

	public NewOrderItemTo() {
		super();
	}

	public NewOrderItemTo(Long id, BigDecimal totalCostWithAdditionalProducts, boolean isCooked, String menuItemName,
			String dishLargenessName, Long menuItemDishLargenessId,
			List<NewChangesInOrderItemTo> newChangesInOrderItemTos, String imageUrl) {
		super();
		this.id = id;
		this.totalCostWithAdditionalProducts = totalCostWithAdditionalProducts;
		this.isCooked = isCooked;
		this.menuItemName = menuItemName;
		this.dishLargenessName = dishLargenessName;
		this.menuItemDishLargenessId = menuItemDishLargenessId;
		this.newChangesInOrderItemTos = newChangesInOrderItemTos;
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalCostWithAdditionalProducts() {
		return totalCostWithAdditionalProducts;
	}

	public void setTotalCostWithAdditionalProducts(BigDecimal totalCostWithAdditionalProducts) {
		this.totalCostWithAdditionalProducts = totalCostWithAdditionalProducts;
	}

	public boolean isCooked() {
		return isCooked;
	}

	public void setCooked(boolean isCooked) {
		this.isCooked = isCooked;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public String getDishLargenessName() {
		return dishLargenessName;
	}

	public void setDishLargenessName(String dishLargenessName) {
		this.dishLargenessName = dishLargenessName;
	}

	public Long getMenuItemDishLargenessId() {
		return menuItemDishLargenessId;
	}

	public void setMenuItemDishLargenessId(Long menuItemDishLargenessId) {
		this.menuItemDishLargenessId = menuItemDishLargenessId;
	}

	public List<NewChangesInOrderItemTo> getNewChangesInOrderItemTos() {
		return newChangesInOrderItemTos;
	}

	public void setNewChangesInOrderItemTos(List<NewChangesInOrderItemTo> newChangesInOrderItemTos) {
		this.newChangesInOrderItemTos = newChangesInOrderItemTos;
	}

}
