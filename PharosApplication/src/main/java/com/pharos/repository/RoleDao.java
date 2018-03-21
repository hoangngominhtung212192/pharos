package com.pharos.repository;

import org.springframework.stereotype.Repository;

import com.pharos.entity.Role;;

@Repository
public interface RoleDao {
	Role findRoleById(int id);
}
