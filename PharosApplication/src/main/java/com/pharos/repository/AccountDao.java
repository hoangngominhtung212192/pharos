package com.pharos.repository;

import org.springframework.stereotype.Repository;

import com.pharos.entity.Account;

@Repository
public interface AccountDao {
	boolean checkLogin(String username , String password);

	Account registration(Account account);
	
	Account findAccountByUsername(String username);
}
