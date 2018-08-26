package com.yc.house.service.impl;



import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.house.dao.DistrictMapper;
import com.yc.house.po.District;

import com.yc.house.service.DistrictService;
@Service
@MapperScan("com.yc.house.dao")
public class DistrictServiceImpl implements DistrictService{

	@Autowired
	private DistrictMapper districtMapper;
	
	@Override
	public List<District> findAll() {
		
		return districtMapper.findAll();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {

		return districtMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(District record) {

		return districtMapper.insertSelective(record);
	}

	@Override
	public District selectByPrimaryKey(Integer id) {

		return districtMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(District record) {

		return districtMapper.updateByPrimaryKeySelective(record);
	}


}
