package com.yc.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.house.po.District;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
    
    @Select("select * from district")
    List<District> findAll();
}