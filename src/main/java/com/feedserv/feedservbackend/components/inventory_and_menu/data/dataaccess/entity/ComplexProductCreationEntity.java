package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;

@Entity
public class ComplexProductCreationEntity extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "complex_product_id")
	private DictionaryProductEntity complexProduct;
	@ManyToOne
	@JoinColumn(name = "simple_product_id")
	private DictionaryProductEntity simpleProduct;
	@NotNull
	private int simpleProductQuantityToMake1000UnitsOfComplex;

	public ComplexProductCreationEntity() {
	}

	public ComplexProductCreationEntity(Long id) {
		super(id);
	}

	public ComplexProductCreationEntity(Long id, DictionaryProductEntity complexProduct,
			DictionaryProductEntity simpleProduct, int simpleProductQuantityToMake1000UnitsOfComplex) {
		super(id);
		this.complexProduct = complexProduct;
		this.simpleProduct = simpleProduct;
		this.simpleProductQuantityToMake1000UnitsOfComplex = simpleProductQuantityToMake1000UnitsOfComplex;
	}

	public DictionaryProductEntity getComplexProduct() {
		return complexProduct;
	}

	public void setComplexProduct(DictionaryProductEntity complexProduct) {
		this.complexProduct = complexProduct;
	}

	public DictionaryProductEntity getSimpleProduct() {
		return simpleProduct;
	}

	public void setSimpleProduct(DictionaryProductEntity simpleProduct) {
		this.simpleProduct = simpleProduct;
	}

	public int getSimpleProductQuantityToMake1000UnitsOfComplex() {
		return simpleProductQuantityToMake1000UnitsOfComplex;
	}

	public void setSimpleProductQuantityToMake1000UnitsOfComplex(int simpleProductQuantityToMake1000UnitsOfComplex) {
		this.simpleProductQuantityToMake1000UnitsOfComplex = simpleProductQuantityToMake1000UnitsOfComplex;
	}

}
