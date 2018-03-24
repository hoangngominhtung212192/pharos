/**
 * 
 */
package com.pharos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pharos.dto.BookDTO;
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
	
	int saveBookInfo(BookDTO bookDTO);
}

