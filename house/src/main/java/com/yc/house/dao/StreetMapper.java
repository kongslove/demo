package com.yc.house.dao;

import java.util.List;

import com.yc.house.po.Street;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
    
    List<Street> findStreetByDistrictId(Integer id) ;
}