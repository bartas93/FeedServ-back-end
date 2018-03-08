package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to;

public class SimpleEmployeeTo {
	private Long id;
	private String imageUrl;
	private String fullName;

	public SimpleEmployeeTo() {
	}

	public SimpleEmployeeTo(Long id, String imageUrl, String fullName) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.fullName = fullName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
