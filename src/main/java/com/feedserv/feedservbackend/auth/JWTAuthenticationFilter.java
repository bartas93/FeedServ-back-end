package com.feedserv.feedservbackend.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.entity.EmployeeEntity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			EmployeeEntity creds = new ObjectMapper().readValue(req.getInputStream(), EmployeeEntity.class);

			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String restaurantAddress = ((UserDetailsImpl) auth.getPrincipal()).getRestaurantEntity().getAddressEntity()
				.getStreet() + ","
				+ ((UserDetailsImpl) auth.getPrincipal()).getRestaurantEntity().getAddressEntity().getStreetNumber()
				+ "," + ((UserDetailsImpl) auth.getPrincipal()).getRestaurantEntity().getAddressEntity().getCity();

		String token = Jwts.builder().setSubject(((UserDetailsImpl) auth.getPrincipal()).getFullName())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.setHeaderParam("typ", "JWT").signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET.getBytes())
				.claim("roles", ((UserDetailsImpl) auth.getPrincipal()).getAuthorities())
				.claim("userId", ((UserDetailsImpl) auth.getPrincipal()).getId())
				.claim("imageUrl", ((UserDetailsImpl) auth.getPrincipal()).getImageUrl())
				.claim("restaurantId", ((UserDetailsImpl) auth.getPrincipal()).getRestaurantEntity().getId())
				.claim("restaurantAddress", restaurantAddress).compact();
		res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
		res.getWriter().write("{\"success\":true,\"token\":\"" + token + "\"}");
	}
}