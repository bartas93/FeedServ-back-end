package com.feedserv.feedservbackend.components.inventory_and_menu.data.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity.MenuItemDishLargenessEntity;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.to.ShowSimpleMenuItemDishLargenessTo;

public class MenuItemDishLargenessMapper {

	public static List<ShowSimpleMenuItemDishLargenessTo> entities2ShowSimpleTos(
			List<MenuItemDishLargenessEntity> menuItemDishLargenessEntities) {
		List<ShowSimpleMenuItemDishLargenessTo> showMenuItemDishLargenessTos = new ArrayList<>();
		if (menuItemDishLargenessEntities != null && menuItemDishLargenessEntities.size() > 0) {
			menuItemDishLargenessEntities.forEach(menuItemDishLargenessEntity -> {
				showMenuItemDishLargenessTos.add(entity2ShowSimpleTo(menuItemDishLargenessEntity));
			});
		}
		return showMenuItemDishLargenessTos;
	}

	public static ShowSimpleMenuItemDishLargenessTo entity2ShowSimpleTo(MenuItemDishLargenessEntity menuItemDishLargenessEntity) {
		if (menuItemDishLargenessEntity != null) {
			return new ShowSimpleMenuItemDishLargenessTo(menuItemDishLargenessEntity.getId(),
					menuItemDishLargenessEntity.getDishLargenessEntity().getName(),
					menuItemDishLargenessEntity.getCost(), calculateCostAfterPromotion(menuItemDishLargenessEntity));
		} else {
			return null;
		}
	}

	private static BigDecimal calculateCostAfterPromotion(MenuItemDishLargenessEntity menuItemDishLargenessEntity) {
		BigDecimal costAfterPromotion = menuItemDishLargenessEntity.getCost();
		if (menuItemDishLargenessEntity.getPromotionEntity() != null) {
			switch (menuItemDishLargenessEntity.getPromotionEntity().getPromotionType()) {
			case MONEY_DISCOUNT:
				costAfterPromotion.subtract(menuItemDishLargenessEntity.getPromotionEntity().getRate());
				break;
			case PERCENTAGE_DISCOUNT:
				BigDecimal percentageMultiplier = new BigDecimal(100)
						.subtract(menuItemDishLargenessEntity.getPromotionEntity().getRate());
				costAfterPromotion.multiply(percentageMultiplier);
				break;
			case GRATIS:
				costAfterPromotion = new BigDecimal(0);
				break;
			}
		}
		return costAfterPromotion;
	}

}
