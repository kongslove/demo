package com.yc.house.service;

import java.util.List;

import com.yc.house.po.Street;

public interface StreetService {

	/**
	 * 根据区id查找所有的街道
	 * @param id
	 * @return
	 */
	List<Street> findStreetByDistrictId(Integer id);


	int deleteByPrimaryKey(Integer id);

	int insert(Street record);


	Street selectByPrimaryKey(Integer id);


	int updateByPrimaryKey(Street record);
}
