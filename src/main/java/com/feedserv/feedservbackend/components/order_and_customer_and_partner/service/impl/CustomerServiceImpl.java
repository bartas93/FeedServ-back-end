package com.feedserv.feedservbackend.components.order_and_customer_and_partner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.dao.CustomerRepository;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.mapper.CustomerMapper;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.CustomerTableTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.CustomerWithoutOrdersTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<CustomerWithoutOrdersTo> getCustomersByPartOfPhoneNumber(String partOfPhoneNumber) {
		return CustomerMapper
				.entities2WithoutOrdersTos(customerRepository.findByPhoneNumberContaining(partOfPhoneNumber));
	}

	@Override
	public List<CustomerTableTo> getCustomerTableTos(Long restaurantId) {
		return CustomerMapper.entities2TableTo(customerRepository.getByRestaurantId(restaurantId));
	}

}
