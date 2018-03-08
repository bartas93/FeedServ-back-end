package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.dao.MenuItemDishLargenessRepository;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.mapper.ChangesInOrderItemMapper;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.OrderItemEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.NewOrderItemTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.SimpleOrderItemTo;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

@Component
public class OrderItemMapper {

	@Autowired
	private MenuItemDishLargenessRepository menuItemDishLargenessRepository;
	private static MenuItemDishLargenessRepository menuItemDishLargenessRepositoryStatic;

	@PostConstruct
	public void init() {
		OrderItemMapper.menuItemDishLargenessRepositoryStatic = menuItemDishLargenessRepository;
	}

	public static List<SimpleOrderItemTo> entities2SimpleTos(List<OrderItemEntity> orderItemEntities) {
		List<SimpleOrderItemTo> simpleOrderItemTos = new ArrayList<>();
		if (orderItemEntities != null && orderItemEntities.size() != 0) {
			orderItemEntities.forEach(orderItem -> {
				simpleOrderItemTos.add(entity2SimpleTo(orderItem));
			});
		}
		return simpleOrderItemTos;
	}

	public static SimpleOrderItemTo entity2SimpleTo(OrderItemEntity orderItemEntity) {
		if (orderItemEntity != null) {
			return new SimpleOrderItemTo(orderItemEntity.getId(),
					orderItemEntity.getMenuItemDishLargenessEntity().getMenuItemEntity().getName(),
					orderItemEntity.getMenuItemDishLargenessEntity().getMenuItemEntity().getImageUrl(),
					orderItemEntity.getMenuItemDishLargenessEntity().getMenuItemEntity().getDishTypeEntity().getName(),
					orderItemEntity.getMenuItemDishLargenessEntity().getDishLargenessEntity().getName(),
					orderItemEntity.getTotalCostWithAdditionalProducts(), isOrderItemChanged(orderItemEntity),
					orderItemEntity.isCooked(), isOrderItemInPromotion(orderItemEntity));
		} else {
			return null;
		}
	}

	private static boolean isOrderItemInPromotion(OrderItemEntity orderItemEntity) {

		if (orderItemEntity.getMenuItemDishLargenessEntity().getPromotionEntity() != null) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isOrderItemChanged(OrderItemEntity orderItemEntity) {
		if (orderItemEntity.getChangesInOrderItemEntities() == null
				|| orderItemEntity.getChangesInOrderItemEntities().size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static OrderItemEntity newTo2Entity(NewOrderItemTo newOrderItemTo, RestaurantEntity restaurantEntity) {
		if (newOrderItemTo != null) {
			OrderItemEntity orderItemEntity = new OrderItemEntity(newOrderItemTo.getId(),
					menuItemDishLargenessRepositoryStatic.findOne(newOrderItemTo.getMenuItemDishLargenessId()),
					newOrderItemTo.getTotalCostWithAdditionalProducts(), null, null, restaurantEntity, false);
			if (newOrderItemTo.getNewChangesInOrderItemTos() != null
					&& newOrderItemTo.getNewChangesInOrderItemTos().size() > 0) {
				orderItemEntity.setChangesInOrderItemEntities(new ArrayList<>());
				newOrderItemTo.getNewChangesInOrderItemTos().forEach(newChangesInOrderItemTo -> {
					orderItemEntity.addChangesInOrderItemEntity(
							ChangesInOrderItemMapper.newTo2Entity(newChangesInOrderItemTo));
				});
			}
			return orderItemEntity;
		} else {
			return null;
		}
	}

}