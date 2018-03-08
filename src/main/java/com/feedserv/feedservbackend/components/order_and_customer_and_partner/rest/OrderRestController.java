package com.feedserv.feedservbackend.components.order_and_customer_and_partner.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feedserv.feedservbackend.auth.InvalidRestaurantIdException;
import com.feedserv.feedservbackend.auth.JWTDecoder;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.HistoryTableOrderTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.NewOrderTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.SimpleOrderTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderRestController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/in-progress", method = RequestMethod.GET)
	public List<SimpleOrderTo> getOrdersInProgress(@RequestHeader(value = "Authorization") String bearerToken)
			throws InvalidRestaurantIdException {
		boolean isCompleted = false;
		Long restaurantId = JWTDecoder.getJwtEntity(bearerToken).getRestaurantId();
		return orderService.getOrdersByIsCompletedBoolean(restaurantId, isCompleted);
	}

	@RequestMapping(value = "/completed", method = RequestMethod.GET)
	public List<HistoryTableOrderTo> getCompletedOrders(@RequestHeader(value = "Authorization") String bearerToken)
			throws InvalidRestaurantIdException {
		Long restaurantId = JWTDecoder.getJwtEntity(bearerToken).getRestaurantId();
		return orderService.getHistoryTableOrders(restaurantId);
	}

	@RequestMapping(value = "/new-order", method = RequestMethod.POST)
	public SimpleOrderTo saveNewOrder(@RequestHeader(value = "Authorization") String bearerToken,
			@RequestBody NewOrderTo newOrderTo) {
		Long restaurantId = JWTDecoder.getJwtEntity(bearerToken).getRestaurantId();
		newOrderTo.setRestaurantId(restaurantId);
		return orderService.saveNewOrderTo(newOrderTo);
	}

	// TODO REST - powinien byc put!
	@RequestMapping(value = "/order-get-paid", method = RequestMethod.POST)
	public SimpleOrderTo orderGetPaid(@RequestBody SimpleOrderTo simpleOrderTo) {
		return orderService.orderGetPaid(simpleOrderTo);
	}
}
