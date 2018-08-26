package com.yc.house.service.impl;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.house.dao.UsersMapper;
import com.yc.house.po.Users;
import com.yc.house.service.UserService;

@Service
@MapperScan("com.yc.house.dao")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UsersMapper usersMapper;
	@Override
	public Users findUsers(Integer id) {
		Users users = usersMapper.selectByPrimaryKey(id);
		return users;
	}
	
	/**
	 * 登录操作
	 */
	@Override
	public Users isLogin(@Param("username")String username, @Param("password")String password) {
		Users users = usersMapper.login(username, password);
		if(users != null){
			if(users.getPassword().equals(password)) {
				return users;
			}
		}
		return null;
	}

	/**
	 * 注册用户
	 */
	@Override
	public int register(Users users) {
		
		return usersMapper.insert(users);
	}

	@Override
	public int validate(Users user) {
		return 0;
	}

	@Override
	public Users selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public Users login(@Param("username")String username ,@Param("password")String password) {
		
		return usersMapper.login(username, password);
	}

}
