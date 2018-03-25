package com.pharos.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pharos.dto.AccountDTO;
import com.pharos.dto.MemberDTO;;

@Service
@Transactional
public interface MemberService {
	public int registration(MemberDTO dto);
	
	public int findMemberIdByAccountId(AccountDTO accountId);
}
