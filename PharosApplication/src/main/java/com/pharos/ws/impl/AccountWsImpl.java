package com.pharos.ws.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.AccountDTO;
import com.pharos.dto.MemberDTO;
import com.pharos.dto.RoleDTO;
import com.pharos.service.AccountService;
import com.pharos.service.MemberService;
import com.pharos.service.RoleService;
import com.pharos.ws.AccountWS;


@RestController
public class AccountWsImpl implements AccountWS {

	@Autowired
	AccountService accountService;
	@Autowired
	MemberService memberService;
	@Autowired
	RoleService roleService;

	private static final Logger LOGGER = LogManager.getLogger(AccountWsImpl.class);

	@Override
	public HashMap<String, Integer> checkLogin(String username, String password) {
		LOGGER.info("Begin login in Account WS with username - password: {}", username + " - " + password);
		AccountDTO accountDTO = null;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		try {
			accountDTO = new AccountDTO();
			accountDTO = accountService.login(username, password);
			LOGGER.info("End login in Account WS with username - password : {}", username + " - " + password);
			if (accountDTO != null) {
				hm.put("roleID", accountDTO.getRoleId());
				if (accountDTO.getRoleId() == 2) {
					int memberId = memberService.findMemberIdByAccountId(accountDTO);
					hm.put("ID", memberId);
					return hm;
				} else if (accountDTO.getRoleId() == 3) {

				}

			} else {
				hm.put("roleID", -1);
				hm.put("ID", -1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hm;
	}

	@Override
	public String registratrion(
			String username ,String password, String email, String tel) {
		String status = "";
		int accountId = -1;
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setUsername(username);
		accountDTO.setPassword(password);
		accountDTO.setRoleId(2);
		accountDTO.setEnable(true);
		LOGGER.info("Begin registration with AccountDTO Id : " + accountDTO.getId());
		if (accountDTO != null) {
			try {
				accountId = accountService.registration(accountDTO);
				LOGGER.info("End registration with AccountDTO Id : " + accountDTO.getUsername());
				if (accountId > -1) {
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setAccountId(accountId);
//					Date dob = new SimpleDateFormat("dd/MM/yyyy").parse("17/02/1997");
					memberDTO.setEmail(email);	
					memberDTO.setTel(tel);
					memberDTO.setMoney(0);
					LOGGER.info("Begin registration with MemberDTO Id : " + memberDTO.getAccountId());
					memberService.registration(memberDTO);
					LOGGER.info("End registration with MemberDTO Id : " + memberDTO.getAccountId());
					status = "Successfull";
				} else if (accountId == -1) {
					status = "Existed";
				}

			} catch (Exception e) {
				System.out.println(e);
				status = "Fail SML";
			}
		}
		return status;
	}

}
