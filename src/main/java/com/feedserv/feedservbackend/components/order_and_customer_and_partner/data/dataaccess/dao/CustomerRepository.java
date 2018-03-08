package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	List<CustomerEntity> findByPhoneNumberContaining(String phoneNumber);

	CustomerEntity findByPhoneNumber(String phoneNumber);

	@Query(value = "SELECT c.* FROM customer_entity c LEFT JOIN order_entity o ON c.id=o.customer_id WHERE o.restaurant_id=?1 GROUP BY c.id", nativeQuery = true)
	List<CustomerEntity> getByRestaurantId(Long restaurantId);
}
