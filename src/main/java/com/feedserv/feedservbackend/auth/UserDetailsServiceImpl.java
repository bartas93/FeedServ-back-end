package com.feedserv.feedservbackend.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.dao.EmployeeRepository;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.EmployeeEntity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<EmployeeEntity> emOptional = employeeRepository.findByEmail(email);
		emOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return emOptional.map(UserDetailsImpl::new).get();
	}

}
