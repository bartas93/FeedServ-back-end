package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.OrderLocationType;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.OrderStatus;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.PaymentMethod;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.SimpleEmployeeTo;

public class SimpleOrderTo {

	private Long id;
	private Long deliveryGroup;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "HH:mm  dd-MM-yyyy")
	private LocalDateTime receivedTime;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "HH:mm  dd-MM-yyyy")
	private LocalDateTime orderAtTime;
	private String customerTable;

	private PaymentMethod paymentMethod;
	private OrderStatus orderStatus;
	private boolean isCompleted;
	private OrderLocationType orderLocationType;

	private SimpleEmployeeTo driverSimpleEmployeeTo;
	private SimpleEmployeeTo reveivedBySimpleEmployeeTo;
	private SimpleAddressTo simpleAddressTo;
	private SimpleCustomerTo simpleCustomerTo;

	private SimplePartnerTo simplePartnerTo;
	private List<SimpleOrderItemTo> simpleOrderItemTos;
	private BigDecimal paidAmount;
	private BigDecimal deliveryCost;
	private String comment;
	private LocalDateTime paymentTime;

	public SimpleOrderTo() {
	}

	public SimpleOrderTo(Long id, Long deliveryGroup, LocalDateTime receivedTime, LocalDateTime orderAtTime,
			String customerTable, PaymentMethod paymentMethod, OrderStatus orderStatus, boolean isCompleted,
			OrderLocationType orderLocationType, SimpleEmployeeTo driverSimpleEmployeeTo,
			SimpleEmployeeTo reveivedBySimpleEmployeeTo, SimpleAddressTo simpleAddressTo,
			SimpleCustomerTo simpleCustomerTo, SimplePartnerTo simplePartnerTo,
			List<SimpleOrderItemTo> simpleOrderItemTos, BigDecimal paidAmount, BigDecimal deliveryCost, String comment,
			LocalDateTime paymentTime) {
		super();
		this.id = id;
		this.deliveryGroup = deliveryGroup;
		this.receivedTime = receivedTime;
		this.orderAtTime = orderAtTime;
		this.customerTable = customerTable;
		this.paymentMethod = paymentMethod;
		this.orderStatus = orderStatus;
		this.isCompleted = isCompleted;
		this.orderLocationType = orderLocationType;
		this.driverSimpleEmployeeTo = driverSimpleEmployeeTo;
		this.reveivedBySimpleEmployeeTo = reveivedBySimpleEmployeeTo;
		this.simpleAddressTo = simpleAddressTo;
		this.simpleCustomerTo = simpleCustomerTo;
		this.simplePartnerTo = simplePartnerTo;
		this.simpleOrderItemTos = simpleOrderItemTos;
		this.paidAmount = paidAmount;
		this.deliveryCost = deliveryCost;
		this.comment = comment;
		this.paymentTime = paymentTime;
	}

	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BigDecimal getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(BigDecimal deliveryCost) {
		this.deliveryCost = deliveryCost;
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

	public LocalDateTime getReceivedTime() {
		return receivedTime;
	}

	public void setReceivedTime(LocalDateTime receivedTime) {
		this.receivedTime = receivedTime;
	}

	public LocalDateTime getOrderAtTime() {
		return orderAtTime;
	}

	public void setOrderAtTime(LocalDateTime orderAtTime) {
		this.orderAtTime = orderAtTime;
	}

	public String getCustomerTable() {
		return customerTable;
	}

	public void setCustomerTable(String customerTable) {
		this.customerTable = customerTable;
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

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public OrderLocationType getOrderLocationType() {
		return orderLocationType;
	}

	public void setOrderLocationType(OrderLocationType orderLocationType) {
		this.orderLocationType = orderLocationType;
	}

	public SimpleEmployeeTo getDriverSimpleEmployeeTo() {
		return driverSimpleEmployeeTo;
	}

	public void setDriverSimpleEmployeeTo(SimpleEmployeeTo driverSimpleEmployeeTo) {
		this.driverSimpleEmployeeTo = driverSimpleEmployeeTo;
	}

	public SimpleEmployeeTo getReveivedBySimpleEmployeeTo() {
		return reveivedBySimpleEmployeeTo;
	}

	public void setReveivedBySimpleEmployeeTo(SimpleEmployeeTo reveivedBySimpleEmployeeTo) {
		this.reveivedBySimpleEmployeeTo = reveivedBySimpleEmployeeTo;
	}

	public SimpleAddressTo getSimpleAddressTo() {
		return simpleAddressTo;
	}

	public void setSimpleAddressTo(SimpleAddressTo simpleAddressTo) {
		this.simpleAddressTo = simpleAddressTo;
	}

	public SimpleCustomerTo getSimpleCustomerTo() {
		return simpleCustomerTo;
	}

	public void setSimpleCustomerTo(SimpleCustomerTo simpleCustomerTo) {
		this.simpleCustomerTo = simpleCustomerTo;
	}

	public SimplePartnerTo getSimplePartnerTo() {
		return simplePartnerTo;
	}

	public void setSimplePartnerTo(SimplePartnerTo simplePartnerTo) {
		this.simplePartnerTo = simplePartnerTo;
	}

	public List<SimpleOrderItemTo> getSimpleOrderItemTos() {
		return simpleOrderItemTos;
	}

	public void setSimpleOrderItemTos(List<SimpleOrderItemTo> simpleOrderItemTos) {
		this.simpleOrderItemTos = simpleOrderItemTos;
	}

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

}
