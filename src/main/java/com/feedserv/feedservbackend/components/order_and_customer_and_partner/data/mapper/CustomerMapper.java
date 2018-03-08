package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.dao.CustomerRepository;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.AddressEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.CustomerEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.OrderEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.CustomerTableTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.CustomerWithoutOrdersTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.SimpleCustomerTo;

@Component
public class CustomerMapper {

	@Autowired
	private CustomerRepository customerRepository;
	private static CustomerRepository staticCustomerRepository;

	@SuppressWarnings("static-access")
	@PostConstruct
	public void init() {
		this.staticCustomerRepository = customerRepository;
	}

	public static SimpleCustomerTo entity2SimpleTo(CustomerEntity customerEntity) {
		if (customerEntity != null) {
			return new SimpleCustomerTo(customerEntity.getId(), customerEntity.getPhoneNumber(),
					customerEntity.getName());
		} else {
			return null;
		}
	}

	public static List<CustomerWithoutOrdersTo> entities2WithoutOrdersTos(List<CustomerEntity> customerEntities) {
		List<CustomerWithoutOrdersTo> customerWithoutOrdersTos = new ArrayList<>();
		if (customerEntities != null && customerEntities.size() != 0) {
			customerEntities.forEach(customerEntity -> {
				customerWithoutOrdersTos.add(entity2WithoutOrdersTo(customerEntity));
			});
		}
		return customerWithoutOrdersTos;
	}

	public static CustomerWithoutOrdersTo entity2WithoutOrdersTo(CustomerEntity customerEntity) {
		if (customerEntity != null) {
			return new CustomerWithoutOrdersTo(customerEntity.getId(), customerEntity.getPhoneNumber(),
					customerEntity.getName(), customerEntity.getEmail(), customerEntity.getDescription(),
					customerEntity.isOnBlackList(), AddressMapper.entities2Tos(customerEntity.getAddressEntities()));
		} else {
			return null;
		}
	}

	public static CustomerEntity withoutOrdersTo2Entity(CustomerWithoutOrdersTo customerWithoutOrdersTo) {
		if (customerWithoutOrdersTo != null) {
			CustomerEntity dbCustomerEntity = staticCustomerRepository
					.findByPhoneNumber(customerWithoutOrdersTo.getPhoneNumber());
			if (dbCustomerEntity != null) {
				return combineItTogether(customerWithoutOrdersTo, dbCustomerEntity);
			} else {
				return mapWhenNotExist(customerWithoutOrdersTo);
			}
		} else {
			return null;
		}
	}

	private static CustomerEntity mapWhenNotExist(CustomerWithoutOrdersTo customerWithoutOrdersTo) {
		CustomerEntity customerEntity = new CustomerEntity(customerWithoutOrdersTo.getId(),
				customerWithoutOrdersTo.getPhoneNumber(), customerWithoutOrdersTo.getName(),
				customerWithoutOrdersTo.getEmail(), customerWithoutOrdersTo.getDescription(),
				customerWithoutOrdersTo.getIsOnBlackList(), null);
		customerEntity.setAddressEntities(new ArrayList<>());
		if (customerWithoutOrdersTo.getAddressTos() != null && customerWithoutOrdersTo.getAddressTos().size() > 0) {
			customerWithoutOrdersTo.getAddressTos().forEach(addressTo -> {
				customerEntity.addAddressEntity(AddressMapper.to2Entity(addressTo));
			});
		}
		return customerEntity;
	}

	private static CustomerEntity combineItTogether(CustomerWithoutOrdersTo customerWithoutOrdersTo,
			CustomerEntity dbCustomerEntity) {
		if (customerWithoutOrdersTo.getName() != null)
			dbCustomerEntity.setName(customerWithoutOrdersTo.getName());
		if (customerWithoutOrdersTo.getDescription() != null)
			dbCustomerEntity.setDescription(customerWithoutOrdersTo.getDescription());
		if (customerWithoutOrdersTo.getIsOnBlackList() != null)
			dbCustomerEntity.setOnBlackList(customerWithoutOrdersTo.getIsOnBlackList());
		if (customerWithoutOrdersTo.getEmail() != null)
			dbCustomerEntity.setEmail(customerWithoutOrdersTo.getEmail());
		if (customerWithoutOrdersTo.getEmail() != null)
			dbCustomerEntity.setEmail(customerWithoutOrdersTo.getEmail());
		if (customerWithoutOrdersTo.getAddressTos() != null && customerWithoutOrdersTo.getAddressTos().size() > 0) {
			customerWithoutOrdersTo.getAddressTos().forEach(addressTo -> {
				AddressEntity ae = AddressMapper.to2Entity(addressTo);
				if (!dbCustomerEntity.getAddressEntities().contains(ae)) {
					dbCustomerEntity.addAddressEntity(ae);
				}
			});
		}
		return dbCustomerEntity;
	}

	public static List<CustomerTableTo> entities2TableTo(List<CustomerEntity> customerEntities) {
		List<CustomerTableTo> customerTableTos = new ArrayList<>();
		if (customerEntities != null && customerEntities.size() > 0) {
			customerEntities.forEach(customerEntity -> {
				customerTableTos.add(entity2TableTo(customerEntity));
			});
		}
		return customerTableTos;
	}

	public static CustomerTableTo entity2TableTo(CustomerEntity customerEntity) {
		if (customerEntity != null) {
			return new CustomerTableTo(customerEntity.getId(), customerEntity.getPhoneNumber(),
					customerEntity.getName(), customerEntity.getEmail(), customerEntity.isOnBlackList(),
					getTotalPaidMoney(customerEntity), getQuantityOfOrders(customerEntity),
					mergeAddressesToOneString(customerEntity));
		}
		return null;
	}

	private static int getQuantityOfOrders(CustomerEntity customerEntity) {
		if (customerEntity.getOrderEntities() != null) {
			return customerEntity.getOrderEntities().size();
		}
		return 0;
	}

	private static BigDecimal getTotalPaidMoney(CustomerEntity customerEntity) {
		List<OrderEntity> ordersWithPaidAmount = customerEntity.getOrderEntities().stream()
				.filter(o -> o.getPaidAmount() != null).collect(Collectors.toList());
		BigDecimal totalPaidMoney;
		if (ordersWithPaidAmount != null && ordersWithPaidAmount.size() > 0) {
			totalPaidMoney = ordersWithPaidAmount.stream().map(OrderEntity::getPaidAmount).reduce(BigDecimal::add)
					.get();
		} else {
			totalPaidMoney = new BigDecimal(0);
		}
		return totalPaidMoney;
	}

	private static String mergeAddressesToOneString(CustomerEntity customerEntity) {
		StringBuilder addresses = new StringBuilder("");
		if (customerEntity.getAddressEntities() != null && customerEntity.getAddressEntities().size() > 0) {
			customerEntity.getAddressEntities().forEach(address -> {
				if (addresses.length() > 0) {
					addresses.append(" | ");
				}
				addresses.append(address.getStreet() + " " + address.getStreetNumber());
				if (address.getLocalNumber() != null) {
					addresses.append("/" + address.getLocalNumber());
				}
			});
		}
		return addresses.toString();
	}

}
