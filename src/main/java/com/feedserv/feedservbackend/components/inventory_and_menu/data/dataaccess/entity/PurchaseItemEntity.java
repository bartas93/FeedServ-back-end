package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;

@Entity
public class PurchaseItemEntity extends AbstractEntity {

	@Min(0)
	@NotNull
	private int quantityInUnits;

	@DecimalMax("1000.00")
	@DecimalMin("0.00")
	private BigDecimal itemCost;

	@ManyToOne
	@JoinColumn(name = "purchase_id")
	private PurchaseEntity purchaseEntity;

	@ManyToOne
	@JoinColumn(name = "dictionary_product_id")
	private DictionaryProductEntity dictionaryProductEntity;

	public PurchaseItemEntity() {
	}

	public PurchaseItemEntity(Long id) {
		super(id);
	}

	public PurchaseItemEntity(Long id, int quantityInUnits, BigDecimal itemCost, PurchaseEntity purchaseEntity,
			DictionaryProductEntity dictionaryProductEntity) {
		super(id);
		this.quantityInUnits = quantityInUnits;
		this.itemCost = itemCost;
		this.purchaseEntity = purchaseEntity;
		this.dictionaryProductEntity = dictionaryProductEntity;
	}

	public int getQuantityInUnits() {
		return quantityInUnits;
	}

	public void setQuantityInUnits(int quantityInUnits) {
		this.quantityInUnits = quantityInUnits;
	}

	public BigDecimal getItemCost() {
		return itemCost;
	}

	public void setItemCost(BigDecimal itemCost) {
		this.itemCost = itemCost;
	}

	public PurchaseEntity getPurchaseEntity() {
		return purchaseEntity;
	}

	public void setPurchaseEntity(PurchaseEntity purchaseEntity) {
		this.purchaseEntity = purchaseEntity;
	}

	public DictionaryProductEntity getDictionaryProductEntity() {
		return dictionaryProductEntity;
	}

	public void setDictionaryProductEntity(DictionaryProductEntity dictionaryProductEntity) {
		this.dictionaryProductEntity = dictionaryProductEntity;
	}

}