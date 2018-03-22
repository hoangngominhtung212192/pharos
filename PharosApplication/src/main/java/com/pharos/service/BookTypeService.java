/**
 * 
 */
package com.pharos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pharos.exception.BusinessException;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
@Transactional
public interface BookTypeService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<String> getListTypesByBookId(int id) throws BusinessException; 
}
