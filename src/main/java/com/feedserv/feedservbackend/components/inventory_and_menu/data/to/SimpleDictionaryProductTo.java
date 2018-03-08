package com.feedserv.feedservbackend.components.inventory_and_menu.data.to;

import com.feedserv.feedservbackend.components.inventory_and_menu.data.enums.Unit;

public class SimpleDictionaryProductTo {
	private Long id;
	private String name;
	private Unit unit;
	private String imageUrl;

	public SimpleDictionaryProductTo() {
	}

	public SimpleDictionaryProductTo(Long id, String name, Unit unit, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.imageUrl = imageUrl;
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

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
