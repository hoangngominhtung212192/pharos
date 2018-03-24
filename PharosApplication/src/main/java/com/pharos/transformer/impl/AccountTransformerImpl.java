package com.pharos.transformer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharos.dto.AccountDTO;
import com.pharos.entity.Account;
import com.pharos.entity.Role;
import com.pharos.service.RoleService;
import com.pharos.transformer.AccountTransformer;
import com.pharos.transformer.RoleTransformer;

@Service
public class AccountTransformerImpl implements AccountTransformer {

	private static final Logger LOGGER = LogManager.getLogger(AccountTransformerImpl.class);
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleTransformer roleTransformer;

	@Override
	public Account convertToEntity(AccountDTO dto) {
		LOGGER.info("Begin convertToEntity with Account Entity ID: {}", dto.getId());
		Account account = null;
		if (dto != null) {
			account = new Account();
			account.setId(dto.getId());
			account.setUsername(dto.getUsername());
			account.setPassword(dto.getPassword());
			account.setRole(roleTransformer.convertToEntity(roleService.findRoleById(dto.getRoleId())));
		}
		LOGGER.info("End convertToEntity with result: {}", account.toString());
		return account;
	}

	@Override
	public AccountDTO convertToDTO(Account account) {
		LOGGER.info("Begin convertToDTO with User Entity: {}", account.toString());
		AccountDTO accountDTO = null;
		if (account != null) {
			accountDTO = new AccountDTO();
			accountDTO.setId(account.getId());
			accountDTO.setUsername(account.getUsername());
			accountDTO.setPassword(account.getPassword());
			accountDTO.setRoleId(account.getRole().getId());

		}
		LOGGER.info("End convertToDTO with result: {}", accountDTO.toString());
		return accountDTO;
	}

}
