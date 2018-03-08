package com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.feedserv.feedservbackend.abstracts.AbstractEntity;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity.ChangeableProductEntity;
import com.feedserv.feedservbackend.components.inventory_and_menu.data.dataaccess.entity.GroupOfChangeableProductsEntity;

@Entity
public class ChangesInOrderItemEntity extends AbstractEntity {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "group_of_changeable_products_id")
	private GroupOfChangeableProductsEntity groupOfChangableProductsEntity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_item_id")
	private OrderItemEntity orderItemEntity;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "added_products", joinColumns = {
			@JoinColumn(name = "changes_in_order_item_id") }, inverseJoinColumns = {
					@JoinColumn(name = "changeable_product_id") })
	private List<ChangeableProductEntity> addedProducts;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "removed_products", joinColumns = {
			@JoinColumn(name = "changes_in_order_item_id") }, inverseJoinColumns = {
					@JoinColumn(name = "changeable_product_id") })
	private List<ChangeableProductEntity> removedProducts;

	public ChangesInOrderItemEntity() {
	}

	public ChangesInOrderItemEntity(Long id) {
		super(id);
	}

	public ChangesInOrderItemEntity(Long id, GroupOfChangeableProductsEntity groupOfChangableProductsEntity,
			OrderItemEntity orderItemEntity, List<ChangeableProductEntity> addedProducts,
			List<ChangeableProductEntity> removedProducts) {
		super(id);
		this.groupOfChangableProductsEntity = groupOfChangableProductsEntity;
		this.orderItemEntity = orderItemEntity;
		this.addedProducts = addedProducts;
		this.removedProducts = removedProducts;
	}

	public void addChangeableProductEntityToAddedProducts(ChangeableProductEntity changeableProductEntity) {
		addedProducts.add(changeableProductEntity);
	}

	public void removeChangeableProductEntityFromAddedProducts(ChangeableProductEntity changeableProductEntity) {
		addedProducts.remove(changeableProductEntity);
	}

	public void addChangeableProductEntityToRemovedProducts(ChangeableProductEntity changeableProductEntity) {
		removedProducts.add(changeableProductEntity);
	}

	public void removeChangeableProductEntityFromRemovedProducts(ChangeableProductEntity changeableProductEntity) {
		removedProducts.remove(changeableProductEntity);
	}

	public GroupOfChangeableProductsEntity getGroupOfChangableProductsEntity() {
		return groupOfChangableProductsEntity;
	}

	public void setGroupOfChangableProductsEntity(GroupOfChangeableProductsEntity groupOfChangableProductsEntity) {
		this.groupOfChangableProductsEntity = groupOfChangableProductsEntity;
	}

	public OrderItemEntity getOrderItemEntity() {
		return orderItemEntity;
	}

	public void setOrderItemEntity(OrderItemEntity orderItemEntity) {
		this.orderItemEntity = orderItemEntity;
	}

	public List<ChangeableProductEntity> getAddedProducts() {
		return addedProducts;
	}

	public void setAddedProducts(List<ChangeableProductEntity> addedProducts) {
		this.addedProducts = addedProducts;
	}

	public List<ChangeableProductEntity> getRemovedProducts() {
		return removedProducts;
	}

	public void setRemovedProducts(List<ChangeableProductEntity> removedProducts) {
		this.removedProducts = removedProducts;
	}

}
