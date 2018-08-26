package com.yc.house.service;

import java.util.List;

import com.yc.house.po.HouseType;

public interface HouseTypeService {
	List<HouseType> findAllType(); 
	int deleteByPrimaryKey(Integer id);

    int insert(HouseType record);

  

    HouseType selectByPrimaryKey(Integer id);

   

    int updateByPrimaryKey(HouseType record);
}
