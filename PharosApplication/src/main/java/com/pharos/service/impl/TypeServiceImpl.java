/**
 * 
 */
package com.pharos.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharos.dto.TypeDTO;
import com.pharos.entity.Type;
import com.pharos.repository.TypeDao;
import com.pharos.service.TypeService;
import com.pharos.transformer.TypeTransformer;

/**
 * @author TOSHIBA
 *
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pharos.service.TypeService#loadTypes()
	 */
	private static final Logger LOGGER = LogManager.getLogger(TypeServiceImpl.class);

	@Autowired
	private TypeDao typeDao;

	@Autowired
	private TypeTransformer typeTrans;

	@Override
	public List<TypeDTO> loadTypes() {	
		List<Type> typeDaoList = typeDao.getAll();
		LOGGER.info("Get type from database: {}",typeDaoList);
		
		List<TypeDTO> typeDtoList = null;

		if (typeDaoList != null && typeDaoList.size() > 0) {
			typeDtoList=new ArrayList<>();
			
			for (Type typeDao : typeDaoList) {
				TypeDTO typeDTO = typeTrans.convertToDto(typeDao);
				if (typeDTO != null) {
					typeDtoList.add(typeDTO);
				}
			}
		}
		
		LOGGER.info("End loadTypes with result: " + typeDtoList);

		return typeDtoList;
	}

}
