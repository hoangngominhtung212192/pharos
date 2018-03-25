/**
 * 
 */
package com.pharos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pharos.dto.BookDTO;
import com.pharos.dto.CartDTO;
import com.pharos.exception.BusinessException;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
@Transactional
public interface BookStoreService {
	
	/**
	 * 
	 * @return
	 * @throws BusinessException
	 */
	List<BookDTO> getAllBooks(int memberId) throws BusinessException;
	
	
	/**
	 * 
	 * @param bookDTO
	 * @return
	 */
	int saveBookInfo(BookDTO bookDTO);
	
	/**
	 * 
	 * @param memberId
	 * @return
	 * @throws BusinessException
	 */
	List<BookDTO> getAllPurchasedBook(int memberId) throws BusinessException;
	
	/**
	 * 
	 * @param bookId
	 * @return
	 * @throws BusinessException
	 */

	byte[] readBook(int bookId) throws BusinessException;
	
	/**
	 * 
	 * @param title
	 * @return
	 * @throws BusinessException
	 */
	List<BookDTO> searchByTitle(String title) throws BusinessException;
}

