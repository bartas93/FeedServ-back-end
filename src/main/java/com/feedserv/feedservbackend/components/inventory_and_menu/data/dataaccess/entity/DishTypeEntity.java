package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

@Entity
public class DishTypeEntity extends AbstractEntity {

	@NotNull
	private String name;
	private String imageUrl;
	@OneToMany(mappedBy = "dishTypeEntity")
	private List<MenuItemEntity> menuItemEntities;
	@OneToMany(mappedBy = "dishTypeEntity")
	private List<DishLargenessEntity> dishLargenessEntities;
	@OneToMany(mappedBy = "dishTypeEntity")
	private List<GroupOfChangeableProductsEntity> groupOfChangeableProductsEntities;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	public DishTypeEntity() {
	}

	public DishTypeEntity(Long id) {
		super(id);
	}

	public DishTypeEntity(Long id, String name, String imageUrl, List<MenuItemEntity> menuItemEntities,
			List<DishLargenessEntity> dishLargenessEntities,
			List<GroupOfChangeableProductsEntity> groupOfChangeableProductsEntities,
			RestaurantEntity restaurantEntity) {
		super(id);
		this.name = name;
		this.imageUrl = imageUrl;
		this.menuItemEntities = menuItemEntities;
		this.dishLargenessEntities = dishLargenessEntities;
		this.groupOfChangeableProductsEntities = groupOfChangeableProductsEntities;
		this.restaurantEntity = restaurantEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<MenuItemEntity> getMenuItemEntities() {
		return menuItemEntities;
	}

	public void setMenuItemEntities(List<MenuItemEntity> menuItemEntities) {
		this.menuItemEntities = menuItemEntities;
	}

	public List<DishLargenessEntity> getDishLargenessEntities() {
		return dishLargenessEntities;
	}

	public void setDishLargenessEntities(List<DishLargenessEntity> dishLargenessEntities) {
		this.dishLargenessEntities = dishLargenessEntities;
	}

	public List<GroupOfChangeableProductsEntity> getGroupOfChangeableProductsEntities() {
		return groupOfChangeableProductsEntities;
	}

	public void setGroupOfChangeableProductsEntities(
			List<GroupOfChangeableProductsEntity> groupOfChangeableProductsEntities) {
		this.groupOfChangeableProductsEntities = groupOfChangeableProductsEntities;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

}
