package com.feedserv.feedservbackend.components.inventory_and_menu.data.mapper;

import java.util.ArrayList;
import java.util.List;

import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity.MenuItemEntity;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.to.ShowMenuItemTo;

public class MenuItemMapper {

	public static ShowMenuItemTo entity2ShowTo(MenuItemEntity menuItemEntity) {
		if (menuItemEntity != null) {
			return new ShowMenuItemTo(menuItemEntity.getId(), menuItemEntity.getName(),
					menuItemEntity.getDescription(), menuItemEntity.getImageUrl(),
					MenuItemDishLargenessMapper.entities2ShowSimpleTos(menuItemEntity.getMenuItemDishLargenessEntities()));
		} else {
			return null;
		}

	}

	public static List<ShowMenuItemTo> entities2ShowTos(List<MenuItemEntity> menuItemEntities) {
		List<ShowMenuItemTo> simpleMenuItemTos = new ArrayList<>();
		if (menuItemEntities != null && menuItemEntities.size() != 0) {
			menuItemEntities.forEach(menuItemEntity -> {
				simpleMenuItemTos.add(entity2ShowTo(menuItemEntity));
			});
		}
		return simpleMenuItemTos;
	}

}
