package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
