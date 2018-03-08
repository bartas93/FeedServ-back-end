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
public class SupplierEntity extends AbstractEntity {

	@NotNull
	private String name;
	@OneToMany(mappedBy = "supplierEntity")
	private List<PurchaseEntity> purchaseEntities;

	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	public SupplierEntity() {
	}

	public SupplierEntity(Long id) {
		super(id);
	}

	public SupplierEntity(Long id, String name, List<PurchaseEntity> purchaseEntities,
			RestaurantEntity restaurantEntity) {
		super(id);
		this.name = name;
		this.purchaseEntities = purchaseEntities;
		this.restaurantEntity = restaurantEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PurchaseEntity> getPurchaseEntities() {
		return purchaseEntities;
	}

	public void setPurchaseEntities(List<PurchaseEntity> purchaseEntities) {
		this.purchaseEntities = purchaseEntities;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

}