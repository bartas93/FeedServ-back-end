package com.feedserv.feedservbackend.components.inventory_and_menu.data.to;

import java.util.List;

public class GroupOfChangeableProductsTo {

	private Long id;
	private String name;
	private Integer maxChangeableProductsQuantity;
	private List<ChangeableProductTo> changeableProductTos;

	public GroupOfChangeableProductsTo() {
	}

	public GroupOfChangeableProductsTo(Long id, String name, Integer maxChangeableProductsQuantity,
			List<ChangeableProductTo> changeableProductTos) {
		super();
		this.id = id;
		this.name = name;
		this.maxChangeableProductsQuantity = maxChangeableProductsQuantity;
		this.changeableProductTos = changeableProductTos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaxChangeableProductsQuantity() {
		return maxChangeableProductsQuantity;
	}

	public void setMaxChangeableProductsQuantity(Integer maxChangeableProductsQuantity) {
		this.maxChangeableProductsQuantity = maxChangeableProductsQuantity;
	}

	public List<ChangeableProductTo> getChangeableProductTos() {
		return changeableProductTos;
	}

	public void setChangeableProductTos(List<ChangeableProductTo> changeableProductTos) {
		this.changeableProductTos = changeableProductTos;
	}

}
