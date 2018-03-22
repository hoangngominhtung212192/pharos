/**
 * 
 */
package com.pharos.service;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.pharos.dto.CartDTO;
import com.pharos.exception.BusinessException;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
@Transactional
public interface ShoppingBookService {
	
	/**
	 * 
	 * @param memberId
	 * @param bookId
	 * @return
	 * @throws BusinessException
	 */
	boolean didBuyBook(int memberId, int bookId) throws BusinessException;
	
	/**
	 * 
	 * @param memberId
	 * @param bookId
	 * @return
	 * @throws BusinessException
	 */
	CartDTO purchaseBook(int memberId, int bookId) throws BusinessException;
}
