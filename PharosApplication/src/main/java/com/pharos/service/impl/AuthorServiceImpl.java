/**
 * 
 */
package com.pharos.service.impl;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharos.dto.AuthorDTO;
import com.pharos.entity.Account;
import com.pharos.entity.Author;
import com.pharos.exception.BusinessException;
import com.pharos.repository.AuthorDao;
import com.pharos.service.AuthorService;
import com.pharos.transformer.AuthorTransformer;
import com.pharos.ws.impl.AccountWsImpl;

/**
 * @author TOSHIBA
 *
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	private static final Logger LOGGER = LogManager.getLogger(AuthorServiceImpl.class);

	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private AuthorTransformer authorTrans;

	@Override
	public boolean checkEmail(String email) {
		return authorDao.checkExistEmail(email);
	}

	@Override
	public int createAuthor(AuthorDTO authorDTO) {
		int authorId = -1;
		LOGGER.info("Begin createAuthor with data: {}", authorDTO);

		Author tmp = authorTrans.convertDtoToEntity(authorDTO);
		if (tmp != null) {
			authorId = authorDao.create(tmp).getId();
		}
		LOGGER.info("End createAuthor with authorId: {}", authorId);

		return authorId;
	}

	@Override
	public AuthorDTO findAuthorById(int authorId) throws BusinessException {

		LOGGER.info("Begin findAuthorById with authorId: {}", authorId);

		AuthorDTO dto = null;

		try {
			Author author = authorDao.findAuthorById(authorId);

			if (author != null) {
				dto = authorTrans.convertToDto(author);
			}

		} catch (Exception e) {
			LOGGER.error("Error in AuthorServiceImpl: " + e.getMessage());
		}
		LOGGER.info("End findAuthorById with result: {}" + dto);

		return dto;
	}

	@Override
	public int findAuthorByAccountId(int accountId) throws BusinessException {
		LOGGER.info("Begin findAuthorByAccountId in Author Service with Account Id " + accountId);
		
		Author author = null;
		
		try {
			author = authorDao.findAuthorByAccountId(accountId);
		} catch (Exception e) {
			LOGGER.error("Error in AuthorServiceImpl: " + e.getMessage());
		}
		LOGGER.info("End findAuthorByAccountId in Author Service with result: " + author.getId());
		
		return author.getId();
	}

}
