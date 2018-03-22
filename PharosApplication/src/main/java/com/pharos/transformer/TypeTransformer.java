package com.pharos.transformer;

import org.springframework.stereotype.Service;

import com.pharos.dto.TypeDTO;
import com.pharos.entity.Type;

@Service
public interface TypeTransformer {
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	TypeDTO convertToDto(Type type);
}
