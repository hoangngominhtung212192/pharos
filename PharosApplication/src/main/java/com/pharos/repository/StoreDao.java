/**
 * 
 */
package com.pharos.repository;

import org.springframework.stereotype.Repository;

import com.pharos.entity.Store;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Repository
public interface StoreDao extends GenericDao<Store, Integer> {
	
	/**
	 * 
	 * @param memberId
	 * @param bookId
	 * @return
	 */
	boolean didBuyBook(int memberId, int bookId);
	
	/**
	 * 
	 * @param store
	 */
	Store buyNewBook(Store store);
}
