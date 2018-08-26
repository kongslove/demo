package com.yc.house.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.house.po.Users;
import com.yc.house.service.UserService;

@Controller

public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 用户登录
	 * @param username 账号
	 * @param password 密码
	 * @param session session
	 * @return
	 */
	@RequestMapping("user/User_login")
	public String login(String username,String password,HttpSession session) {
		Users users = userService.isLogin(username, password);
		if(users != null) {
			session.setAttribute("users",users);
			return "redirect:/house/list";
		}else {
			return "index";
		}
	}
	@RequestMapping("user/register")
	public String Register(@ModelAttribute("user") @Validated Users user ,BindingResult br) {
		System.out.println("user:"+user);
		if (br.hasErrors()) {
			List<ObjectError> allErrors = br.getAllErrors();
			
			for(ObjectError error :allErrors) {
				System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
			}
			return "register";
		}
		int register = userService.register(user);
		System.out.println(register);
		if (register>0) {
			return "index";
		}
		return "register";
	}
	@RequestMapping("user/exitLogin")
	public String exitLogin(HttpSession session ) {
		//清除session值
		session.invalidate();
		return "index";
	}
}
