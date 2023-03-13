package com.app.tiffin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tiffin.entities.UserAddress;


public interface UserAddressDao extends JpaRepository<UserAddress, Integer> {
	
	UserAddress findByAddressId(int addressId);
	UserAddress findByUserId(int userId);
}
