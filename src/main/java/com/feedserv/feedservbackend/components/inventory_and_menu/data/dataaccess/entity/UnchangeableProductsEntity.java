package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;

@Entity
public class UnchangeableProductsEntity extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "menu_item_dish_largeness_id")
	private MenuItemDishLargenessEntity menuItemDishLargenessEntity;
	@ManyToOne
	@JoinColumn(name = "product_quantity_id")
	private ProductQuantityEntity productQuantityEntity;

	public UnchangeableProductsEntity() {
	}

	public UnchangeableProductsEntity(Long id) {
		super(id);
	}

	public UnchangeableProductsEntity(Long id, MenuItemDishLargenessEntity menuItemDishLargenessEntity,
			ProductQuantityEntity productQuantityEntity) {
		super(id);
		this.menuItemDishLargenessEntity = menuItemDishLargenessEntity;
		this.productQuantityEntity = productQuantityEntity;
	}

	public MenuItemDishLargenessEntity getMenuItemDishLargenessEntity() {
		return menuItemDishLargenessEntity;
	}

	public void setMenuItemDishLargenessEntity(MenuItemDishLargenessEntity menuItemDishLargenessEntity) {
		this.menuItemDishLargenessEntity = menuItemDishLargenessEntity;
	}

	public ProductQuantityEntity getProductQuantityEntity() {
		return productQuantityEntity;
	}

	public void setProductQuantityEntity(ProductQuantityEntity productQuantityEntity) {
		this.productQuantityEntity = productQuantityEntity;
	}

}
