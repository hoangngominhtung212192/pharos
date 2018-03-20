package com.pharos.service;

import org.springframework.stereotype.Service;

import com.pharos.dto.AccountDTO;


@Service
public interface AccountService {
	void registration(AccountDTO dto);
	
	public AccountDTO findAccountByUsername(String username);
}
