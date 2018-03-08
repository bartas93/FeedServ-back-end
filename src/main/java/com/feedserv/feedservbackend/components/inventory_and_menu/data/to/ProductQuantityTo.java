package com.feedserv.feedservbackend.components.inventory_and_menu.data.to;

public class ProductQuantityTo {
	private Long id;
	private int quantityInUnits;
	private SimpleDictionaryProductTo simpleDictionaryProductTo;

	public ProductQuantityTo() {
	}

	public ProductQuantityTo(Long id, int quantityInUnits, SimpleDictionaryProductTo simpleDictionaryProductTo) {
		super();
		this.id = id;
		this.quantityInUnits = quantityInUnits;
		this.simpleDictionaryProductTo = simpleDictionaryProductTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantityInUnits() {
		return quantityInUnits;
	}

	public void setQuantityInUnits(int quantityInUnits) {
		this.quantityInUnits = quantityInUnits;
	}

	public SimpleDictionaryProductTo getSimpleDictionaryProductTo() {
		return simpleDictionaryProductTo;
	}

	public void setSimpleDictionaryProductTo(SimpleDictionaryProductTo simpleDictionaryProductTo) {
		this.simpleDictionaryProductTo = simpleDictionaryProductTo;
	}

}
