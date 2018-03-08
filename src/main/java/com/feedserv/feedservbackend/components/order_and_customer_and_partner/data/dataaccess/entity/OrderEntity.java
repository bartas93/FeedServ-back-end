package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.OrderLocationType;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.OrderStatus;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.enums.PaymentMethod;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.EmployeeEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantEntity;

@Entity
public class OrderEntity extends AbstractEntity {

	private Long deliveryGroup;
	private String customerTable;
	private LocalDateTime orderAtTime;
	@NotNull
	private LocalDateTime receivedTime;
	private BigDecimal paidAmount;
	private BigDecimal deliveryCost;
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	@NotNull
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	private boolean isCompleted;
	@NotNull
	@Enumerated(EnumType.STRING)
	private OrderLocationType orderLocationType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "driver_employee_id")
	private EmployeeEntity driverEmployeeEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "received_by_employee_id")
	private EmployeeEntity reveivedByEmployeeEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private AddressEntity addressEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private CustomerEntity customerEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "partner_id")
	private PartnerEntity partnerEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;

	@OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
	private List<OrderItemEntity> orderItemEntities;

	private LocalDateTime paymentTime;

	private String comment;

	public OrderEntity() {
	}

	public OrderEntity(Long id) {
		super(id);
	}

	public OrderEntity(Long id, Long deliveryGroup, String customerTable, LocalDateTime orderAtTime,
			LocalDateTime receivedTime, BigDecimal paidAmount, BigDecimal deliveryCost, PaymentMethod paymentMethod,
			OrderStatus orderStatus, boolean isCompleted, OrderLocationType orderLocationType,
			EmployeeEntity driverEmployeeEntity, EmployeeEntity reveivedByEmployeeEntity, AddressEntity addressEntity,
			CustomerEntity customerEntity, PartnerEntity partnerEntity, RestaurantEntity restaurantEntity,
			List<OrderItemEntity> orderItemEntities, String comment, LocalDateTime paymentTime) {
		super(id);
		this.deliveryGroup = deliveryGroup;
		this.customerTable = customerTable;
		this.orderAtTime = orderAtTime;
		this.receivedTime = receivedTime;
		this.paidAmount = paidAmount;
		this.deliveryCost = deliveryCost;
		this.paymentMethod = paymentMethod;
		this.orderStatus = orderStatus;
		this.isCompleted = isCompleted;
		this.orderLocationType = orderLocationType;
		this.driverEmployeeEntity = driverEmployeeEntity;
		this.reveivedByEmployeeEntity = reveivedByEmployeeEntity;
		this.addressEntity = addressEntity;
		this.customerEntity = customerEntity;
		this.partnerEntity = partnerEntity;
		this.restaurantEntity = restaurantEntity;
		this.orderItemEntities = orderItemEntities;
		this.comment = comment;
		this.paymentTime = paymentTime;
	}

	public void addOrderItemEntity(OrderItemEntity orderItemEntity) {
		orderItemEntities.add(orderItemEntity);
		orderItemEntity.setOrderEntity(this);
	}

	public void removeOrderItemEntity(OrderItemEntity orderItemEntity) {
		orderItemEntities.remove(orderItemEntity);
		orderItemEntity.setOrderEntity(null);
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

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	public void addToOrderItems(OrderItemEntity orderItemEntity) {
		this.orderItemEntities.add(orderItemEntity);
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

	public EmployeeEntity getDriverEmployeeEntity() {
		return driverEmployeeEntity;
	}

	public void setDriverEmployeeEntity(EmployeeEntity driverEmployeeEntity) {
		this.driverEmployeeEntity = driverEmployeeEntity;
	}

	public EmployeeEntity getReveivedByEmployeeEntity() {
		return reveivedByEmployeeEntity;
	}

	public void setReveivedByEmployeeEntity(EmployeeEntity reveivedByEmployeeEntity) {
		this.reveivedByEmployeeEntity = reveivedByEmployeeEntity;
	}

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	public PartnerEntity getPartnerEntity() {
		return partnerEntity;
	}

	public void setPartnerEntity(PartnerEntity partnerEntity) {
		this.partnerEntity = partnerEntity;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

	public List<OrderItemEntity> getOrderItemEntities() {
		return orderItemEntities;
	}

	public void setOrderItemEntities(List<OrderItemEntity> orderItemEntities) {
		this.orderItemEntities = orderItemEntities;
	}

	public static class Builder {
		private Long deliveryGroup;
		private String customerTable;
		private LocalDateTime orderAtTime;
		private LocalDateTime receivedTime;
		private BigDecimal paidAmount;
		private PaymentMethod paymentMethod;
		private OrderStatus orderStatus;
		private boolean isCompleted;
		private OrderLocationType orderLocationType;
		private EmployeeEntity driverEmployeeEntity;
		private EmployeeEntity reveivedByEmployeeEntity;
		private AddressEntity addressEntity;
		private CustomerEntity customerEntity;
		private PartnerEntity partnerEntity;
		private RestaurantEntity restaurantEntity;
		private List<OrderItemEntity> orderItemEntities;
		private BigDecimal deliveryCost;
		private String comment;
		private LocalDateTime paymentTime;

		public Builder(Long deliveryGroup, String customerTable, LocalDateTime orderAtTime, LocalDateTime receivedTime,
				BigDecimal deliveryCost, PaymentMethod paymentMethod, OrderStatus orderStatus,
				OrderLocationType orderLocationType, String comment) {
			this.deliveryGroup = deliveryGroup;
			this.customerTable = customerTable;
			this.orderAtTime = orderAtTime;
			this.receivedTime = receivedTime;
			this.deliveryCost = deliveryCost;
			this.paymentMethod = paymentMethod;
			this.orderStatus = orderStatus;
			this.orderLocationType = orderLocationType;
			this.comment = comment;
		}

		public Builder deliveryGroup(Long deliveryGroup) {
			this.deliveryGroup = deliveryGroup;
			return this;
		}

		public Builder paymentTime(LocalDateTime paymentTime) {
			this.paymentTime = paymentTime;
			return this;
		}

		public Builder comment(String comment) {
			this.comment = comment;
			return this;
		}

		public Builder paidAmount(BigDecimal paidAmount) {
			this.paidAmount = paidAmount;
			return this;
		}

		public Builder deliveryCost(BigDecimal deliveryCost) {
			this.deliveryCost = deliveryCost;
			return this;
		}

		public Builder customerTable(String customerTable) {
			this.customerTable = customerTable;
			return this;
		}

		public Builder orderAtTime(LocalDateTime orderAtTime) {
			this.orderAtTime = orderAtTime;
			return this;
		}

		public Builder receivedTime(LocalDateTime receivedTime) {
			this.receivedTime = receivedTime;
			return this;
		}

		public Builder paymentMethod(PaymentMethod paymentMethod) {
			this.paymentMethod = paymentMethod;
			return this;
		}

		public Builder orderStatus(OrderStatus orderStatus) {
			this.orderStatus = orderStatus;
			return this;
		}

		public Builder isCompleted(boolean isCompleted) {
			this.isCompleted = isCompleted;
			return this;
		}

		public Builder orderLocationType(OrderLocationType orderLocationType) {
			this.orderLocationType = orderLocationType;
			return this;
		}

		public Builder driverEmployeeEntity(EmployeeEntity driverEmployeeEntity) {
			this.driverEmployeeEntity = driverEmployeeEntity;
			return this;
		}

		public Builder reveivedByEmployeeEntity(EmployeeEntity reveivedByEmployeeEntity) {
			this.reveivedByEmployeeEntity = reveivedByEmployeeEntity;
			return this;
		}

		public Builder addressEntity(AddressEntity addressEntity) {
			this.addressEntity = addressEntity;
			return this;
		}

		public Builder customerEntity(CustomerEntity customerEntity) {
			this.customerEntity = customerEntity;
			return this;
		}

		public Builder partnerEntity(PartnerEntity partnerEntity) {
			this.partnerEntity = partnerEntity;
			return this;
		}

		public Builder restaurantEntity(RestaurantEntity restaurantEntity) {
			this.restaurantEntity = restaurantEntity;
			return this;
		}

		public Builder orderItemEntities(List<OrderItemEntity> orderItemEntities) {
			this.orderItemEntities = orderItemEntities;
			return this;
		}

		public OrderEntity build() {
			return new OrderEntity(this);
		}
	}

	private OrderEntity(Builder builder) {
		this.deliveryGroup = builder.deliveryGroup;
		this.customerTable = builder.customerTable;
		this.orderAtTime = builder.orderAtTime;
		this.receivedTime = builder.receivedTime;
		this.paymentMethod = builder.paymentMethod;
		this.orderStatus = builder.orderStatus;
		this.isCompleted = builder.isCompleted;
		this.orderLocationType = builder.orderLocationType;
		this.driverEmployeeEntity = builder.driverEmployeeEntity;
		this.reveivedByEmployeeEntity = builder.reveivedByEmployeeEntity;
		this.addressEntity = builder.addressEntity;
		this.customerEntity = builder.customerEntity;
		this.partnerEntity = builder.partnerEntity;
		this.restaurantEntity = builder.restaurantEntity;
		this.orderItemEntities = builder.orderItemEntities;
		this.paidAmount = builder.paidAmount;
		this.deliveryCost = builder.deliveryCost;
		this.comment = builder.comment;
		this.paymentTime = builder.paymentTime;
	}
}