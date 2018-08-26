package com.yc.house.service;

import com.yc.house.po.Users;

public interface UserService {
	public Users findUsers(Integer id);
	public Users isLogin(String username,String password);
	public int register(Users users);
	
	/**
	 * 判断是否存在
	 * @param user
	 * @return
	 */
	public int validate(Users user);
	
	Users selectByPrimaryKey(Integer id);
	
	Users login(String username ,String password);
	
	
}
