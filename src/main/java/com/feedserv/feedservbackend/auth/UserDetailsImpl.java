package com.feedserv.feedservbackend.auth;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.EmployeeEntity;

@SuppressWarnings("serial")
public class UserDetailsImpl extends EmployeeEntity implements UserDetails {

	public UserDetailsImpl(final EmployeeEntity employeeEntity) {
		super(employeeEntity);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getEmployeeRoleEntities().stream()
				.map(employeeRole -> new SimpleGrantedAuthority("ROLE_" + employeeRole.getRoleEntity().getName()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
