package com.app.tiffin.dtos;

import org.springframework.stereotype.Component;

import com.app.tiffin.entities.DeliveryAddress;
import com.app.tiffin.entities.Order;
import com.app.tiffin.entities.TiffinDetail;
import com.app.tiffin.entities.User;
import com.app.tiffin.entities.UserAddress;

import org.springframework.beans.BeanUtils;
@Component
public class DtoEntityConverter {

	public UserDto toUserDto(User entity) {
		UserDto dto = new UserDto();
		dto.setUserId(entity.getUserId());
		dto.setUserName(entity.getUserName());
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		dto.setAadharNo(entity.getAadharNo());
		dto.setPhone(entity.getPhone());
		dto.setRole(entity.getRole());
		return dto;
	}

	public OrderDto toOrderDto(Order entity) {
		OrderDto dto = new OrderDto();
		dto.setOrderId(entity.getOrderId());
		dto.setUserId(entity.getUser().getUserId());
		dto.setOrderDate(entity.getOrderDate());
		dto.setTotalAmount(entity.getTotalAmount());
		dto.setTiffinId(entity.getTiffinDetails().getTiffinId());
		return dto;
	}

	public TiffinDetailDto toTiffinDetailDto(TiffinDetail entity) {
		TiffinDetailDto dto = new TiffinDetailDto();
		dto.setTiffinId(entity.getTiffinId());
		dto.setTiffinName(entity.getTiffinName());
		dto.setTiffinPrice(entity.getTiffinPrice());
		dto.setDescription(entity.getDescription());
		return dto;
	}

	public Order userOrderToOrder(OrderDto orderdto) {
		Order order=new Order();
		order.setOrderDate(orderdto.getOrderDate());
		order.setTotalAmount(orderdto.getTotalAmount());
		//order.setOrderId(userdto.getOrder_id());
		order.setUser(new User(orderdto.getUserId()));
		order.setTiffinDetails(new TiffinDetail(orderdto.getTiffinId()));
		//order.setTiffinDetails(new TiffinDetail());
		return order;
	}

	public User UserDtotoUser(UserDto userdto) {
		User user=new User();
		user.setAadharNo(userdto.getAadharNo());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setPhone(userdto.getPhone());
		user.setRole(userdto.getRole());
		user.setUserName(userdto.getUserName());
		return user;
	}
	public UserAddressDto toUserAddressDto(UserAddress entity) {
		UserAddressDto dto = new UserAddressDto();
		dto.setAddressId(entity.getAddressId());
		dto.setAddressLine(entity.getAddressLine());
		dto.setLocationId(entity.getDeliveryAddress().getLocationId());
		dto.setUserId(entity.getUserId());
		return dto;
	}

	public DeliveryAddressDto toDeliveryAddressDto(DeliveryAddress entity) {
		DeliveryAddressDto dto = new DeliveryAddressDto();
		dto.setLocationId(entity.getLocationId());
		dto.setDeliveryArea(entity.getDeliveryArea());
		dto.setCity(entity.getCity());
		dto.setPinCode(entity.getPinCode());
		return dto;
	}
	public UserAddress toUserAddress(UserAddressDto dto) {
		UserAddress entity = new UserAddress();
		entity.setAddressId(dto.getAddressId());
		entity.setAddressLine(dto.getAddressLine());

		DeliveryAddress del = new DeliveryAddress();
		del.setLocationId(dto.getLocationId());
		entity.setDeliveryAddress(del);

		entity.setUserId(dto.getUserId());
		return entity;
	}
	public DeliveryAddress toDeliveryAddress(DeliveryAddressDto dto) {
		DeliveryAddress entity = new DeliveryAddress();
		entity.setLocationId(dto.getLocationId());
		entity.setDeliveryArea(dto.getDeliveryArea());
		entity.setCity(dto.getCity());
		entity.setPinCode(dto.getPinCode());
		return entity;
	}
	public User toUser(UserDto dto) {
		User user = new User();
		user.setUserId(dto.getUserId());
		user.setUserName(dto.getUserName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setAadharNo(dto.getAadharNo());
		user.setPhone(dto.getPhone());
		user.setRole(dto.getRole());
		return user;
	}

	public TiffinDetail toTiifinDetail(TiffinDetailDto dto) {
		TiffinDetail entity = new TiffinDetail();
		entity.setTiffinId(dto.getTiffinId());
		entity.setTiffinName(dto.getTiffinName());
		entity.setTiffinPrice(dto.getTiffinPrice());
		entity.setDescription(dto.getDescription());
		return entity;
	}
	public TiffinDetail albumFormDtoToEntity(TiffinFormDto tiffinDto) {
		TiffinDetail tiffin = new TiffinDetail();
		BeanUtils.copyProperties(tiffinDto, tiffin, "tiffin");
		tiffin.setTiffinPrice(tiffinDto.getTiffinPrice());
		return tiffin;
	}
}
