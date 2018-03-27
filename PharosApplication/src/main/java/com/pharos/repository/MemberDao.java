package com.pharos.repository;

import org.springframework.stereotype.Repository;

import com.pharos.entity.Account;
import com.pharos.entity.Member;

@Repository
public interface MemberDao extends GenericDao<Member, Integer> {

	public Member registration(Member member);
	
	public Member findMemberIdByAccountId (Account accountId);
	
	public Member findMemberById(int id);
}
