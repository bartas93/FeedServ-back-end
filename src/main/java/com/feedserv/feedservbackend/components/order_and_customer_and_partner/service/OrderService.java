package com.feedserv.feedservbackend.components.order_and_customer_and_partner.service;

import java.util.List;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.HistoryTableOrderTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.NewOrderTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.SimpleOrderTo;

public interface OrderService {

	List<SimpleOrderTo> getOrdersByIsCompletedBoolean(Long restaurantId, boolean isCompleted);

	SimpleOrderTo orderGetPaid(SimpleOrderTo simpleOrderTo);

	SimpleOrderTo saveNewOrderTo(NewOrderTo newOrderTo);

	List<HistoryTableOrderTo> getHistoryTableOrders(Long restaurantId);

}
