package com.pharos.transformer;

import org.springframework.stereotype.Service;

import com.pharos.dto.TypeDTO;
import com.pharos.entity.Type;

@Service
public interface TypeTransformer {
	TypeDTO convertToDto(Type type);
	
}
