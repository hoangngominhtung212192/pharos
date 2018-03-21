package com.pharos.service;

import org.springframework.stereotype.Service;

import com.pharos.dto.RoleDTO;;

@Service
public interface RoleService {
	RoleDTO findRoleById(int id);
}
