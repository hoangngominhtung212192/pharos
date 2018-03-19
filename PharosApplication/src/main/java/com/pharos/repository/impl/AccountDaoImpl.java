package com.pharos.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gcs.rms.entity.User;
import com.gcs.rms.repository.impl.UserDaoImpl;
import com.pharos.entity.Account;
import com.pharos.repository.AccountDao;

public class AccountDaoImpl extends GenericDaoImpl<Account, Integer> implements AccountDao {

	private static final Logger LOGGER = LogManager.getLogger(AccountDaoImpl.class);
	
	@Override
	public boolean checkLogin(String username , String password) {
		LOGGER.info("Begin checkLogin in Account DAO with username: {}", username);
		
		
		return false;
	}

	@Override
	public boolean registration(Account account) {
		LOGGER.info("Begin createUser in User DAO with User: {}", account.getUsername());
		Account newAccount = null;
        if (account != null) {
        	newAccount = this.create(account);
        }
        LOGGER.info("End createUser in User DAO with User have id: {}", newAccount.getId());
		return false;
	}

}
