package com.feedserv.feedservbackend.components.inventory_and_menu.data.to;

import java.util.List;

public class NewChangesInOrderItemTo {

	private Long id;
	private Long groupOfChangableProductsId;
	private List<NewChangeableProductTo> addedProducts;
	private List<NewChangeableProductTo> removedProducts;

	public NewChangesInOrderItemTo() {
	}

	public NewChangesInOrderItemTo(Long id, Long groupOfChangableProductsId, List<NewChangeableProductTo> addedProducts,
			List<NewChangeableProductTo> removedProducts) {
		super();
		this.id = id;
		this.groupOfChangableProductsId = groupOfChangableProductsId;
		this.addedProducts = addedProducts;
		this.removedProducts = removedProducts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupOfChangableProductsId() {
		return groupOfChangableProductsId;
	}

	public void setGroupOfChangableProductsId(Long groupOfChangableProductsId) {
		this.groupOfChangableProductsId = groupOfChangableProductsId;
	}

	public List<NewChangeableProductTo> getAddedProducts() {
		return addedProducts;
	}

	public void setAddedProducts(List<NewChangeableProductTo> addedProducts) {
		this.addedProducts = addedProducts;
	}

	public List<NewChangeableProductTo> getRemovedProducts() {
		return removedProducts;
	}

	public void setRemovedProducts(List<NewChangeableProductTo> removedProducts) {
		this.removedProducts = removedProducts;
	}

}
