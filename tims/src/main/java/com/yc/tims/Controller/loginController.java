package com.yc.tims.Controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.tims.dao.TimsEmpMapper;
import com.yc.tims.po.TimsEmp;
import com.yc.tims.service.TimsAdminService;
import com.yc.tims.service.TimsEmpService;

@Controller
public class loginController {

	@Autowired
	private TimsEmpService timsEmpService;
	
	@RequestMapping("/")
	public String toLogin() {
		return "redict:/login";
	}
	
	@RequestMapping("/login")
	public String login(@Param("name")String name,@Param("password")String password , HttpSession session) {
		TimsEmp emp = timsEmpService.isLogin(name, password);
		if (emp !=null) {
			session.setAttribute("loginEmp", emp);
			return "mian";
		}
		return "login";
		
	}
}
