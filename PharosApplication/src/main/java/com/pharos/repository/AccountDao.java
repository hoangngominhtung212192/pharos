package com.pharos.repository;

import com.pharos.entity.Account;

public interface AccountDao {
	boolean checkLogin(String username , String password);

	boolean registration(Account account);
}
