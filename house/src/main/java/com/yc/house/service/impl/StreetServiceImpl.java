package com.yc.house.service.impl;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.house.dao.StreetMapper;
import com.yc.house.po.Street;
import com.yc.house.service.StreetService;
@Service
@MapperScan("com.yc.house.dao")
public class StreetServiceImpl implements StreetService{
	@Autowired
	private StreetMapper streetMapper;

	@Override
	public List<Street> findStreetByDistrictId(Integer id) {

		return streetMapper.findStreetByDistrictId(id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {

		return streetMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Street record) {

		return streetMapper.insertSelective(record);
	}

	@Override
	public Street selectByPrimaryKey(Integer id) {

		return streetMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Street record) {

		return streetMapper.updateByPrimaryKeySelective(record);
	}

}
