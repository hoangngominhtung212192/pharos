/**
 * 
 */
package com.pharos.transformer.impl;

import org.springframework.stereotype.Service;

import com.pharos.dto.LanguageDTO;
import com.pharos.entity.Language;
import com.pharos.transformer.LanguageTransformer;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
public class LanguageTransformerImpl implements LanguageTransformer {

	/**
	 * 
	 * @param language
	 * @return
	 */
	@Override
	public LanguageDTO convertToDto(Language language) {
		
		LanguageDTO dto = null;
		
		if (language != null) {
			dto = new LanguageDTO();
			dto.setId(language.getId());
			dto.setName(language.getName());
		}
		
		return dto;
	}

	/**
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public Language convertToEntity(LanguageDTO dto) {
		
		Language language = null;
		
		if (dto != null) {
			language = new Language();
			language.setId(dto.getId());
			language.setName(dto.getName());
		}
		
		return language;
	}

}
