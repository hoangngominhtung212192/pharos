package com.pharos.repository.impl;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.pharos.entity.Author;
import com.pharos.repository.AuthorDao;

public class AuthorDaoImpl extends GenericDaoImpl<Author, Integer> implements AuthorDao {

	private static final Logger LOGGER = LogManager.getLogger(AuthorDao.class);

	@Override
	public boolean checkExistEmail(String email) {
		LOGGER.info("Begin checkExistEmail in Author DAO with email: ", email);
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
		LOGGER.info("End checkExistEmail in Author DAO with result: ", exist);
		return exist;
	}

}
