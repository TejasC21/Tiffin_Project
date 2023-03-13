package com.app.tiffin.dtos;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.app.tiffin.entities.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

	private int orderId;
	private int userId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	private int totalAmount;
	private int tiffinId;

}
