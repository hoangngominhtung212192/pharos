package com.pharos.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.pharos.entity.Type;

@Repository
public interface TypeDao extends GenericDao<Type, Integer>{
	
	List<Type> loadType();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	String getNameById(int id);
}
