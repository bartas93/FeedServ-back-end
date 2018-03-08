package com.feedserv.feedservbackend.components.inventory_and_menu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feedserv.feedservbackend.auth.InvalidRestaurantIdException;
import com.feedserv.feedservbackend.auth.JWTDecoder;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.to.ShowMenuDishTypeTo;
import com.feedserv.feedservbackend.components.inventory_and_menu.service.DishTypeService;

@CrossOrigin
@RestController
@RequestMapping("/dish-type")
public class DishTypeRestController {

	@Autowired
	private DishTypeService dishTypeService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<ShowMenuDishTypeTo> getSimpleDishTypeTos(@RequestHeader(value = "Authorization") String bearerToken)
			throws InvalidRestaurantIdException {
		Long restaurantId = JWTDecoder.getJwtEntity(bearerToken).getRestaurantId();
		return dishTypeService.getSimpleDishTypeTos(restaurantId);
	}
}
