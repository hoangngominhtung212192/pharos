package com.pharos.ws.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import com.gcs.rms.ws.impl.UserWsImpl;
import com.pharos.dto.AccountDTO;
import com.pharos.ws.AccountWS;

public class AccountWsImpl implements AccountWS {

	 private static final Logger LOGGER = LogManager.getLogger(AccountWsImpl.class);
	
	@Override
	public ResponseEntity<String> checkLogin(AccountDTO dto) {
		String username = dto.getUsername();
        String password = dto.getPassword();
        LOGGER.info("Begin login with username + password: {}", username + " -  " + password);
		
		return null;
	}

	@Override
	public ResponseEntity<String> registratrion(AccountDTO dto) {
		String username = dto.getUsername();
        String password = dto.getPassword();
        LOGGER.info("Begin registration with username + password: {}", username + " -  " + password);
		return null;
	}

}
