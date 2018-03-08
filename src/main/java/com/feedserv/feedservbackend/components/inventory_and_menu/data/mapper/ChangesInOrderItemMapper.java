package com.feedserv.feedservbackend.components.inventory_and_menu.data.mapper;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.dao.GroupOfChangeableProductsRepository;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity.GroupOfChangeableProductsEntity;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.to.NewChangesInOrderItemTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.ChangesInOrderItemEntity;

@Component
public class ChangesInOrderItemMapper {

	@Autowired
	private GroupOfChangeableProductsRepository groupOfChangeableProductsRepository;
	private static GroupOfChangeableProductsRepository staticGroupOfChangeableProductsRepository;

	@SuppressWarnings("static-access")
	@PostConstruct
	public void init() {
		this.staticGroupOfChangeableProductsRepository = groupOfChangeableProductsRepository;
	}

	public static ChangesInOrderItemEntity newTo2Entity(NewChangesInOrderItemTo newChangesInOrderItemTo) {

		if (newChangesInOrderItemTo != null) {
			GroupOfChangeableProductsEntity groupOfChangeableProductEntity = staticGroupOfChangeableProductsRepository
					.findOne(newChangesInOrderItemTo.getGroupOfChangableProductsId());
			ChangesInOrderItemEntity changesInOrderItemEntity = new ChangesInOrderItemEntity(
					newChangesInOrderItemTo.getId(), groupOfChangeableProductEntity, null, null, null);
			changesInOrderItemEntity.setAddedProducts(new ArrayList<>());
			changesInOrderItemEntity.setRemovedProducts(new ArrayList<>());
			newChangesInOrderItemTo.getAddedProducts().forEach(newChangeableProductTo -> {
				changesInOrderItemEntity.addChangeableProductEntityToAddedProducts(
						ChangeableProductMapper.newTo2Entity(newChangeableProductTo, groupOfChangeableProductEntity));
			});
			newChangesInOrderItemTo.getRemovedProducts().forEach(newChangeableProductTo -> {
				changesInOrderItemEntity.addChangeableProductEntityToRemovedProducts(
						ChangeableProductMapper.newTo2Entity(newChangeableProductTo, groupOfChangeableProductEntity));
			});
			return changesInOrderItemEntity;
		} else {
			return null;

		}
	}
}
