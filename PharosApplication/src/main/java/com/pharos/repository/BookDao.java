/**
 * 
 */
package com.pharos.repository;

import org.springframework.stereotype.Repository;

import com.pharos.dto.BookDTO;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Repository
public interface BookDao extends GenericDao<BookDTO, Integer> {
	
}
