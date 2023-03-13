package com.app.tiffin.dtos;

//import org.springframework.beans.BeanUtils;

import com.app.tiffin.entities.TiffinDetail;

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
public class TiffinFormDto 
{
	private int tiffinId;
	private String tiffinName;
	private double tiffinPrice;
	private String description;
	
//	public static TiffinDetail toEntity(TiffinFormDto dto) {
//		TiffinDetail entity=new TiffinDetail();
//		BeanUtils.copyProperties(dto, entity, "imageName");
//		return entity;
//	}
}
