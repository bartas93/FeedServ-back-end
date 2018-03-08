package com.feedserv.feedservbackend.components.order_and_customer_and_partner.service;

import java.util.List;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.CustomerTableTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.CustomerWithoutOrdersTo;

public interface CustomerService {
	List<CustomerWithoutOrdersTo> getCustomersByPartOfPhoneNumber(String partOfPhoneNumber);

	List<CustomerTableTo> getCustomerTableTos(Long restaurantId);

}
