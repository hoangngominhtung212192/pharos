/**
 * 
 */
package com.pharos.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.pharos.entity.Language;
import com.pharos.repository.LanguageDao;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Repository
public class LanguageDaoImpl extends GenericDaoImpl<Language, Integer> implements LanguageDao {

	/**
	 * @param entityClass
	 */
	public LanguageDaoImpl() {
		super(Language.class);
	}

	private static final Logger LOGGER = LogManager.getLogger(LanguageDaoImpl.class);
	
	/* (non-Javadoc)
	 * @see com.pharos.repository.LanguageDao#createLanguage(com.pharos.entity.Language)
	 */
	@Override
	public Language createLanguage(Language language) {
		LOGGER.info("Begin create Language with: " + language);
		
		Language newLanguage = this.create(language);
		
		LOGGER.info("End create Language with result: " + newLanguage);
		return newLanguage;
	}

}
