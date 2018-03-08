package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.OrderLocationType;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.OrderStatus;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.PaymentMethod;

public class HistoryTableOrderTo {
	private Long orderId;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "HH:mm  dd-MM-yyyy")
	private LocalDateTime receivedTime;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "HH:mm  dd-MM-yyyy")
	private LocalDateTime paymentTime;
	private BigDecimal paidAmount;
	private PaymentMethod paymentMethod;
	private OrderStatus orderStatus;
	private OrderLocationType orderLocationType;
	private String customerPhoneNumber;
	private String partnerName;
	private int quantityOfDishes;

	public HistoryTableOrderTo() {
	}

	public HistoryTableOrderTo(Long orderId, LocalDateTime receivedTime, LocalDateTime paymentTime,
			BigDecimal paidAmount, PaymentMethod paymentMethod, OrderStatus orderStatus,
			OrderLocationType orderLocationType, String customerPhoneNumber, String partnerName, int quantityOfDishes) {
		super();
		this.orderId = orderId;
		this.receivedTime = receivedTime;
		this.paymentTime = paymentTime;
		this.paidAmount = paidAmount;
		this.paymentMethod = paymentMethod;
		this.orderStatus = orderStatus;
		this.orderLocationType = orderLocationType;
		this.customerPhoneNumber = customerPhoneNumber;
		this.partnerName = partnerName;
		this.quantityOfDishes = quantityOfDishes;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getReceivedTime() {
		return receivedTime;
	}

	public void setReceivedTime(LocalDateTime receivedTime) {
		this.receivedTime = receivedTime;
	}

	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
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

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public int getQuantityOfDishes() {
		return quantityOfDishes;
	}

	public void setQuantityOfDishes(int quantityOfDishes) {
		this.quantityOfDishes = quantityOfDishes;
	}

}
