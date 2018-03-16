/**
 * 
 */
package com.pharos.service.impl;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharos.dto.LanguageDTO;
import com.pharos.entity.Language;
import com.pharos.exception.BusinessException;
import com.pharos.repository.LanguageDao;
import com.pharos.service.LanguageService;
import com.pharos.transformer.LanguageTransformer;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {

	private static final Logger LOGGER = LogManager.getLogger(LanguageServiceImpl.class);
	
	@Autowired
	private LanguageDao languageDAO;
	
	@Autowired
	private LanguageTransformer languageTransformer;
	
	@Override
	public void createLanguage(LanguageDTO languageDTO) throws BusinessException {
		LOGGER.info("Begin createLanguage with languageDTO: {}", languageDTO);
		
		Language newLanguage = null;
		Language language = languageTransformer.convertToEntity(languageDTO);
		
		try {
			newLanguage = languageDAO.createLanguage(language);
		} catch (Exception e) {
			throw new BusinessException("500", e);
		}
		
		LOGGER.info("End createLanguage with result: " + newLanguage);
		
	}

}
