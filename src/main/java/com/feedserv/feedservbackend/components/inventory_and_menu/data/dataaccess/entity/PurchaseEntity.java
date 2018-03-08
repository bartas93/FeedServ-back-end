package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
import com.feedserv.feedservbackend.components.inventory_and_menu.data.enums.ShoppingStatus;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

@Entity
public class PurchaseEntity extends AbstractEntity {

	@DecimalMin("0,00")
	@NotNull
	private BigDecimal totalCost;
	@NotNull
	private LocalDateTime dateOfPurchase;
	@NotNull
	@Enumerated(EnumType.STRING)
	private ShoppingStatus shoppingStatus;
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private SupplierEntity supplierEntity;
	@OneToMany(mappedBy = "purchaseEntity")
	private List<PurchaseItemEntity> purchaseItemEntities;

	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	public PurchaseEntity() {
	}

	public PurchaseEntity(Long id) {
		super(id);
	}

	public PurchaseEntity(Long id, BigDecimal totalCost, LocalDateTime dateOfPurchase, ShoppingStatus shoppingStatus,
			SupplierEntity supplierEntity, List<PurchaseItemEntity> purchaseItemEntities,
			RestaurantEntity restaurantEntity) {
		super(id);
		this.totalCost = totalCost;
		this.dateOfPurchase = dateOfPurchase;
		this.shoppingStatus = shoppingStatus;
		this.supplierEntity = supplierEntity;
		this.purchaseItemEntities = purchaseItemEntities;
		this.restaurantEntity = restaurantEntity;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDateTime getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public ShoppingStatus getShoppingStatus() {
		return shoppingStatus;
	}

	public void setShoppingStatus(ShoppingStatus shoppingStatus) {
		this.shoppingStatus = shoppingStatus;
	}

	public SupplierEntity getSupplierEntity() {
		return supplierEntity;
	}

	public void setSupplierEntity(SupplierEntity supplierEntity) {
		this.supplierEntity = supplierEntity;
	}

	public List<PurchaseItemEntity> getPurchaseItemEntities() {
		return purchaseItemEntities;
	}

	public void setPurchaseItemEntities(List<PurchaseItemEntity> purchaseItemEntities) {
		this.purchaseItemEntities = purchaseItemEntities;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

}