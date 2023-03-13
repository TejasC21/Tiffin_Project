package com.app.tiffin.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.tiffin.dtos.DtoEntityConverter;
import com.app.tiffin.dtos.TiffinDetailDto;
import com.app.tiffin.entities.TiffinDetail;
import com.app.tiffin.repository.TiffinDetailDao;



@Transactional
@Service
public class TiffinDetailService {
	@Autowired
	private TiffinDetailDao tiffinDetailDao;
	@Autowired
	private DtoEntityConverter converter;

	public TiffinDetailDto findTiffinById(int tiffinId) {
		TiffinDetail tiffinDetail = tiffinDetailDao.findByTiffinId(tiffinId);
		return converter.toTiffinDetailDto(tiffinDetail);
	}
	
	public List<TiffinDetailDto> findAllTiffins()
	{
		List<TiffinDetail> list = tiffinDetailDao.findAll();
		List<TiffinDetailDto> dtoList = new ArrayList<TiffinDetailDto>();
		for(TiffinDetail t : list) {
			dtoList.add(converter.toTiffinDetailDto(t));
		}
		return dtoList;
	}

	public TiffinDetail saveTiffin(TiffinDetailDto details) {
		return tiffinDetailDao.save(converter.toTiifinDetail(details));
	}

	public int deleteTiffinById(int tiffinId)
	{
		if(tiffinDetailDao.existsById(tiffinId)) {
			tiffinDetailDao.deleteById(tiffinId);
			return 1;
		}
		return 0;
	}
	public TiffinDetail saveTiffinDetails(TiffinDetail details) {
		return tiffinDetailDao.save(details);
	}
}
