package com.pharos.transformer;

import org.springframework.stereotype.Service;

import com.pharos.dto.RoleDTO;
import com.pharos.entity.Role;

@Service
public interface RoleTransformer {
	Role convertToEntity(RoleDTO roleDTO);

	RoleDTO convertToDTO(Role role);
}
