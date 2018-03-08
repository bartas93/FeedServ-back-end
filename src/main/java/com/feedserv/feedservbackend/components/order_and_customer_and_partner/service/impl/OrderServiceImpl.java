package com.feedserv.feedservbackend.components.order_and_customer_and_partner.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.dao.OrderRepository;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.OrderEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.OrderStatus;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.mapper.OrderMapper;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.HistoryTableOrderTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.NewOrderTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.SimpleOrderTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.service.OrderService;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<SimpleOrderTo> getOrdersByIsCompletedBoolean(Long restaurantId, boolean isCompleted) {
		RestaurantEntity restaurantEntity = new RestaurantEntity(restaurantId);
		List<OrderEntity> orderEntities = orderRepository.findByRestaurantEntityAndIsCompleted(restaurantEntity,
				isCompleted);
		return OrderMapper.entities2SimpleTos(orderEntities);
	}

	@Override
	public List<HistoryTableOrderTo> getHistoryTableOrders(Long restaurantId) {
		boolean isCompleted = true;
		RestaurantEntity restaurantEntity = new RestaurantEntity(restaurantId);
		List<OrderEntity> orderEntities = orderRepository
				.findByRestaurantEntityAndIsCompletedOrderByPaymentTimeDesc(restaurantEntity, isCompleted);
		return OrderMapper.entities2HistoryTableTo(orderEntities);
	}

	@Override
	public SimpleOrderTo orderGetPaid(SimpleOrderTo simpleOrderTo) {
		OrderEntity orderEntity = orderRepository.findOne(simpleOrderTo.getId());
		OrderEntity paidOrderEntity = mapThatOrderIsPaid(simpleOrderTo, orderEntity);
		OrderEntity savedOrderEntity = orderRepository.save(paidOrderEntity);
		return OrderMapper.entity2SimpleTo(savedOrderEntity);
	}

	@Override
	public SimpleOrderTo saveNewOrderTo(NewOrderTo newOrderTo) {
		OrderEntity orderEntity = OrderMapper.newTo2Entity(newOrderTo);
		OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
		return OrderMapper.entity2SimpleTo(savedOrderEntity);
	}

	private OrderEntity mapThatOrderIsPaid(SimpleOrderTo simpleOrderTo, OrderEntity orderEntity) {
		if (simpleOrderTo.getPaymentTime() == null) {
			orderEntity.setPaymentTime(LocalDateTime.now());
		} else {
			orderEntity.setPaymentTime(simpleOrderTo.getPaymentTime());
		}
		if (simpleOrderTo.getOrderStatus() != OrderStatus.CANCELED
				&& simpleOrderTo.getOrderStatus() != OrderStatus.CANCELED_AND_LOST) {
			orderEntity.setOrderStatus(OrderStatus.AT_THE_CUSTOMER);
		}
		orderEntity.setPaymentMethod(simpleOrderTo.getPaymentMethod());
		orderEntity.setCompleted(true);
		orderEntity.setPaidAmount(simpleOrderTo.getPaidAmount());
		return orderEntity;
	}

}
