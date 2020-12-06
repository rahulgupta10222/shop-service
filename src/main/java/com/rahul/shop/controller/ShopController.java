package com.rahul.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.shop.dto.ShopDto;
import com.rahul.shop.service.ShopService;
import com.rahul.shop.util.constants.ApiConstants;
import com.rahul.shop.util.constants.Constants;

@RestController
@RequestMapping(ApiConstants.ENDPOINT_SHOP_API)
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	@PostMapping
	public ResponseEntity<ShopDto> createShop(@RequestBody final ShopDto shopDto){
		return new ResponseEntity<>(this.shopService.create(shopDto),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ShopDto>> getShops(){
		return new ResponseEntity<>(this.shopService.getShops(),HttpStatus.OK);
	}
	
	@GetMapping(ApiConstants.PATH_VARIABLE_ID)
	public ResponseEntity<ShopDto> getShopByShopId(@PathVariable(Constants.ID) final long shopId){
		return new ResponseEntity<>(this.shopService.getByShopId(shopId),HttpStatus.OK);
	}
	
	@DeleteMapping(ApiConstants.PATH_VARIABLE_ID)
	public ResponseEntity<ShopDto> deleteShop(@PathVariable(Constants.ID) final long shopId){
		return new ResponseEntity<>(this.shopService.delete(shopId),HttpStatus.OK);
	}
	
	@PutMapping(ApiConstants.PATH_VARIABLE_ID)
	public ResponseEntity<ShopDto> updateShop(@PathVariable(Constants.ID) final long shopId, @RequestBody final ShopDto shopDto){
		return new ResponseEntity<>(this.shopService.update(shopId,shopDto),HttpStatus.OK);
	}
}
