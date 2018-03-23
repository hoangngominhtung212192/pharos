package com.pharos.service;

import org.springframework.stereotype.Service;

import com.pharos.dto.AccountDTO;
import com.pharos.dto.MemberDTO;;

@Service
public interface MemberService {
	public int registration(MemberDTO dto);
	
	public int findMemberIdByAccountId(AccountDTO accountId);
}
