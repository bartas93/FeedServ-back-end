package com.feedserv.feedservbackend.components.inventory_and_menu.data.mapper;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.dao.DishLargenessRepository;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.dao.ProductQuantityRepository;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity.ChangeableProductEntity;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity.GroupOfChangeableProductsEntity;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.to.NewChangeableProductTo;

@Component
public class ChangeableProductMapper {

	@Autowired
	private ProductQuantityRepository productQuantityRepository;
	private static ProductQuantityRepository staticProductQuantityRepository;
	@Autowired
	private DishLargenessRepository dishLargenessRepository;
	private static DishLargenessRepository staticDishLargenessRepository;

	@SuppressWarnings("static-access")
	@PostConstruct
	public void init() {
		this.staticProductQuantityRepository = productQuantityRepository;
		this.staticDishLargenessRepository = dishLargenessRepository;
	}

	public static ChangeableProductEntity newTo2Entity(NewChangeableProductTo newChangeableProductTo,
			GroupOfChangeableProductsEntity groupOfChangeableProductEntity) {
		if (newChangeableProductTo != null) {
			ChangeableProductEntity changeableProductEntity = new ChangeableProductEntity(
					newChangeableProductTo.getId(), groupOfChangeableProductEntity,
					staticProductQuantityRepository.findOne(newChangeableProductTo.getProductQuantityId()),
					newChangeableProductTo.getAdditionalCost(),
					staticDishLargenessRepository.findOne(newChangeableProductTo.getDishLargenessId()));
			return changeableProductEntity;
		}
		return null;
	}

}
