package com.yc.house.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yc.house.po.District;
import com.yc.house.po.House;
import com.yc.house.po.HouseType;
import com.yc.house.po.Users;
import com.yc.house.service.DistrictService;
import com.yc.house.service.HouseService;
import com.yc.house.service.HouseTypeService;

/**
 * 处理无页面的跳转controller
 * @author Administrator
 *
 */
@Controller

public class pageController {
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private HouseTypeService houseTypeService;
	
	@Autowired
	private DistrictService districtService;
	/**
	 * 跳转到注册页面时，需要准备数据在页面中显示
	 * @return
	 */
	@RequestMapping("page/register")
	public String toRegister(@ModelAttribute("user") Users user) {
		return "register";
	}
	
	@RequestMapping("page/add")
	public ModelAndView toAdd(@ModelAttribute("house") House house) {
		
		List<HouseType> houseTypes = houseTypeService.findAllType();
		List<District> districts = districtService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("houseTypes",houseTypes);
		mav.addObject("districts",districts);
		mav.setViewName("add");
		return mav;
	}
	
	@RequestMapping("page/update")
	public ModelAndView toUpdate(@ModelAttribute("house")House house, @Param("id")Integer id ,HttpSession session) {
		House houseBean = houseService.getHouseBean(id);
		System.out.println("houseBean"+houseBean);
		session.setAttribute("updateHouse", houseBean);
		house=houseBean;
		System.out.println("house->"+house);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("update");
		List<HouseType> houseTypes = houseTypeService.findAllType();
		List<District> districts = districtService.findAll();
		mav.addObject("houseTypes",houseTypes);
		mav.addObject("districts",districts);
		mav.addObject("house",house);
		return mav;
	}
	
	@RequestMapping("page/show")
	public ModelAndView show(Integer id ) {
		House houseBean = houseService.getFullHouseInfo(id);
		System.out.println("houseBean"+houseBean);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("show");
		mav.addObject("house",houseBean);
		return mav;
	}
}
