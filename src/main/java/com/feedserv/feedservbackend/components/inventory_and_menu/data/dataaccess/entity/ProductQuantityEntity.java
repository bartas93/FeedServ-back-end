package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;

@Entity
public class ProductQuantityEntity extends AbstractEntity {
	@ManyToOne
	@JoinColumn(name = "dictionary_product_id")
	private DictionaryProductEntity dictionaryProductEntity;
	@NotNull
	private int quantityInUnits;

	public ProductQuantityEntity() {
	}

	public ProductQuantityEntity(Long id) {
		super(id);
	}

	public ProductQuantityEntity(Long id, DictionaryProductEntity dictionaryProductEntity, int quantityInUnits) {
		super(id);
		this.dictionaryProductEntity = dictionaryProductEntity;
		this.quantityInUnits = quantityInUnits;
	}

	public DictionaryProductEntity getDictionaryProductEntity() {
		return dictionaryProductEntity;
	}

	public void setDictionaryProductEntity(DictionaryProductEntity dictionaryProductEntity) {
		this.dictionaryProductEntity = dictionaryProductEntity;
	}

	public int getQuantityInUnits() {
		return quantityInUnits;
	}

	public void setQuantityInUnits(int quantityInUnits) {
		this.quantityInUnits = quantityInUnits;
	}

}
