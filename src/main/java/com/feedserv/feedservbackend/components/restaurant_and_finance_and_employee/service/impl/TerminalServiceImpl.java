package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.dao.OrderRepository;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.OrderEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.OrderLocationType;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.PaymentMethod;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.TerminalTo;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.service.TerminalService;

@Service
public class TerminalServiceImpl implements TerminalService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public TerminalTo getDailyTerminalTo(Long restaurantId) {
		boolean isCompleted = true;
		RestaurantEntity restaurantEntity = new RestaurantEntity(restaurantId);
		LocalDateTime todayFrom = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
		LocalDateTime todayTo = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
		List<OrderEntity> orders = this.orderRepository
				.findByRestaurantEntityAndIsCompletedAndPaymentTimeBetweenAndPaidAmountNotNull(restaurantEntity,
						isCompleted, todayFrom, todayTo);
		return orderEntitiesToTerminalTo(orders);
	}

	private TerminalTo orderEntitiesToTerminalTo(List<OrderEntity> orders) {
		if (orders != null && orders.size() > 0) {
			BigDecimal cashMoney = getMoneyByPaymentMethod(orders, PaymentMethod.CASH);
			BigDecimal bankTransferMoney = getMoneyByPaymentMethod(orders, PaymentMethod.BANK_TRANSFER);
			BigDecimal cardMoney = getMoneyByPaymentMethod(orders, PaymentMethod.CARD);
			int deliveryOrdersQuantity = getOrdersQuantityByOrderLocationType(orders, OrderLocationType.DELIVERY);
			int takeawayOrdersQuantity = getOrdersQuantityByOrderLocationType(orders, OrderLocationType.TAKEAWAY);
			int localOrdersQuantity = getOrdersQuantityByOrderLocationType(orders, OrderLocationType.LOCAL);
			BigDecimal deliveriesMoney = getMoneyByOrderLocationType(orders, OrderLocationType.DELIVERY);
			BigDecimal takeawayMoney = getMoneyByOrderLocationType(orders, OrderLocationType.TAKEAWAY);
			BigDecimal localMoney = getMoneyByOrderLocationType(orders, OrderLocationType.LOCAL);

			return new TerminalTo(LocalDate.now(), LocalDate.now(), cashMoney, cardMoney, bankTransferMoney,
					deliveryOrdersQuantity, deliveriesMoney, takeawayOrdersQuantity, takeawayMoney, localOrdersQuantity,
					localMoney);
		}
		return null;
	}

	private BigDecimal getMoneyByOrderLocationType(List<OrderEntity> orderEntities,
			OrderLocationType orderLocationType) {
		List<OrderEntity> filtredOrders = orderEntities.stream()
				.filter(o -> o.getOrderLocationType() == orderLocationType).collect(Collectors.toList());
		if (filtredOrders != null && filtredOrders.size() > 0) {

			BigDecimal sumOfMoney = orderEntities.stream().filter(o -> o.getOrderLocationType() == orderLocationType)
					.map(OrderEntity::getPaidAmount).reduce(BigDecimal::add).get();
			return sumOfMoney;
		}
		return new BigDecimal(0);
	}

	private int getOrdersQuantityByOrderLocationType(List<OrderEntity> orderEntities,
			OrderLocationType orderLocationType) {
		int ordersQuantity = orderEntities.stream().filter(o -> o.getOrderLocationType() == orderLocationType)
				.collect(Collectors.toList()).size();
		return ordersQuantity;
	}

	private BigDecimal getMoneyByPaymentMethod(List<OrderEntity> orderEntities, PaymentMethod paymentMethod) {
		List<OrderEntity> filtredOrders = orderEntities.stream().filter(o -> o.getPaymentMethod() == paymentMethod)
				.collect(Collectors.toList());
		if (filtredOrders != null && filtredOrders.size() > 0) {

			BigDecimal sumOfMoney = orderEntities.stream().filter(o -> o.getPaymentMethod() == paymentMethod)
					.map(OrderEntity::getPaidAmount).reduce(BigDecimal::add).get();
			return sumOfMoney;
		}
		return new BigDecimal(0);
	}

}
