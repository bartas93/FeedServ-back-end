package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.PromotionEntity;

@Entity
public class MenuItemDishLargenessEntity extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "menu_item_id")
	private MenuItemEntity menuItemEntity;
	@ManyToOne
	@JoinColumn(name = "dish_largeness_id")
	private DishLargenessEntity dishLargenessEntity;
	@NotNull
	private BigDecimal cost;
	@OneToMany(mappedBy = "menuItemDishLargenessEntity")
	private List<UnchangeableProductsEntity> unchangeableProductsEntities;
	@OneToMany(mappedBy = "menuItemDishLargenessEntity")
	private List<MenuItemGroupOfChangeableProductsEntity> menuItemGroupOfChangeableProductsEntities;
	@ManyToOne
	@JoinColumn(name = "promotion_id")
	private PromotionEntity promotionEntity;

	public MenuItemDishLargenessEntity() {
	}

	public MenuItemDishLargenessEntity(Long id) {
		super(id);
	}

	public MenuItemDishLargenessEntity(Long id, MenuItemEntity menuItemEntity, DishLargenessEntity dishLargenessEntity,
			BigDecimal cost, List<UnchangeableProductsEntity> unchangeableProductsEntities,
			List<MenuItemGroupOfChangeableProductsEntity> menuItemGroupOfChangeableProductsEntities,
			PromotionEntity promotionEntity) {
		super(id);
		this.menuItemEntity = menuItemEntity;
		this.dishLargenessEntity = dishLargenessEntity;
		this.cost = cost;
		this.unchangeableProductsEntities = unchangeableProductsEntities;
		this.menuItemGroupOfChangeableProductsEntities = menuItemGroupOfChangeableProductsEntities;
		this.promotionEntity = promotionEntity;
	}

	public MenuItemEntity getMenuItemEntity() {
		return menuItemEntity;
	}

	public void setMenuItemEntity(MenuItemEntity menuItemEntity) {
		this.menuItemEntity = menuItemEntity;
	}

	public DishLargenessEntity getDishLargenessEntity() {
		return dishLargenessEntity;
	}

	public void setDishLargenessEntity(DishLargenessEntity dishLargenessEntity) {
		this.dishLargenessEntity = dishLargenessEntity;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public List<UnchangeableProductsEntity> getUnchangeableProductsEntities() {
		return unchangeableProductsEntities;
	}

	public void setUnchangeableProductsEntities(List<UnchangeableProductsEntity> unchangeableProductsEntities) {
		this.unchangeableProductsEntities = unchangeableProductsEntities;
	}

	public List<MenuItemGroupOfChangeableProductsEntity> getMenuItemGroupOfChangeableProductsEntities() {
		return menuItemGroupOfChangeableProductsEntities;
	}

	public void setMenuItemGroupOfChangeableProductsEntities(
			List<MenuItemGroupOfChangeableProductsEntity> menuItemGroupOfChangeableProductsEntities) {
		this.menuItemGroupOfChangeableProductsEntities = menuItemGroupOfChangeableProductsEntities;
	}

	public PromotionEntity getPromotionEntity() {
		return promotionEntity;
	}

	public void setPromotionEntity(PromotionEntity promotionEntity) {
		this.promotionEntity = promotionEntity;
	}

}
