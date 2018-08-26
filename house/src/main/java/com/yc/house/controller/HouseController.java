package com.yc.house.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.yc.house.dao.HouseMapper;
import com.yc.house.po.House;
import com.yc.house.po.Users;
import com.yc.house.service.HouseService;

@Controller
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	@RequestMapping("house/list")
	public String findByPage(@RequestParam(value="n",defaultValue="1")Integer n,@RequestParam(value="size",defaultValue="3") Integer size ,Map map) {
		
		PageInfo pageInfo = houseService.fingAllHouse(n, size);
		System.out.println(pageInfo.getList());
		map.put("pageInfo", pageInfo);
		return "list";
	}
	
	@RequestMapping("page/House_add")
	public String  addHouse(@ModelAttribute("house") @Validated House house ,BindingResult br ,HttpSession session) {
		System.out.println("house："+house);
		Users user = (Users)session.getAttribute("users");
		house.setUserId(user.getId());
		if (br.hasErrors()) {
			List<ObjectError> allErrors = br.getAllErrors();
			
			for(ObjectError error :allErrors) {
				System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
			}
			return "redirect:/page/add";
		}
		
		int addHouse = houseService.addHouse(house);
		if (addHouse >0) {
			System.out.println("");
			return "redirect:/house/list";
		}
		return "add";
		
	}
	
	@RequestMapping("page/House_update")
	public String  updateHouse(@ModelAttribute("house") @Validated House house ,BindingResult br ,HttpSession session) {
		System.out.println("house："+house);
		House houses=(House) session.getAttribute("updateHouse");
		house.setId(houses.getId());
		if (br.hasErrors()) {
			List<ObjectError> allErrors = br.getAllErrors();
			
			for(ObjectError error :allErrors) {
				System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
			}
			return "redirect:/page/update";
		}
		
		int addHouse = houseService.updateHouse(house);
		System.out.println(addHouse);
		if (addHouse >0) {
			
			return "redirect:/house/list";
		}
		return "redirect:/page/update";
		
	}
	
	@RequestMapping("page/HouseBean_del")
	public String delHouse(Integer id) {
		int delHouse = houseService.delHouse(id);
		if(delHouse>0) {
			return "redirect:/house/list";
		}
		return "redirect:/house/list";
	}
	
	
}
