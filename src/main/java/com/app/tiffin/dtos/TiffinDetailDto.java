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
public class TiffinDetailDto {

	private int tiffinId;
	private String tiffinName;
	private double tiffinPrice;
	private String description;
	
}
