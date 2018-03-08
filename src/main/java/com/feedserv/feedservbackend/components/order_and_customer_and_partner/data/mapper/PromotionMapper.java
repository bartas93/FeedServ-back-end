package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.mapper;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.PromotionEntity;
import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.to.SimplePromotionTo;

public class PromotionMapper {

	public static SimplePromotionTo entity2SimpleTo(PromotionEntity promotionEntity) {
		if (promotionEntity != null) {
			return new SimplePromotionTo(promotionEntity.getId(), promotionEntity.getPromotionType(),
					promotionEntity.getRate(), promotionEntity.getStartDate(), promotionEntity.getEndDate());
		} else {
			return null;
		}
	}
}
