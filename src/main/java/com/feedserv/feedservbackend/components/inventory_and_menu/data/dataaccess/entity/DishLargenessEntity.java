package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

@Entity
public class DishLargenessEntity extends AbstractEntity {

	@NotNull
	private String name;
	@ManyToOne
	@JoinColumn(name = "dish_type_id")
	private DishTypeEntity dishTypeEntity;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	public DishLargenessEntity() {
	}

	public DishLargenessEntity(Long id) {
		super(id);
	}

	public DishLargenessEntity(Long id, String name, DishTypeEntity dishTypeEntity, RestaurantEntity restaurantEntity) {
		super(id);
		this.name = name;
		this.dishTypeEntity = dishTypeEntity;
		this.restaurantEntity = restaurantEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
