package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity.MenuItemDishLargenessEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.PromotionType;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

@Entity
public class PromotionEntity extends AbstractEntity {
	@NotNull
	@Enumerated(EnumType.STRING)
	private PromotionType promotionType;
	@DecimalMin("0,00")
	private BigDecimal rate;

	@OneToMany(mappedBy = "promotionEntity")
	private List<MenuItemDishLargenessEntity> menuItemDishLargenessEntities;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	private LocalDate startDate;
	@NotNull
	private LocalDate endDate;

	public PromotionEntity() {
	}

	public PromotionEntity(Long id) {
		super(id);
	}

	public PromotionEntity(Long id, PromotionType promotionType, BigDecimal rate,
			List<MenuItemDishLargenessEntity> menuItemDishLargenessEntities, RestaurantEntity restaurantEntity,
			LocalDate startDate, LocalDate endDate) {
		super(id);
		this.promotionType = promotionType;
		this.rate = rate;
		this.menuItemDishLargenessEntities = menuItemDishLargenessEntities;
		this.restaurantEntity = restaurantEntity;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public PromotionType getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(PromotionType promotionType) {
		this.promotionType = promotionType;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public List<MenuItemDishLargenessEntity> getMenuItemDishLargenessEntities() {
		return menuItemDishLargenessEntities;
	}

	public void setMenuItemDishLargenessEntities(List<MenuItemDishLargenessEntity> menuItemDishLargenessEntities) {
		this.menuItemDishLargenessEntities = menuItemDishLargenessEntities;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}