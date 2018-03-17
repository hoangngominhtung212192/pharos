/**
 * 
 */
package com.pharos.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pharos.entity.Type;
import com.pharos.repository.TypeDao;

/**
 * @author TOSHIBA
 *
 */
@Repository
public class TypeDaoImpl extends GenericDaoImpl<Type, Integer> implements TypeDao {

	/**
	 * @param entityClass
	 */
	public TypeDaoImpl() {
		super(Type.class);
	}
	
	/* (non-Javadoc)
	 * @see com.pharos.repository.GenericDao#getAll()
	 */
	@Override
	public List<Type> loadType() {
		List<Type> typeList=getAll();
		return typeList;
	}
	

}
