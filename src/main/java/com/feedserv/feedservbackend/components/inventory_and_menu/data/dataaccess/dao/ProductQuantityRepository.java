package com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity.ProductQuantityEntity;

public interface ProductQuantityRepository extends JpaRepository<ProductQuantityEntity, Long> {

}
