/**
 * 
 */
package com.pharos.repository.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.pharos.entity.Store;
import com.pharos.repository.StoreDao;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Repository
public class StoreDaoImpl extends GenericDaoImpl<Store, Integer> implements StoreDao {

	private static final Logger LOGGER = LogManager.getLogger(StoreDaoImpl.class);
	
	/**
	 * 
	 */
	public StoreDaoImpl() {
		super(Store.class);
	}
	
	/* (non-Javadoc)
	 * @see com.pharos.repository.StoreDao#didBuyBook(int, int)
	 */
	@Override
	public boolean didBuyBook(int memberId, int bookId) {
		
		LOGGER.info("Begin didBuyBook with memberId:" + memberId + " and bookId:" + bookId);
		
		String sql = "SELECT CASE WHEN (COUNT(s) > 0) THEN TRUE ELSE FALSE END FROM " + Store.class.getName() 
				+ " AS s WHERE s.member.id =:memberId AND s.book.id =:bookId";
		
		Query query = this.entitymanager.createQuery(sql);
		query.setParameter("memberId", memberId);
		query.setParameter("bookId", bookId);
		
		boolean result = (boolean) query.getSingleResult();
		
		LOGGER.info("End didBuyBook with result:" + result);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.pharos.repository.StoreDao#buyNewBook(com.pharos.entity.Store)
	 */
	@Override
	public Store buyNewBook(Store store) {

		LOGGER.info("Begin buyNewBook with Store_Entity: " + store);
		
		Store newStore = this.create(store);
		
		LOGGER.info("End buyNewBook with result: " + newStore);
		
		if (newStore != null) {
			
			return newStore;
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pharos.repository.StoreDao#getListBookByMemberId(int)
	 */
	@Override
	public List<Store> getListBookByMemberId(int memberId) {
		
		LOGGER.info("Begin getListBookByMemberId with memberId:" + memberId);
		
		String sql = "SELECT s FROM " + Store.class.getName() + " AS s WHERE s.member.id =:memberId";
		
		Query query = this.entitymanager.createQuery(sql);
		query.setParameter("memberId", memberId);
		
		List<Store> listStores = query.getResultList();
		
		LOGGER.info("End getListBookByMemberId with result:" + listStores);
		
		return listStores;
	}

	

}
