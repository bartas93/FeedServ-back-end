package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.mapper;

import java.util.ArrayList;
import java.util.List;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.AddressEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.AddressTo;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.SimpleAddressTo;

public class AddressMapper {

	public static SimpleAddressTo entity2SimpleTo(AddressEntity addressEntity) {
		if (addressEntity != null) {
			return new SimpleAddressTo(addressEntity.getId(), addressEntity.getCity(), addressEntity.getStreet(),
					addressEntity.getStreetNumber(), addressEntity.getLocalNumber());
		} else {
			return null;
		}
	}

	public static List<AddressTo> entities2Tos(List<AddressEntity> addressEntities) {
		List<AddressTo> addressTos = new ArrayList<>();
		if (addressEntities != null && addressEntities.size() != 0) {
			addressEntities.forEach(addressEntity -> {
				addressTos.add(entity2To(addressEntity));
			});
		}
		return addressTos;
	}

	public static AddressTo entity2To(AddressEntity addressEntity) {
		if (addressEntity != null) {
			return new AddressTo(addressEntity.getId(), addressEntity.getCountry(), addressEntity.getCity(),
					addressEntity.getPostCode(), addressEntity.getStreet(), addressEntity.getStreetNumber(),
					addressEntity.getLocalNumber(), addressEntity.getFloor(), addressEntity.getComments());
		} else {
			return null;
		}
	}

	public static AddressEntity to2Entity(AddressTo addressTo) {
		if (addressTo != null) {
			return new AddressEntity(addressTo.getId(), addressTo.getCountry(), addressTo.getCity(),
					addressTo.getPostCode(), addressTo.getStreet(), addressTo.getStreetNumber(),
					addressTo.getLocalNumber(), addressTo.getFloor(), addressTo.getComments());
		} else {
			return null;
		}
	}
}
