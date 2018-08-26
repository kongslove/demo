package com.yc.house.service;

import java.util.List;

import com.yc.house.po.District;
import com.yc.house.po.Street;

public interface DistrictService {
	/**
	 * 查询所有街道信息
	 * @return
	 */
	List<District> findAll();

	int deleteByPrimaryKey(Integer id);

	int insert(District record);


	District selectByPrimaryKey(Integer id);


	int updateByPrimaryKey(District record);
	
	

}
