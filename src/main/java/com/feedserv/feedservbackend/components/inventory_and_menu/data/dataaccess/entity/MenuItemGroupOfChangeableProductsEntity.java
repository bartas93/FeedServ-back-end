package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;

@Entity
public class MenuItemGroupOfChangeableProductsEntity extends AbstractEntity {
	@ManyToOne
	@JoinColumn(name = "group_of_changable_products_id")
	private GroupOfChangeableProductsEntity groupOfChangableProductsEntity;
	@ManyToOne
	@JoinColumn(name = "menu_item_dish_largeness_id")
	private MenuItemDishLargenessEntity menuItemDishLargenessEntity;
	@ManyToMany
	@JoinTable(name = "default_changeable_product_entity", joinColumns = {
			@JoinColumn(name = "menu_item_group_of_changeable_products_id") }, inverseJoinColumns = {
					@JoinColumn(name = "changeable_product_id") })
	private List<ChangeableProductEntity> defaultChangeableProductEntities;

	public MenuItemGroupOfChangeableProductsEntity() {
	}

	public MenuItemGroupOfChangeableProductsEntity(Long id) {
		super(id);
	}

	public MenuItemGroupOfChangeableProductsEntity(Long id,
			GroupOfChangeableProductsEntity groupOfChangableProductsEntity,
			MenuItemDishLargenessEntity menuItemDishLargenessEntity,
			List<ChangeableProductEntity> defaultChangeableProductEntities) {
		super(id);
		this.groupOfChangableProductsEntity = groupOfChangableProductsEntity;
		this.menuItemDishLargenessEntity = menuItemDishLargenessEntity;
		this.defaultChangeableProductEntities = defaultChangeableProductEntities;
	}

	public GroupOfChangeableProductsEntity getGroupOfChangableProductsEntity() {
		return groupOfChangableProductsEntity;
	}

	public void setGroupOfChangableProductsEntity(GroupOfChangeableProductsEntity groupOfChangableProductsEntity) {
		this.groupOfChangableProductsEntity = groupOfChangableProductsEntity;
	}

	public MenuItemDishLargenessEntity getMenuItemDishLargenessEntity() {
		return menuItemDishLargenessEntity;
	}

	public void setMenuItemDishLargenessEntity(MenuItemDishLargenessEntity menuItemDishLargenessEntity) {
		this.menuItemDishLargenessEntity = menuItemDishLargenessEntity;
	}

	public List<ChangeableProductEntity> getDefaultChangeableProductEntities() {
		return defaultChangeableProductEntities;
	}

	public void setDefaultChangeableProductEntities(List<ChangeableProductEntity> defaultChangeableProductEntities) {
		this.defaultChangeableProductEntities = defaultChangeableProductEntities;
	}

}
