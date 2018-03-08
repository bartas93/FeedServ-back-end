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
public class GroupOfChangeableProductsEntity extends AbstractEntity {
	@NotNull
	private String name;
	@ManyToOne
	@JoinColumn(name = "dish_type_id")
	private DishTypeEntity dishTypeEntity;
	@OneToMany(mappedBy = "groupOfChangeableProductsEntity")
	private List<ChangeableProductEntity> changeableProductEntities;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	private Integer maxChangeableProductsQuantity;

	public GroupOfChangeableProductsEntity() {
	}

	public GroupOfChangeableProductsEntity(Long id) {
		super(id);
	}

	public GroupOfChangeableProductsEntity(Long id, String name, DishTypeEntity dishTypeEntity,
			List<ChangeableProductEntity> changeableProductEntities, RestaurantEntity restaurantEntity,
			Integer maxChangeableProductsQuantity) {
		super(id);
		this.name = name;
		this.dishTypeEntity = dishTypeEntity;
		this.changeableProductEntities = changeableProductEntities;
		this.restaurantEntity = restaurantEntity;
		this.maxChangeableProductsQuantity = maxChangeableProductsQuantity;
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

	public List<ChangeableProductEntity> getChangeableProductEntities() {
		return changeableProductEntities;
	}

	public void setChangeableProductEntities(List<ChangeableProductEntity> changeableProductEntities) {
		this.changeableProductEntities = changeableProductEntities;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

	public Integer getMaxChangeableProductsQuantity() {
		return maxChangeableProductsQuantity;
	}

	public void setMaxChangeableProductsQuantity(Integer maxChangeableProductsQuantity) {
		this.maxChangeableProductsQuantity = maxChangeableProductsQuantity;
	}

}