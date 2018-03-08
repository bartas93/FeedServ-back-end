package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

@Entity
public class InventoryProductEntity extends AbstractEntity {

	@NotNull
	@Min(0)
	private int quantityInUnits;

	@NotNull
	@Min(0)
	private int minQuantityInUnitsToAlert;

	@ManyToOne
	@JoinColumn(name = "dictionary_product_id")
	private DictionaryProductEntity dictionaryProductEntity;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	public InventoryProductEntity() {
	}

	public InventoryProductEntity(Long id) {
		super(id);
	}

	public InventoryProductEntity(Long id, int quantityInUnits, int minQuantityInUnitsToAlert,
			DictionaryProductEntity dictionaryProductEntity, RestaurantEntity restaurantEntity) {
		super(id);
		this.quantityInUnits = quantityInUnits;
		this.minQuantityInUnitsToAlert = minQuantityInUnitsToAlert;
		this.dictionaryProductEntity = dictionaryProductEntity;
		this.restaurantEntity = restaurantEntity;
	}

	public int getQuantityInUnits() {
		return quantityInUnits;
	}

	public void setQuantityInUnits(int quantityInUnits) {
		this.quantityInUnits = quantityInUnits;
	}

	public int getMinQuantityInUnitsToAlert() {
		return minQuantityInUnitsToAlert;
	}

	public void setMinQuantityInUnitsToAlert(int minQuantityInUnitsToAlert) {
		this.minQuantityInUnitsToAlert = minQuantityInUnitsToAlert;
	}

	public DictionaryProductEntity getDictionaryProductEntity() {
		return dictionaryProductEntity;
	}

	public void setDictionaryProductEntity(DictionaryProductEntity dictionaryProductEntity) {
		this.dictionaryProductEntity = dictionaryProductEntity;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

}