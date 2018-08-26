package com.yc.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.house.po.HouseType;

public interface HouseTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseType record);

    int insertSelective(HouseType record);

    HouseType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseType record);

    int updateByPrimaryKey(HouseType record);
    @Select("select * from housetype")
    List<HouseType> findAllType();
}