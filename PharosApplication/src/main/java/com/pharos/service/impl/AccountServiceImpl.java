package com.pharos.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharos.util.EncrytedPasswordUtils;
import com.pharos.dto.AccountDTO;
import com.pharos.entity.Account;
import com.pharos.repository.AccountDao;
import com.pharos.service.AccountService;
import com.pharos.transformer.AccountTransformer;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private AccountTransformer accountTransformer;
	@Autowired
	private static final Logger LOGGER = LogManager.getLogger(AccountServiceImpl.class);

	private EncrytedPasswordUtils passwordUtil;
	
	@Override
	public void registration(AccountDTO dto) {
		LOGGER.info("Begin registration in Account ServiceImpl with Account DTO: {}", dto.toString());
		EncrytedPasswordUtils passwordUtil = new EncrytedPasswordUtils();
		
		String newPassword = passwordUtil.encrytePassword(dto.getPassword());
		dto.setPassword(newPassword);
		
		Account account = accountTransformer.convertToEntity(dto);
		
		AccountDTO existedAccount = null;
		existedAccount = 
		
	}

}