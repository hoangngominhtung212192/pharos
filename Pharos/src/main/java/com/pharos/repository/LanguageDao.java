/**
 * 
 */
package com.pharos.repository;

import org.springframework.stereotype.Repository;

import com.pharos.entity.Language;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Repository
public interface LanguageDao extends GenericDao<Language, Integer> {
	
	/**
	 * create language entity
	 * @param language entity
	 * @return Language entity
	 */
	Language createLanguage(Language language);
}
