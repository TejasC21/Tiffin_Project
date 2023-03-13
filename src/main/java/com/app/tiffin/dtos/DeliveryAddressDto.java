package com.app.tiffin.dtos;

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
public class DeliveryAddressDto {

	private int locationId;
	private String deliveryArea;
	private String city;
	private int pinCode;
	
}
