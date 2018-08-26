package com.yc.service;

import com.yc.po.Account;

public interface BaseService {
	
	public void addAccount(Account account);
	
	public void drawMoney(Integer id,Double money);
}
