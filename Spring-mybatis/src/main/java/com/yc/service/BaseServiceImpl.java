package com.yc.service;


import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.AccountMapper;
import com.yc.dao.OprecordMapper;
import com.yc.po.Account;
import com.yc.po.Oprecord;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class BaseServiceImpl implements BaseService{
	
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private OprecordMapper oprecordMapper;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	public void addAccount(Account account) {
		accountMapper.insert(account);
	}

	/**
	 * 取钱过程就是一个事务
	 * 编程式事务管理：
	 * 硬编码
	 
	public void drawMoney(Integer id,Double money) {
		//定义一个事务对象
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		//隔离级别
		def.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
		//事务传播机制
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		//设置事务是否只读
		def.setReadOnly(false);
		//设置事务的超时时间
		def.setTimeout(25);
		//获取一个事务状态类,Spring根据隔离级别和传播行为来决定如何管理事务
		TransactionStatus status = transactionManager.getTransaction(def);
		//查询
		Account account = accountMapper.selectByPrimaryKey(id);
		try {
			//更新账目
			account.setBalance(account.getBalance()-money);
			accountMapper.updateByPrimaryKey(account);
			
			if(account.getBalance()<money) {
				throw new RuntimeException("error:账户资金不足!");
			}
			//记录流水 
			Oprecord oprecord = new Oprecord();
			oprecord.setAccountid(id);
			oprecord.setOpmoney(money);
			oprecord.setOptime(new Date());
			oprecordMapper.insert(oprecord);
			//提交事务
			transactionManager.commit(status);
		} catch (Exception e) {
			//回滚事务
			transactionManager.rollback(status);
			e.printStackTrace();
		}
	}*/
	
	@Transactional(readOnly=false,timeout=25,noRollbackFor= {NumberFormatException.class})
	public void drawMoney(Integer id,Double money) {
		//查询
		Account account = accountMapper.selectByPrimaryKey(id);
		//更新账目
		account.setBalance(account.getBalance()-money);
		accountMapper.updateByPrimaryKey(account);
		
		if(account.getBalance()<money) {
			throw new RuntimeException("error:账户资金不足!");
		}
		//记录流水 
		Oprecord oprecord = new Oprecord();
		oprecord.setAccountid(id);
		oprecord.setOpmoney(money);
		oprecord.setOptime(new Date());
		oprecordMapper.insert(oprecord);
		Integer i = Integer.valueOf("abc");
	}


}
