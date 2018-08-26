package com.yc.house.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yc.house.po.House;
import com.yc.house.po.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    @Select("select * from users where username=#{username}")
    Users selectByUserName(String username);
    @Select("select * from users where username=#{username} and password = #{password}")
    Users login(@Param("username")String username ,@Param("password")String password);
    
}