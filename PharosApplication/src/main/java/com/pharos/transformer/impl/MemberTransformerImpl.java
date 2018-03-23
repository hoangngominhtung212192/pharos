package com.pharos.transformer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharos.dto.MemberDTO;
import com.pharos.entity.Member;
import com.pharos.service.AccountService;
import com.pharos.transformer.AccountTransformer;
import com.pharos.transformer.MemberTransformer;

@Service
public class MemberTransformerImpl implements MemberTransformer {

	private static final Logger LOGGER = LogManager.getLogger(AccountTransformerImpl.class);
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountTransformer accountTransformer;
	
	@Override
	public Member convertToEntity(MemberDTO dto) {
		LOGGER.info("Begin convertToEntity with Member Entity ID: {}", dto.getId());
		Member member = null;
		if(dto != null) {
			member = new Member();
			member.setId(dto.getId());
			member.setFullName(dto.getFullname());
			member.setAddress(dto.getAddress());
			member.setBrithday(dto.getBirthdate());
			member.setEmail(dto.getEmail());
			member.setTel(dto.getTel());
			member.setMoney(dto.getMoney());
			member.setAccount(accountTransformer.convertToEntity(
					accountService.findAccountById(
					dto.getAccountId())));
			
		}
		LOGGER.info("End convertToEntity with Member DTO ID: {}", dto.getId());
		return member;
	}

	@Override
	public MemberDTO convertToDTO(Member entity) {
		LOGGER.info("Begin convertToEntity with Member Entity ID: {}", entity.getId());
		MemberDTO memberDTO = null;
		if(entity != null) {
			memberDTO = new MemberDTO();
			memberDTO.setId(entity.getId());
			memberDTO.setFullname(entity.getFullName());
			memberDTO.setAddress(entity.getAddress());
			memberDTO.setBirthdate(entity.getBrithday());
			memberDTO.setEmail(entity.getEmail());
			memberDTO.setTel(entity.getTel());
			memberDTO.setMoney(entity.getMoney());
			memberDTO.setAccountId((accountTransformer.convertToDTO(entity.getAccount())).getId());
			
		}
		LOGGER.info("End convertToEntity with Member DTO ID: {}", entity.getId());
		return memberDTO;
	}

}
