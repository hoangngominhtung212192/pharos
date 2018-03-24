/**
 * 
 */
package com.pharos.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharos.repository.AuthorDao;
import com.pharos.service.AuthorService;

/**
 * @author TOSHIBA
 *
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;
	
	@Override
	public boolean checkEmail(String email) {		
		return authorDao.checkExistEmail(email);
	}

}
