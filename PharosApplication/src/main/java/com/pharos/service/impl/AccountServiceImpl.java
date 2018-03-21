package com.pharos.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharos.util.EncrytedPasswordUtils;
import com.pharos.dto.RoleDTO;
import com.pharos.dto.AccountDTO;
import com.pharos.entity.Account;
import com.pharos.repository.AccountDao;
import com.pharos.service.AccountService;
import com.pharos.service.RoleService;
import com.pharos.transformer.AccountTransformer;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private AccountTransformer accountTransformer;
	@Autowired
	private RoleService roleService;

	private static final Logger LOGGER = LogManager.getLogger(AccountServiceImpl.class);

	private EncrytedPasswordUtils passwordUtil;

	@Override
	public void registration(AccountDTO dto) {
		LOGGER.info("Begin registration in Account Service with Account DTO ID : {}", dto.getId());
		EncrytedPasswordUtils passwordUtil = new EncrytedPasswordUtils();

		String newPassword = passwordUtil.encrytePassword(dto.getPassword());
		dto.setPassword(newPassword);

		Account account = accountTransformer.convertToEntity(dto);

		AccountDTO existedAccount = null;
		existedAccount = findAccountByUsername(dto.getUsername());

		if (existedAccount == null) {
			int roleId = dto.getRoleId();
			RoleDTO roleDTO = roleService.findRoleById(roleId);

			if (account != null && roleDTO != null) {
				try {
					Account newAccount = accountDao.registration(account);
					LOGGER.info("End createUser in Account Service with result: {}", newAccount.toString());

				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} else {
			// already existed account
		}
	}

	@Override
	public AccountDTO findAccountByUsername(String username) {
		LOGGER.info("Begin findAccountByUsername in Account Service with username{}", username);
		AccountDTO accountDTO = null;
		Account account = null;
		if (username != null) {
			account = accountDao.findAccountByUsername(username);
			if (account != null) {
				accountDTO = accountTransformer.convertToDTO(account);
			}
		}
		LOGGER.info("End findUserByUserName in Account Service with result: {}", accountDTO);
		return accountDTO;
	}

	@Override
	public AccountDTO login(String username, String password) {
		LOGGER.info("Begin login in Account Service with username - password: {}", username + " - " + password);
		AccountDTO accountDTO = null;
		passwordUtil = new EncrytedPasswordUtils();
		if (username != null) {
			accountDTO = findAccountByUsername(username);
			if (passwordUtil.compare(password, accountDTO.getPassword())) {
				return accountDTO;
			} else {
				return null;
			}

		}
		LOGGER.info("End login in Account Service with result: {}", accountDTO);
		return accountDTO;
	}

}