package com.pharos.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharos.dto.AccountDTO;
import com.pharos.dto.MemberDTO;
import com.pharos.entity.Account;
import com.pharos.entity.Member;
import com.pharos.repository.MemberDao;
import com.pharos.service.MemberService;
import com.pharos.transformer.AccountTransformer;
import com.pharos.transformer.MemberTransformer;

@Transactional
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	@Autowired
	MemberTransformer memberTransformer;
	@Autowired
	AccountTransformer accountTransformer;

	private static final Logger LOGGER = LogManager.getLogger(MemberServiceImpl.class);

	@Override
	public int registration(MemberDTO dto) {
		LOGGER.info("Begin registration in Member Service with Account Id " + dto.getAccountId());
		if (dto != null) {
			Member member = memberTransformer.convertToEntity(dto);
			if (member != null) {
				member = memberDao.registration(member);
			}
		}

		LOGGER.info("End registration in Member Service with Account Id " + dto.getAccountId());
		return 0;
	}

	@Override
	public int findMemberIdByAccountId(AccountDTO accountDTO) {
		LOGGER.info("Begin getMemberIdByAccountId in Member Service with Account Id " + accountDTO.getId());
		MemberDTO memberDTO = null;
		Member member = null;

		if (accountDTO != null) {
			Account account = accountTransformer.convertToEntity(accountDTO);
			member = memberDao.findMemberIdByAccountId(account);
			if (member != null) {
				memberDTO = memberTransformer.convertToDTO(member);
			}
		}

		LOGGER.info("Begin getMemberIdByAccountId in Member Service with Account Id " + accountDTO.getId());
		return memberDTO.getId();
	}

}
