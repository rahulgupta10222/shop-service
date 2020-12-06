package com.rahul.shop.service;

import java.util.List;

import com.rahul.shop.dto.ShopDto;

public interface ShopService {

	ShopDto create(final ShopDto shopDto);
	
	List<ShopDto> getShops();
	
	ShopDto getByShopId(final long shopId);
	
	ShopDto delete(final long shopId);
	
	ShopDto update(final long shopId, final ShopDto shopDto);
	
}
