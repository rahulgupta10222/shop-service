package com.rahul.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Shop {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique = true)
	private long shopId;
	
	private String name;
	
	@OneToOne
	private Address address;
	
	private boolean deleted = false;
	

	public long getId() {
		return id;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long tenantId) {
		this.shopId = tenantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	

}
