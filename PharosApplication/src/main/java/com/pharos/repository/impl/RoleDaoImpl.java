package com.pharos.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.pharos.entity.Book;
import com.pharos.entity.Role;
import com.pharos.entity.Store;
import com.pharos.repository.RoleDao;
import com.pharos.service.impl.RoleServiceImpl;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, Integer> implements RoleDao {

	private static final Logger LOGGER = LogManager.getLogger(RoleDaoImpl.class);

	@Override
	public Role findRoleById(int id) {
		LOGGER.info("Begin findRoleById in Role DAO with Id " + id);
		Role role = null;
		try {
			List<Role> listRole = new ArrayList<Role>();
			String sql = "Select b from " + Role.class.getName() + " As b where b.id =:sId";
			
			Query query = this.entitymanager.createQuery(sql);
			query.setParameter("sId", id);
			listRole = query.getResultList();
			role = listRole.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("Begin findRoleById in Role DAO with Id " + id);
		return role;
	}

}
