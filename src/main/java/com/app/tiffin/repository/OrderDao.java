package com.app.tiffin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tiffin.entities.Order;


public interface OrderDao extends JpaRepository<Order, Integer> {

	Order findByOrderId(int orderId);
	
}
