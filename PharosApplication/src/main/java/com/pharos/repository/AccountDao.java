package com.pharos.repository;

import org.springframework.stereotype.Repository;

import com.pharos.entity.Account;

@Repository
public interface AccountDao {

	Account registration(Account account);
	
	Account findAccountByUsername(String username);
}
