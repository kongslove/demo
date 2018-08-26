package com.yc.dao;

import com.yc.po.Oprecord;

public interface OprecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Oprecord record);

    int insertSelective(Oprecord record);

    Oprecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Oprecord record);

    int updateByPrimaryKey(Oprecord record);
}