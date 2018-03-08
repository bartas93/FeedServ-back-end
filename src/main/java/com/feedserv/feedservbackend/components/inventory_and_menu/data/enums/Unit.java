package com.feedserv.feedservbackend.components.inventory_and_menu.data.enums;

public enum Unit {

	LITER("l"), MILILITER("ml"), KILOGRAM("kg"), GRAM("g"), PIECE("");

	private String displayName;

	private Unit(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
