package com.pharos.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.pharos.dto.MemberDTO;
import com.pharos.entity.Account;
import com.pharos.entity.Member;
import com.pharos.repository.MemberDao;

@Repository
public class MemberDaoImpl extends GenericDaoImpl<Member, Integer> implements MemberDao {

	private static final Logger LOGGER = LogManager.getLogger(MemberDaoImpl.class);

	public MemberDaoImpl() {
		super(Member.class);
	}
	
	@Override
	public Member registration(Member member) {
		LOGGER.info("Begin registration in Member DAO with Member: {}", member.getFullName());
		Member newMember = null;
		if (member != null) {
			newMember = this.create(member);
		}
		LOGGER.info("End registration in Account DAO with Account have id: {}", newMember.getFullName());
		return newMember;
	}

	@Override
	public Member findMemberIdByAccountId(Account account) {
		LOGGER.info("Begin getMemberIdByAccountId in Member DAO with Account : {}", account);
		Member member = null;

		List<Member> listMember = new ArrayList<Member>();
		String sql = "Select b from " + Member.class.getName() + " As b where b.account =:sAccount";

		Query query = this.entitymanager.createQuery(sql);
		query.setParameter("sAccount", account);
		listMember = query.getResultList();
		if (listMember.size() > 0) {
			member = listMember.get(0);

		}
		LOGGER.info("End getMemberIdByAccountId in Member DAO with Account : {}", account);
		return member;
	}

	@Override
	public Member findMemberById(int id) {
		LOGGER.info("Begin findMemberById in Member DAO with id : {}", id);
		Member member = null;

		member = this.read(id);
				
		LOGGER.info("End findMemberById in Member DAO with result : {}", member);
		return member;
	}

}
