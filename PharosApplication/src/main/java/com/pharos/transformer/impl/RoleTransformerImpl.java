package com.pharos.transformer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pharos.dto.RoleDTO;
import com.pharos.entity.Role;
import com.pharos.transformer.RoleTransformer;

@Service
public class RoleTransformerImpl implements RoleTransformer {

	private static final Logger LOGGER = LogManager.getLogger(AccountTransformerImpl.class);
	
	@Override
	public Role convertToEntity(RoleDTO roleDTO) {
		LOGGER.info("Begin convertToEntity in Role Transformer with roleDTO Id : " + roleDTO.getId());
		Role role = null;
		if(roleDTO != null) {
			role = new Role();
			role.setId(roleDTO.getId());
			role.setName(roleDTO.getName());
			role.setDescription(roleDTO.getDescription());
		}
		LOGGER.info("End convertToEntity in Role Transformer with roleDTO Id : " + roleDTO.getId());
		return role;
	}

	@Override
	public RoleDTO convertToDTO(Role role) {
		LOGGER.info("Begin convertToDTO in Role Transformer with role Id : " + role.getId());
		RoleDTO roleDTO = null;
		if(role != null) {
			roleDTO = new RoleDTO();
			roleDTO.setId(role.getId());
			roleDTO.setName(role.getName());
			roleDTO.setDescription(role.getDescription());
		}
		LOGGER.info("End convertToDTO in Role Transformer with role Id : " + role.getId());
		return roleDTO;
	}

}
