package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;

@Entity
public class ChangeableProductEntity extends AbstractEntity {
	@ManyToOne
	@JoinColumn(name = "group_of_changable_products_id")
	private GroupOfChangeableProductsEntity groupOfChangeableProductsEntity;
	@ManyToOne
	@JoinColumn(name = "product_quantity_id")
	private ProductQuantityEntity productQuantityEntity;
	@DecimalMax("30.00")
	@DecimalMin("0.00")
	private BigDecimal additionalCost;

	@ManyToOne
	@JoinColumn(name = "dish_largeness_id")
	private DishLargenessEntity dishLargenessEntity;

	public ChangeableProductEntity() {
	}

	public ChangeableProductEntity(Long id) {
		super(id);
	}

	public ChangeableProductEntity(Long id, GroupOfChangeableProductsEntity groupOfChangeableProductsEntity,
			ProductQuantityEntity productQuantityEntity, BigDecimal additionalCost,
			DishLargenessEntity dishLargenessEntity) {
		super(id);
		this.groupOfChangeableProductsEntity = groupOfChangeableProductsEntity;
		this.productQuantityEntity = productQuantityEntity;
		this.additionalCost = additionalCost;
		this.dishLargenessEntity = dishLargenessEntity;
	}

	public GroupOfChangeableProductsEntity getGroupOfChangeableProductsEntity() {
		return groupOfChangeableProductsEntity;
	}

	public void setGroupOfChangeableProductsEntity(GroupOfChangeableProductsEntity groupOfChangeableProductsEntity) {
		this.groupOfChangeableProductsEntity = groupOfChangeableProductsEntity;
	}

	public ProductQuantityEntity getProductQuantityEntity() {
		return productQuantityEntity;
	}

	public void setProductQuantityEntity(ProductQuantityEntity productQuantityEntity) {
		this.productQuantityEntity = productQuantityEntity;
	}

	public BigDecimal getAdditionalCost() {
		return additionalCost;
	}

	public void setAdditionalCost(BigDecimal additionalCost) {
		this.additionalCost = additionalCost;
	}

	public DishLargenessEntity getDishLargenessEntity() {
		return dishLargenessEntity;
	}

	public void setDishLargenessEntity(DishLargenessEntity dishLargenessEntity) {
		this.dishLargenessEntity = dishLargenessEntity;
	}

}