package com.pharos.repository;

import org.springframework.stereotype.Repository;

import com.pharos.entity.Account;

@Repository
public interface AccountDao extends GenericDao<Account,Integer> {

	public Account registration(Account account);
	
	public Account findAccountByUsername(String username);
	
	public Account findAccountById(int id);
	
}
