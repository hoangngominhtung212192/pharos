/**
 * 
 */
package com.pharos.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pharos.dto.LanguageDTO;
import com.pharos.exception.BusinessException;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
@Transactional
public interface LanguageService {
	
	/**
	 * 
	 * @param languageDTO
	 * @throws BusinessException
	 */
	void createLanguage(LanguageDTO languageDTO) throws BusinessException;
}
