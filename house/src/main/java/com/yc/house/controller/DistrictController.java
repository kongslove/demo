package com.yc.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.yc.house.po.Street;
import com.yc.house.service.DistrictService;
import com.yc.house.service.StreetService;

@Controller
public class DistrictController {

	@Autowired
	private StreetService streetService;
	
	@RequestMapping("page/findStreet_DistrictId")
	@ResponseBody
	public String findStreet(Integer id) {
		List<Street> streets = streetService.findStreetByDistrictId(id);
		return JSONObject.toJSONString(streets);
		
	}
}
