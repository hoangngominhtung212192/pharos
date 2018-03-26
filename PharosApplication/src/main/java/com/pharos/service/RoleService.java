package com.pharos.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pharos.dto.RoleDTO;;

@Service
@Transactional
public interface RoleService {
	RoleDTO findRoleById(int id);
}
