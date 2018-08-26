package com.yc.house.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yc.house.po.House;

public interface HouseService {
	/**
	 * 根据id查询某个房子的信息
	 * @param hb
	 * @return
	 */
	public House getHouseBean(Integer id);
	
	public int addHouse(House house);
	
	public int updateHouse(House house);
	
	public int delHouse(Integer id);
	
	PageInfo fingAllHouse(Integer n,Integer size);
	
	
	public House getFullHouseInfo(Integer id);
}
