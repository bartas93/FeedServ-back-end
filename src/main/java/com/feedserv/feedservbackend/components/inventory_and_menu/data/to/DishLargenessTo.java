package com.feedserv.feedservbackend.components.inventory_and_menu.data.to;

public class DishLargenessTo {
	private Long id;
	private String name;

	public DishLargenessTo() {
	}

	public DishLargenessTo(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
