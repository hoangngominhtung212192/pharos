package com.pharos.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.pharos.entity.Author;
import com.pharos.repository.AuthorDao;

@Repository
public class AuthorDaoImpl extends GenericDaoImpl<Author, Integer> implements AuthorDao {

	private static final Logger LOGGER = LogManager.getLogger(AuthorDao.class);

	public AuthorDaoImpl() {
		super(Author.class);
	}
	
	@Override
	public boolean checkExistEmail(String email) {
		LOGGER.info("Begin checkExistEmail in Author DAO with email: "+ email);
		boolean exist = false;
		
		if (email != null) {
			Author author=new Author();
			String sql = "Select b from " + Author.class.getName() + " As b where b.email =:sEmail";

			Query query = this.entitymanager.createQuery(sql);
			query.setParameter("sEmail", email);
		
			if (query.getFirstResult()>0) {
				exist=true;
			}
		}
		LOGGER.info("End checkExistEmail in Author DAO with result: "+ exist);
		return exist;
	}

	@Override
	public Author findAuthorById(int id) {
		LOGGER.info("Begin findAuthorById with id : {}", id);
		Author author = null;

		author = this.read(id);
				
		LOGGER.info("End findMemberById with result : {}", author);
		return author;
	}

	@Override
	public Author findAuthorByAccountId(int id) {
		LOGGER.info("Begin findAuthorByAccountId in Auhor DAO with Account : {}", id);
		Author author = null;

		String sql = "Select a from " + Author.class.getName() + " As a where a.account.id =:id";

		Query query = this.entitymanager.createQuery(sql);
		query.setParameter("id", id);
		
		author = (Author) query.getSingleResult();
		
		LOGGER.info("End findAuthorByAccountId in Auhor DAO with result : {}", author);
		return author;
	}

}
