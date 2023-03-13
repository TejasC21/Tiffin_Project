package com.app.tiffin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.tiffin.dtos.DtoEntityConverter;
import com.app.tiffin.dtos.OrderDto;
import com.app.tiffin.entities.Order;
import com.app.tiffin.repository.OrderDao;

@Transactional
@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private DtoEntityConverter converter;

	public OrderDto findOrderById(int orderId) {
		Order order = orderDao.findByOrderId(orderId);
		return converter.toOrderDto(order);
	}
	public OrderDto AddOrder(OrderDto userOrderDto) {
		userOrderDto.setTiffinId(userOrderDto.getTiffinId());
		Order order=converter.userOrderToOrder(userOrderDto);
		order = orderDao.save(order);
		return converter.toOrderDto(order);
	}
}
