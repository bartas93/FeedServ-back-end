package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feedserv.feedservbackend.auth.JWTDecoder;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.TerminalTo;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.service.TerminalService;

@RestController
@RequestMapping("/terminal")
public class TerminalRestService {

	@Autowired
	private TerminalService terminalService;

	@RequestMapping(value = "/today", method = RequestMethod.GET)
	public TerminalTo getDailyTerminalTo(@RequestHeader(value = "Authorization") String bearerToken) {
		Long restaurantId = JWTDecoder.getJwtEntity(bearerToken).getRestaurantId();
		return terminalService.getDailyTerminalTo(restaurantId);
	}

}
