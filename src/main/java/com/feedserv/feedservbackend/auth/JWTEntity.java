package com.feedserv.feedservbackend.auth;

import java.util.List;
import java.util.Map;

public class JWTEntity {

	private String sub;
	private Integer exp;
	private List<Role> roles;
	private Long userId;
	private String imageUrl;
	private Long restaurantId;
	private String restaurantAddress;
	private Map<String, Object> additionalProperties;

	public JWTEntity() {
	}

	public JWTEntity(String sub, Integer exp, List<Role> roles, Long userId, String imageUrl, Long restaurantId,
			Map<String, Object> additionalProperties, String restaurantAddress) {
		super();
		this.sub = sub;
		this.exp = exp;
		this.roles = roles;
		this.userId = userId;
		this.imageUrl = imageUrl;
		this.restaurantId = restaurantId;
		this.additionalProperties = additionalProperties;
		this.restaurantAddress = restaurantAddress;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

}

class Role {
	private String authority;
	private Map<String, Object> additionalProperties;

	public Role() {
	}

	public Role(String authority, Map<String, Object> additionalProperties) {
		super();
		this.authority = authority;
		this.additionalProperties = additionalProperties;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

}