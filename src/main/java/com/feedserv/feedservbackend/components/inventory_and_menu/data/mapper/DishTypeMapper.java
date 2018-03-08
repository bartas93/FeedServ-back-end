package com.feedserv.feedservbackend.components.inventory_and_menu.data.mapper;

import java.util.ArrayList;
import java.util.List;

import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity.DishTypeEntity;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.to.ShowMenuDishTypeTo;

public class DishTypeMapper {

	public static ShowMenuDishTypeTo entity2ShowTo(DishTypeEntity dishTypeEntity) {
		if (dishTypeEntity != null) {

			return new ShowMenuDishTypeTo(dishTypeEntity.getId(), dishTypeEntity.getName(), dishTypeEntity.getImageUrl(),
					MenuItemMapper.entities2ShowTos(dishTypeEntity.getMenuItemEntities()));
		} else {
			return null;
		}
	}

	public static List<ShowMenuDishTypeTo> entities2ShowTos(List<DishTypeEntity> dishTypeEntities) {
		List<ShowMenuDishTypeTo> simpleDishTypeTos = new ArrayList<>();
		if (dishTypeEntities != null && dishTypeEntities.size() > 0) {
			dishTypeEntities.forEach(dishTypeEntity -> {
				simpleDishTypeTos.add(entity2ShowTo(dishTypeEntity));
			});
		}
		return simpleDishTypeTos;
	}
}
