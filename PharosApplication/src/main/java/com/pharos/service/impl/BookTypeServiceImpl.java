/**
 * 
 */
package com.pharos.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharos.entity.Booktype;
import com.pharos.entity.Type;
import com.pharos.exception.BusinessException;
import com.pharos.repository.BookTypeDao;
import com.pharos.repository.TypeDao;
import com.pharos.service.BookTypeService;
import com.pharos.transformer.TypeTransformer;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
@Transactional
public class BookTypeServiceImpl implements BookTypeService {

	private static final Logger LOGGER = LogManager.getLogger(BookTypeServiceImpl.class);
	
	@Autowired
	private TypeDao typeDao;
	
	@Autowired
	private BookTypeDao bookTypeDao;
	
	@Autowired
	private TypeTransformer typeTransformer;
	
	/* (non-Javadoc)
	 * @see com.pharos.service.BookTypeService#getListTypesByBookId(int)
	 */
	@Override
	public List<String> getListTypesByBookId(int id) throws BusinessException {
		
		LOGGER.info("Begin getListTypesByBookId with id: " + id);
		
		try {
			
			List<Booktype> listTypes = bookTypeDao.findAllTypeByBookID(id);
			List<String> listTypeNames = new ArrayList<String>();
			
			for (Booktype bookType : listTypes) {
				String typeName = typeDao.getNameById(bookType.getType().getId());
				
				listTypeNames.add(typeName);
			}
			
			LOGGER.info("End getListTypesByBookId with result: " + listTypeNames);
			
			return listTypeNames;
			
		} catch (Exception e) {
			LOGGER.error("BookStoreServiceImpl error: " + e.getMessage());
		}
						
		return null;
	}
	
}
