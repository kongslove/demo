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
	 * ȡǮ���̾���һ������
	 * ���ʽ�������
	 * Ӳ����
	 
	public void drawMoney(Integer id,Double money) {
		//����һ���������
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		//���뼶��
		def.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
		//���񴫲�����
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		//���������Ƿ�ֻ��
		def.setReadOnly(false);
		//��������ĳ�ʱʱ��
		def.setTimeout(25);
		//��ȡһ������״̬��,Spring���ݸ��뼶��ʹ�����Ϊ��������ι�������
		TransactionStatus status = transactionManager.getTransaction(def);
		//��ѯ
		Account account = accountMapper.selectByPrimaryKey(id);
		try {
			//������Ŀ
			account.setBalance(account.getBalance()-money);
			accountMapper.updateByPrimaryKey(account);
			
			if(account.getBalance()<money) {
				throw new RuntimeException("error:�˻��ʽ���!");
			}
			//��¼��ˮ 
			Oprecord oprecord = new Oprecord();
			oprecord.setAccountid(id);
			oprecord.setOpmoney(money);
			oprecord.setOptime(new Date());
			oprecordMapper.insert(oprecord);
			//�ύ����
			transactionManager.commit(status);
		} catch (Exception e) {
			//�ع�����
			transactionManager.rollback(status);
			e.printStackTrace();
		}
	}*/
	
	@Transactional(readOnly=false,timeout=25,noRollbackFor= {NumberFormatException.class})
	public void drawMoney(Integer id,Double money) {
		//��ѯ
		Account account = accountMapper.selectByPrimaryKey(id);
		//������Ŀ
		account.setBalance(account.getBalance()-money);
		accountMapper.updateByPrimaryKey(account);
		
		if(account.getBalance()<money) {
			throw new RuntimeException("error:�˻��ʽ���!");
		}
		//��¼��ˮ 
		Oprecord oprecord = new Oprecord();
		oprecord.setAccountid(id);
		oprecord.setOpmoney(money);
		oprecord.setOptime(new Date());
		oprecordMapper.insert(oprecord);
		Integer i = Integer.valueOf("abc");
	}


}
