package com.yc.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.house.po.House;

public interface HouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKeyWithBLOBs(House record);

    int updateByPrimaryKey(House record);
    
    
    List<House> fingAllHouse();

	House getFullHouseInfo(Integer id);
    


}