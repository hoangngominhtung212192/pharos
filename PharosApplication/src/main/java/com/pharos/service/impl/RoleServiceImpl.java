package com.pharos.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharos.dto.RoleDTO;
import com.pharos.entity.Role;
import com.pharos.repository.RoleDao;
import com.pharos.service.RoleService;
import com.pharos.transformer.RoleTransformer;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	@Autowired
	RoleTransformer roleTransformer;

	private static final Logger LOGGER = LogManager.getLogger(RoleServiceImpl.class);

	@Override
	public RoleDTO findRoleById(int id) {
		LOGGER.info("Begin findRoleById in Role Service with Id " + id);
		RoleDTO roleDTO = new RoleDTO();
		Role role = roleDao.findRoleById(id);
		if (role != null) {
			roleDTO = roleTransformer.convertToDTO(role);
		}
		LOGGER.info("End findRoleById in Role Service with Id " + id);
		return roleDTO;
	}
}
