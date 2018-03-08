package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.OrderEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.HistoryTableOrderTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.NewOrderTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.SimpleOrderTo;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.dao.EmployeeRepository;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.dao.RestaurantRepository;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.mapper.EmployeeMapper;

@Component
public class OrderMapper {

	@Autowired
	private RestaurantRepository restaurantRepository;
	private static RestaurantRepository staticRestaurantRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	private static EmployeeRepository staticEmployeeRepository;

	@SuppressWarnings("static-access")
	@PostConstruct
	public void init() {
		this.staticRestaurantRepository = restaurantRepository;
		this.staticEmployeeRepository = employeeRepository;
	}

	public static List<SimpleOrderTo> entities2SimpleTos(List<OrderEntity> orderEntities) {
		List<SimpleOrderTo> simpleOrderTos = new ArrayList<>();
		if (orderEntities != null && orderEntities.size() != 0) {
			orderEntities.forEach(orderEntity -> {
				simpleOrderTos.add(entity2SimpleTo(orderEntity));
			});
		}
		return simpleOrderTos;
	}

	public static SimpleOrderTo entity2SimpleTo(OrderEntity orderEntity) {
		if (orderEntity != null) {
			return new SimpleOrderTo(orderEntity.getId(), orderEntity.getDeliveryGroup(), orderEntity.getReceivedTime(),
					orderEntity.getOrderAtTime(), orderEntity.getCustomerTable(), orderEntity.getPaymentMethod(),
					orderEntity.getOrderStatus(), orderEntity.isCompleted(), orderEntity.getOrderLocationType(),
					EmployeeMapper.entity2SimpleTo(orderEntity.getDriverEmployeeEntity()),
					EmployeeMapper.entity2SimpleTo(orderEntity.getReveivedByEmployeeEntity()),
					AddressMapper.entity2SimpleTo(orderEntity.getAddressEntity()),
					CustomerMapper.entity2SimpleTo(orderEntity.getCustomerEntity()),
					PartnerMapper.entity2SimpleTo(orderEntity.getPartnerEntity()),
					OrderItemMapper.entities2SimpleTos(orderEntity.getOrderItemEntities()), orderEntity.getPaidAmount(),
					orderEntity.getDeliveryCost(), orderEntity.getComment(), orderEntity.getPaymentTime());
		} else {
			return null;
		}
	}

	public static OrderEntity newTo2Entity(NewOrderTo newOrderTo) {
		if (newOrderTo != null) {
			RestaurantEntity restaurantEntity = staticRestaurantRepository.findOne(newOrderTo.getRestaurantId());
			OrderEntity.Builder builder = new OrderEntity.Builder(newOrderTo.getDeliveryGroup(),
					newOrderTo.getCustomerTable(), newOrderTo.getOrderAtTime(), newOrderTo.getReceivedTime(),
					newOrderTo.getDeliveryCost(), newOrderTo.getPaymentMethod(), newOrderTo.getOrderStatus(),
					newOrderTo.getOrderLocationType(), newOrderTo.getComment())
							.reveivedByEmployeeEntity(
									staticEmployeeRepository.findOne(newOrderTo.getReveivedByEmployeeId()))
							.restaurantEntity(staticRestaurantRepository.findOne(newOrderTo.getRestaurantId()))
							.customerEntity(
									CustomerMapper.withoutOrdersTo2Entity(newOrderTo.getCustomerWithoutOrdersTo()))
							.addressEntity(AddressMapper.to2Entity(newOrderTo.getAddressTo()));
			if (newOrderTo.getDriverEmployeeId() != null) {
				builder.driverEmployeeEntity(staticEmployeeRepository.findOne(newOrderTo.getDriverEmployeeId()));
			}
			OrderEntity orderEntity = builder.build();
			orderEntity.setOrderItemEntities(new ArrayList<>());
			if (newOrderTo.getNewOrderItemTos() != null && newOrderTo.getNewOrderItemTos().size() > 0) {
				newOrderTo.getNewOrderItemTos().forEach(newOrderItemTo -> {
					orderEntity.addOrderItemEntity(OrderItemMapper.newTo2Entity(newOrderItemTo, restaurantEntity));
				});
			}
			return orderEntity;
		} else {
			return null;
		}
	}

	public static List<HistoryTableOrderTo> entities2HistoryTableTo(List<OrderEntity> orderEntities) {
		List<HistoryTableOrderTo> historyTableOrderTos = new ArrayList<>();
		if (orderEntities != null && orderEntities.size() > 0) {
			orderEntities.forEach(orderEntity -> {
				historyTableOrderTos.add(entity2HistoryTableTo(orderEntity));
			});
		}
		return historyTableOrderTos;
	}

	public static HistoryTableOrderTo entity2HistoryTableTo(OrderEntity orderEntity) {
		if (orderEntity != null) {

			HistoryTableOrderTo historyTableOrderTo = new HistoryTableOrderTo(orderEntity.getId(),
					orderEntity.getReceivedTime(), orderEntity.getPaymentTime(), orderEntity.getPaidAmount(),
					orderEntity.getPaymentMethod(), orderEntity.getOrderStatus(), orderEntity.getOrderLocationType(),
					null, null, 0);
			if (orderEntity.getCustomerEntity() != null) {
				historyTableOrderTo.setCustomerPhoneNumber(orderEntity.getCustomerEntity().getPhoneNumber());
			}
			if (orderEntity.getPartnerEntity() != null) {
				historyTableOrderTo.setPartnerName(orderEntity.getPartnerEntity().getName());
			}
			if (orderEntity.getOrderItemEntities() != null) {
				historyTableOrderTo.setQuantityOfDishes(orderEntity.getOrderItemEntities().size());
			}
			return historyTableOrderTo;
		} else {
			return null;
		}
	}

}
