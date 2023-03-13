package com.app.tiffin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tiffin.entities.DeliveryAddress;


public interface DeliveryAddressDao extends JpaRepository<DeliveryAddress, Integer> {

	DeliveryAddress findByLocationId(int locationId);
}
