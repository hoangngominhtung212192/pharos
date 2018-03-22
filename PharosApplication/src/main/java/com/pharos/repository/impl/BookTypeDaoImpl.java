/**
 * 
 */
package com.pharos.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.pharos.entity.Booktype;
import com.pharos.repository.BookTypeDao;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Repository
public class BookTypeDaoImpl extends GenericDaoImpl<Booktype, Integer> implements BookTypeDao {

	private static final Logger LOGGER = LogManager.getLogger(BookTypeDaoImpl.class);
	
	/* (non-Javadoc)
	 * @see com.pharos.repository.BookTypeDao#findAllTypeByBookID(int)
	 */
	@Override
	public List<Booktype> findAllTypeByBookID(int id) {
		
		LOGGER.info("Begin findAllTypeByBookID with bookId: " + id);
		
		List<Booktype> listBookTypes = new ArrayList<Booktype>();
		
		String sql = "SELECT b FROM " + Booktype.class.getName() + " AS b WHERE b.book.id =:bookId";
		
		Query query = this.entitymanager.createQuery(sql);
		query.setParameter("bookId", id);

		listBookTypes = query.getResultList();
		
		LOGGER.info("End findAllTypeByBookID with result: " + listBookTypes);
		
		return listBookTypes;
	}

}
