package com.rahul.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.shop.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

	Optional<Shop> findByShopIdAndDeletedFalse(final long shopId);
	
	Shop deleteByShopId(final long shopId);
	
	List<Shop> findByDeletedFalse();
}
