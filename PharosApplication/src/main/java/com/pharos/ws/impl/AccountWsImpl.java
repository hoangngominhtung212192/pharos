package com.pharos.ws.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.AccountDTO;
import com.pharos.service.AccountService;
import com.pharos.ws.AccountWS;

@RestController
public class AccountWsImpl implements AccountWS {

	@Autowired
	AccountService accountService;
	
	 private static final Logger LOGGER = LogManager.getLogger(AccountWsImpl.class);
	
	@Override
	public ResponseEntity<String> checkLogin(AccountDTO dto) {
		String username = dto.getUsername();
        String password = dto.getPassword();
        LOGGER.info("Begin login with username + password: {}", username + " -  " + password);
		
		return null;
	}

	@Override
	public ResponseEntity<String> registratrion() {
		String status = "";
		AccountDTO dto = new AccountDTO();
		dto.setId(0);
		dto.setUsername("tamndse62381");
		dto.setPassword("bibo1997");
		dto.setRoleId(1);
		dto.setEnable(true);
        LOGGER.info("Begin registration with AccountDTO Id : " + dto.getId());
        if(dto != null) {
        	try {
        		accountService.registration(dto);
        		status = "Create Successfull";
        	}catch(Exception e) {
        		System.out.println(e);
        		status = "Fail SML";
        	}
        }
        LOGGER.info("End registration with AccountDTO Id : " + dto.getId());
        ResponseEntity<String> response = new ResponseEntity<String>(status, HttpStatus.OK);
        return response;
	}

}
