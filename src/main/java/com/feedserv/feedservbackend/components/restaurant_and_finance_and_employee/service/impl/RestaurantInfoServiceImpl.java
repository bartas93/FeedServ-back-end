package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.dao.RestaurantInfoRepository;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RestaurantInfoEntity;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.mapper.RestaurantInfoMapper;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to.RestaurantInfoTo;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.service.RestaurantInfoService;

@Service
public class RestaurantInfoServiceImpl implements RestaurantInfoService {

	@Autowired
	private RestaurantInfoRepository restaurantInfoRepository;

	@Override
	public RestaurantInfoTo saveRestaurantInfo(RestaurantInfoTo restaurantInfoTo) {
		RestaurantInfoEntity rInfoEntity = RestaurantInfoMapper.to2Entity(restaurantInfoTo);
		RestaurantInfoEntity savedRInfoEntity = restaurantInfoRepository.save(rInfoEntity);
		return RestaurantInfoMapper.entity2To(savedRInfoEntity);
	}

	@Override
	public RestaurantInfoTo findById(Long id) {
		RestaurantInfoEntity re = restaurantInfoRepository.findOne(id);
		return RestaurantInfoMapper.entity2To(re);
	}

}
