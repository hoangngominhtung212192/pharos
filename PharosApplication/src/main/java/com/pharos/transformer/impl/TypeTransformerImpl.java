/**
 * 
 */
package com.pharos.transformer.impl;

import org.springframework.stereotype.Service;

import com.pharos.dto.TypeDTO;
import com.pharos.entity.Type;
import com.pharos.transformer.TypeTransformer;

/**
 * @author TOSHIBA
 *
 */

@Service
public class TypeTransformerImpl implements TypeTransformer {

	/* (non-Javadoc)
	 * @see com.pharos.transformer.TypeTransformer#convertToDto(com.pharos.entity.Type)
	 */
	@Override
	public TypeDTO convertToDto(Type type) {
		TypeDTO dto=null;
		
		if (type!=null) {
			int id=type.getId();
			String typeName=type.getName();
			
			dto=new TypeDTO(id,typeName);
		}
		return dto;
	}

}
