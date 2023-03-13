package com.app.tiffin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tiffin.entities.TiffinDetail;



public interface TiffinDetailDao extends JpaRepository<TiffinDetail, Integer> {

	TiffinDetail findByTiffinId(int tiffinId);

	List<TiffinDetail> findAll();

}
