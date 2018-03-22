/**
 * 
 */
package com.pharos.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pharos.entity.Booktype;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Repository
public interface BookTypeDao extends GenericDao<Booktype, Integer> {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<Booktype> findAllTypeByBookID(int id);
}
