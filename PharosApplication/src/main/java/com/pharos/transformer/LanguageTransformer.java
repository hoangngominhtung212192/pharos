/**
 * 
 */
package com.pharos.transformer;

import org.springframework.stereotype.Service;

import com.pharos.dto.LanguageDTO;
import com.pharos.entity.Language;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
public interface LanguageTransformer {
	LanguageDTO convertToDto(Language language);
	
	Language convertToEntity(LanguageDTO dto);
}
