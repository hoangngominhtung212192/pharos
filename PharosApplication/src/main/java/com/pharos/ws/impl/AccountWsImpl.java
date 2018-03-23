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
				if (accountDTO.getRoleId() == 1) {
					int memberId = memberService.findMemberIdByAccountId(accountDTO);
					hm.put("ID", memberId);
					return hm;
				} else if (accountDTO.getRoleId() == 2) {

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
	public ResponseEntity<String> registratrion() {
		String status = "";
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(0);
		accountDTO.setUsername("tamndse62381");
		accountDTO.setPassword("bibo1997");
		accountDTO.setRoleId(1);
		accountDTO.setEnable(true);
		LOGGER.info("Begin registration with AccountDTO Id : " + accountDTO.getId());
		if (accountDTO != null) {
			try {
				int accountId = accountService.registration(accountDTO);
				LOGGER.info("End registration with AccountDTO Id : " + accountDTO.getId());
				if (accountId != 0) {
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setAccountId(accountId);
					Date dob = new SimpleDateFormat("dd/MM/yyyy").parse("17/02/1997");
					memberDTO.setBirthdate(dob);
					memberDTO.setEmail("tamndse62381@gmail.com");
					memberDTO.setFullname("Nguyen Duc Tam");
					memberDTO.setMoney(300);
					memberDTO.setTel("01227614243");
					memberDTO.setAddress("65/58 Nguyen Dinh Chieu");
					LOGGER.info("Begin registration with MemberDTO Id : " + memberDTO.getAccountId());
					memberService.registration(memberDTO);
					LOGGER.info("End registration with MemberDTO Id : " + memberDTO.getAccountId());
					status = "Create Successfull";
				} else if (accountId == -1) {
					status = "Account Already Existed";
				}

			} catch (Exception e) {
				System.out.println(e);
				status = "Fail SML";
			}
		}

		ResponseEntity<String> response = new ResponseEntity<String>(status, HttpStatus.OK);
		return response;
	}

}
