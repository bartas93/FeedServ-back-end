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
public class MenuItemEntity extends AbstractEntity {

	@NotNull
	private String name;
	// TODO jakies ograniczenia?
	private String description;
	private String imageUrl;
	@OneToMany(mappedBy = "menuItemEntity")
	private List<MenuItemDishLargenessEntity> menuItemDishLargenessEntities;
	@ManyToOne
	@JoinColumn(name = "dish_type_id")
	private DishTypeEntity dishTypeEntity;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	public MenuItemEntity() {
	}

	public MenuItemEntity(Long id) {
		super(id);
	}

	public MenuItemEntity(Long id, String name, String description, String imageUrl,
			List<MenuItemDishLargenessEntity> menuItemDishLargenessEntities, DishTypeEntity dishTypeEntity,
			RestaurantEntity restaurantEntity) {
		super(id);
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.menuItemDishLargenessEntities = menuItemDishLargenessEntities;
		this.dishTypeEntity = dishTypeEntity;
		this.restaurantEntity = restaurantEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<MenuItemDishLargenessEntity> getMenuItemDishLargenessEntities() {
		return menuItemDishLargenessEntities;
	}

	public void setMenuItemDishLargenessEntities(List<MenuItemDishLargenessEntity> menuItemDishLargenessEntities) {
		this.menuItemDishLargenessEntities = menuItemDishLargenessEntities;
	}

	public DishTypeEntity getDishTypeEntity() {
		return dishTypeEntity;
	}

	public void setDishTypeEntity(DishTypeEntity dishTypeEntity) {
		this.dishTypeEntity = dishTypeEntity;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

}
