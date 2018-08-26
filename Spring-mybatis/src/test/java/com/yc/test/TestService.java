package com.yc.test;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.dao.AccountMapper;
import com.yc.po.Account;
import com.yc.service.BaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestService {
	
	@Autowired
	private BaseService baseService;
	
	@Autowired
	private BasicDataSource dataSource;
	
	@Autowired
	private SqlSessionFactoryBean factory;
	
	@Test
	public void test1() throws Exception {
		System.out.println(baseService);
		System.out.println(dataSource);
		System.out.println(factory);
		SqlSessionFactory object = factory.getObject();
		SqlSession session = object.openSession();
		AccountMapper mapper = session.getMapper(AccountMapper.class);
		Account account = new Account();
		account.setBalance(100000.0);
		mapper.insert(account);
	}
	
	@Test
	public void test2() {
		Account account = new Account();
		account.setBalance(100000.0);
		baseService.addAccount(account);
	}
	
	@Test
	public void test3() {
		baseService.drawMoney(1, 3000.0);
	}
}
