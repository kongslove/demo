package com.yc.house.service.impl;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.house.dao.HouseTypeMapper;
import com.yc.house.po.HouseType;
import com.yc.house.service.HouseTypeService;
@Service
@MapperScan("com.yc.house.dao")
public class HouseTypeServiceImpl implements HouseTypeService{

	@Autowired
	private HouseTypeMapper houseTypeMapper;
	
	
	@Override
	public List<HouseType> findAllType() {
		
		return houseTypeMapper.findAllType();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {

		return houseTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(HouseType record) {

		return houseTypeMapper.insertSelective(record);
	}

	

	@Override
	public HouseType selectByPrimaryKey(Integer id) {

		return houseTypeMapper.selectByPrimaryKey(id);
	}


	@Override
	public int updateByPrimaryKey(HouseType record) {

		return houseTypeMapper.updateByPrimaryKeySelective(record);
	}
	
}
