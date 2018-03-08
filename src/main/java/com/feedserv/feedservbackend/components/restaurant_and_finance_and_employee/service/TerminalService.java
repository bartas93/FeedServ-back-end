package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.service;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.TerminalTo;

public interface TerminalService {

	TerminalTo getDailyTerminalTo(Long restaurantId);

}
