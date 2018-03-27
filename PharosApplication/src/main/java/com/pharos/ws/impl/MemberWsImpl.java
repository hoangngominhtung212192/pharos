package com.pharos.ws.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.MemberDTO;
import com.pharos.service.AccountService;
import com.pharos.ws.MemberWS;

@RestController
public class MemberWsImpl implements MemberWS {

	private static final Logger LOGGER = LogManager.getLogger(MemberWsImpl.class);
	
	@Autowired
	private AccountService accountService;
	
	@Override
	public MemberDTO getMemberById(int memberId) {
		LOGGER.info("Begin getMemberById with memberId: " + memberId);

		MemberDTO dto = new MemberDTO();

		try {
			dto = accountService.findMemberById(memberId);
		} catch (Exception e) {
			LOGGER.error("MemberWsImpl error: " + e.getMessage());
		}

		LOGGER.info("End getMemberById with result: " + memberId);

		return dto;
	}

}
