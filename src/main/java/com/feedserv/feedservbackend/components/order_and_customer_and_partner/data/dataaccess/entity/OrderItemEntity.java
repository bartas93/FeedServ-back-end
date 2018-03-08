package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity.MenuItemDishLargenessEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

@Entity
public class OrderItemEntity extends AbstractEntity {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "menu_item_dish_largeness_id")
	private MenuItemDishLargenessEntity menuItemDishLargenessEntity;
	// TODO to jest obliczane poprzez cene menuItemDishLargeness + zmiany w
	// zamowieniu + promocje!
	@NotNull
	private BigDecimal totalCostWithAdditionalProducts;

	@OneToMany(mappedBy = "orderItemEntity", cascade = CascadeType.ALL)
	private List<ChangesInOrderItemEntity> changesInOrderItemEntities;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private OrderEntity orderEntity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	private boolean isCooked;

	public OrderItemEntity() {
	}

	public OrderItemEntity(Long id) {
		super(id);
	}

	public OrderItemEntity(Long id, MenuItemDishLargenessEntity menuItemDishLargenessEntity,
			BigDecimal totalCostWithAdditionalProducts, List<ChangesInOrderItemEntity> changesInOrderItemEntities,
			OrderEntity orderEntity, RestaurantEntity restaurantEntity, boolean isCooked) {
		super(id);
		this.menuItemDishLargenessEntity = menuItemDishLargenessEntity;
		this.totalCostWithAdditionalProducts = totalCostWithAdditionalProducts;
		this.changesInOrderItemEntities = changesInOrderItemEntities;
		this.orderEntity = orderEntity;
		this.restaurantEntity = restaurantEntity;
		this.isCooked = isCooked;
	}

	public void addChangesInOrderItemEntity(ChangesInOrderItemEntity changesInOrderItemEntity) {
		changesInOrderItemEntities.add(changesInOrderItemEntity);
		changesInOrderItemEntity.setOrderItemEntity(this);
	}

	public void removeChangesInOrderItemEntity(ChangesInOrderItemEntity changesInOrderItemEntity) {
		changesInOrderItemEntities.remove(changesInOrderItemEntity);
		changesInOrderItemEntity.setOrderItemEntity(null);
	}

	public MenuItemDishLargenessEntity getMenuItemDishLargenessEntity() {
		return menuItemDishLargenessEntity;
	}

	public void setMenuItemDishLargenessEntity(MenuItemDishLargenessEntity menuItemDishLargenessEntity) {
		this.menuItemDishLargenessEntity = menuItemDishLargenessEntity;
	}

	public BigDecimal getTotalCostWithAdditionalProducts() {
		return totalCostWithAdditionalProducts;
	}

	public void setTotalCostWithAdditionalProducts(BigDecimal totalCostWithAdditionalProducts) {
		this.totalCostWithAdditionalProducts = totalCostWithAdditionalProducts;
	}

	public List<ChangesInOrderItemEntity> getChangesInOrderItemEntities() {
		return changesInOrderItemEntities;
	}

	public void setChangesInOrderItemEntities(List<ChangesInOrderItemEntity> changesInOrderItemEntities) {
		this.changesInOrderItemEntities = changesInOrderItemEntities;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

	public boolean isCooked() {
		return isCooked;
	}

	public void setCooked(boolean isCooked) {
		this.isCooked = isCooked;
	}

}