package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.enums.Unit;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

@Entity
public class DictionaryProductEntity extends AbstractEntity {
	@NotNull
	private String name;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Unit unit;
	@OneToMany(mappedBy = "simpleProduct")
	private List<ComplexProductCreationEntity> createdByProducts;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;
	private String imageUrl;

	public DictionaryProductEntity() {
	}

	public DictionaryProductEntity(Long id) {
		super(id);
	}

	public DictionaryProductEntity(Long id, String name, Unit unit,
			List<ComplexProductCreationEntity> createdByProducts, RestaurantEntity restaurantEntity, String imageUrl) {
		super(id);
		this.name = name;
		this.unit = unit;
		this.createdByProducts = createdByProducts;
		this.restaurantEntity = restaurantEntity;
		this.imageUrl = imageUrl;
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

	public List<ComplexProductCreationEntity> getCreatedByProducts() {
		return createdByProducts;
	}

	public void setCreatedByProducts(List<ComplexProductCreationEntity> createdByProducts) {
		this.createdByProducts = createdByProducts;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
