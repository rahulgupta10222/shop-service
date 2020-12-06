package com.rahul.shop.service.impl;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.shop.dto.ShopDto;
import com.rahul.shop.entity.Address;
import com.rahul.shop.entity.Shop;
import com.rahul.shop.mapper.ShopMapper;
import com.rahul.shop.repository.AddressRepository;
import com.rahul.shop.repository.ShopRepository;
import com.rahul.shop.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public ShopDto create(ShopDto shopDto) {
		final Address address = this.addressRepository.save(shopDto.getAddress());
		shopDto.setAddress(address);
		final Shop shop = this.shopRepository.save(ShopMapper.mapShopDtoToShop(shopDto, new Shop()));
		return ShopMapper.mapShopToShopDto(shop,shopDto);
	}

	@Override
	public ShopDto getByShopId(long shopId) {
		final Optional<Shop> shopOptional = this.shopRepository.findByShopIdAndDeletedFalse(shopId);
		if(!shopOptional.isPresent())
			throw new InvalidParameterException("ShopId not present");
		return ShopMapper.mapShopToShopDto(shopOptional.get(), new ShopDto());
	}

	@Override
	public ShopDto delete(long shopId) {
		final Optional<Shop> shopOptional = this.shopRepository.findByShopIdAndDeletedFalse(shopId);
		if(shopOptional.isEmpty())
			throw new InvalidParameterException("ShopId not found");
		final Shop shop = shopOptional.get();
		shop.setDeleted(true);
		this.shopRepository.save(shop);
		return ShopMapper.mapShopToShopDto(shop,new ShopDto());
	}

	@Override
	public List<ShopDto> getShops() {
		final List<Shop> shops = this.shopRepository.findByDeletedFalse();
		return shops.stream().map(shop -> ShopMapper.mapShopToShopDto(shop, new ShopDto())).collect(Collectors.toList());
	}
	
	@Override
	public ShopDto update(final long shopId, final ShopDto shopDto) {
		Optional<Shop> shopOptional = this.shopRepository.findByShopIdAndDeletedFalse(shopId);
		if(shopOptional.isEmpty())
			throw new InvalidParameterException("ShopId not found.");
		final Address previousAddress = shopOptional.get().getAddress();
		final Shop shop = ShopMapper.mapShopDtoToShop(shopDto, shopOptional.get());
		if(!shopDto.getAddress().equals(previousAddress)) {
			final Address newAddress = this.addressRepository.save(shopDto.getAddress());
			shop.setAddress(newAddress);
		}
		else {
			shop.setAddress(previousAddress);
		}
		return ShopMapper.mapShopToShopDto(this.shopRepository.save(shop),shopDto);
	}

}
