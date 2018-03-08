package com.feedserv.feedservbackend.components.inventory_and_menu.data.to;

import java.util.List;

public class ShowMenuDishTypeTo {

	private Long id;
	private String name;
	private String imageUrl;
	private List<ShowMenuItemTo> showMenuItemTos;

	public ShowMenuDishTypeTo() {
	}

	public ShowMenuDishTypeTo(Long id, String name, String imageUrl, List<ShowMenuItemTo> showMenuItemTos) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.showMenuItemTos = showMenuItemTos;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<ShowMenuItemTo> getShowMenuItemTos() {
		return showMenuItemTos;
	}

	public void setShowMenuItemTos(List<ShowMenuItemTo> showMenuItemTos) {
		this.showMenuItemTos = showMenuItemTos;
	}

}
