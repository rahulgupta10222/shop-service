package com.rahul.shop.mapper;

import com.rahul.shop.dto.ShopDto;
import com.rahul.shop.entity.Shop;

public class ShopMapper {
	
	public static Shop mapShopDtoToShop(final ShopDto shopDto, final Shop shop) {
		shop.setShopId(shopDto.getShopId());
		shop.setName(shopDto.getName());
		shop.setAddress(shopDto.getAddress());
		return shop;
	}
	
	public static ShopDto mapShopToShopDto(final Shop shop, final ShopDto shopDto) {
		shopDto.setShopId(shop.getShopId());
		shopDto.setName(shop.getName());
		shopDto.setAddress(shop.getAddress());
		return shopDto;
	}

}
