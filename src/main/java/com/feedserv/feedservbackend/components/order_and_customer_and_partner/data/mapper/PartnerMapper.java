package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.mapper;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.PartnerEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.SimplePartnerTo;

public class PartnerMapper {

	public static SimplePartnerTo entity2SimpleTo(PartnerEntity partnerEntity) {
		if (partnerEntity != null) {
			return new SimplePartnerTo(partnerEntity.getName());
		} else {
			return new SimplePartnerTo();
		}
	}
}
