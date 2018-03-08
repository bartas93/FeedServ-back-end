package com.feedserv.feedservbackend.components.order_and_customer_and_partner.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feedserv.feedservbackend.auth.JWTDecoder;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.CustomerTableTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.CustomerWithoutOrdersTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/{partOfPhoneNumber}", method = RequestMethod.GET)
	public List<CustomerWithoutOrdersTo> getOrdersInProgress(
			@PathVariable("partOfPhoneNumber") String partOfPhoneNumber) {
		return customerService.getCustomersByPartOfPhoneNumber(partOfPhoneNumber);
	}

	@RequestMapping(value = "/customer-table", method = RequestMethod.GET)
	public List<CustomerTableTo> getCustomerTableTos(@RequestHeader(value = "Authorization") String bearerToken) {
		Long restaurantId = JWTDecoder.getJwtEntity(bearerToken).getRestaurantId();
		return customerService.getCustomerTableTos(restaurantId);
	}

}
