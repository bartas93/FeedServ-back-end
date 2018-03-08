package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.OrderLocationType;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.OrderStatus;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.PaymentMethod;

public class NewOrderTo {
	private Long id;
	private Long deliveryGroup;
	private String customerTable;
	private LocalDateTime orderAtTime;
	private LocalDateTime receivedTime;
	private BigDecimal deliveryCost;
	private PaymentMethod paymentMethod;
	private OrderStatus orderStatus;
	private OrderLocationType orderLocationType;
	private Long driverEmployeeId;
	private Long reveivedByEmployeeId;

	private CustomerWithoutOrdersTo customerWithoutOrdersTo;
	private AddressTo addressTo;
	private List<NewOrderItemTo> newOrderItemTos;
	private String comment;
	private Long restaurantId;

	public NewOrderTo() {
	}

	public NewOrderTo(Long id, Long deliveryGroup, String customerTable, LocalDateTime orderAtTime,
			LocalDateTime receivedTime, BigDecimal deliveryCost, PaymentMethod paymentMethod, OrderStatus orderStatus,
			OrderLocationType orderLocationType, Long driverEmployeeId, Long reveivedByEmployeeId,
			CustomerWithoutOrdersTo customerWithoutOrdersTo, AddressTo addressTo, List<NewOrderItemTo> newOrderItemTos,
			String comment, Long restaurantId) {
		super();
		this.id = id;
		this.deliveryGroup = deliveryGroup;
		this.customerTable = customerTable;
		this.orderAtTime = orderAtTime;
		this.receivedTime = receivedTime;
		this.deliveryCost = deliveryCost;
		this.paymentMethod = paymentMethod;
		this.orderStatus = orderStatus;
		this.orderLocationType = orderLocationType;
		this.driverEmployeeId = driverEmployeeId;
		this.reveivedByEmployeeId = reveivedByEmployeeId;
		this.customerWithoutOrdersTo = customerWithoutOrdersTo;
		this.addressTo = addressTo;
		this.newOrderItemTos = newOrderItemTos;
		this.comment = comment;
		this.restaurantId = restaurantId;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDeliveryGroup() {
		return deliveryGroup;
	}

	public void setDeliveryGroup(Long deliveryGroup) {
		this.deliveryGroup = deliveryGroup;
	}

	public String getCustomerTable() {
		return customerTable;
	}

	public void setCustomerTable(String customerTable) {
		this.customerTable = customerTable;
	}

	public LocalDateTime getOrderAtTime() {
		return orderAtTime;
	}

	public void setOrderAtTime(LocalDateTime orderAtTime) {
		this.orderAtTime = orderAtTime;
	}

	public LocalDateTime getReceivedTime() {
		return receivedTime;
	}

	public void setReceivedTime(LocalDateTime receivedTime) {
		this.receivedTime = receivedTime;
	}

	public BigDecimal getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(BigDecimal deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderLocationType getOrderLocationType() {
		return orderLocationType;
	}

	public void setOrderLocationType(OrderLocationType orderLocationType) {
		this.orderLocationType = orderLocationType;
	}

	public Long getDriverEmployeeId() {
		return driverEmployeeId;
	}

	public void setDriverEmployeeId(Long driverEmployeeId) {
		this.driverEmployeeId = driverEmployeeId;
	}

	public Long getReveivedByEmployeeId() {
		return reveivedByEmployeeId;
	}

	public void setReveivedByEmployeeId(Long reveivedByEmployeeId) {
		this.reveivedByEmployeeId = reveivedByEmployeeId;
	}

	public CustomerWithoutOrdersTo getCustomerWithoutOrdersTo() {
		return customerWithoutOrdersTo;
	}

	public void setCustomerWithoutOrdersTo(CustomerWithoutOrdersTo customerWithoutOrdersTo) {
		this.customerWithoutOrdersTo = customerWithoutOrdersTo;
	}

	public AddressTo getAddressTo() {
		return addressTo;
	}

	public void setAddressTo(AddressTo addressTo) {
		this.addressTo = addressTo;
	}

	public List<NewOrderItemTo> getNewOrderItemTos() {
		return newOrderItemTos;
	}

	public void setNewOrderItemTos(List<NewOrderItemTo> newOrderItemTos) {
		this.newOrderItemTos = newOrderItemTos;
	}

}