package com.yc.house.service.impl;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yc.house.dao.HouseMapper;
import com.yc.house.po.House;
import com.yc.house.service.HouseService;
@Service
@MapperScan("com.yc.house.dao")
public class HouseServiceImpl implements HouseService{
	
	@Autowired
	private HouseMapper houseMapper;
	@Override
	public House getHouseBean(Integer id) {
		House house = houseMapper.selectByPrimaryKey(id);
		return house;
	}

	@Override
	public int addHouse(House house) {
		int insertSelective = houseMapper.insertSelective(house);
		return insertSelective;
	}

	@Override
	public int updateHouse(House house) {

		return houseMapper.updateByPrimaryKeySelective(house);
	}

	@Override
	public int delHouse(Integer id) {

		return houseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageInfo fingAllHouse(Integer n,Integer size) {
		Page<Object> page = PageHelper.startPage(n, size);
		page.setOrderBy("id");
		List<House> houses = houseMapper.fingAllHouse();
		System.out.println("houses"+houses);
		PageInfo<House> pageInfo = new PageInfo<House>(houses);
		return pageInfo;
	}

	@Override
	public House getFullHouseInfo(Integer id) {
		return houseMapper.getFullHouseInfo(id);
	}

}
