package com.rahul.shop.dto;

import com.rahul.shop.entity.Address;

public class ShopDto {

	private long shopId;
	
	private String name;
	
	private Address address;

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
	
}
