package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.OrderEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

	List<OrderEntity> findByRestaurantEntityAndIsCompleted(RestaurantEntity restaurantEntity, boolean isCompleted);

	List<OrderEntity> findByRestaurantEntityAndIsCompletedOrderByPaymentTimeDesc(RestaurantEntity restaurantEntity,
			boolean isCompleted);

	List<OrderEntity> findByRestaurantEntityAndIsCompletedAndPaymentTimeBetweenAndPaidAmountNotNull(
			RestaurantEntity restaurantEntity, boolean isCompleted, LocalDateTime from, LocalDateTime to);

}
