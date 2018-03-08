package com.feedserv.feedservbackend.components.inventory_and_menu.data.to;

import java.util.List;

public class ShowMenuItemTo {
	private Long id;
	private String name;
	private String description;
	private String imageUrl;
	private List<ShowSimpleMenuItemDishLargenessTo> menuItemDishLargenessTos;

	public ShowMenuItemTo() {
	}

	public ShowMenuItemTo(Long id, String name, String description, String imageUrl,
			List<ShowSimpleMenuItemDishLargenessTo> menuItemDishLargenessTos) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.menuItemDishLargenessTos = menuItemDishLargenessTos;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<ShowSimpleMenuItemDishLargenessTo> getMenuItemDishLargenessTos() {
		return menuItemDishLargenessTos;
	}

	public void setMenuItemDishLargenessTos(List<ShowSimpleMenuItemDishLargenessTo> menuItemDishLargenessTos) {
		this.menuItemDishLargenessTos = menuItemDishLargenessTos;
	}

}
