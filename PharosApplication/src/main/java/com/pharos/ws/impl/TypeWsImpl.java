/**
 * 
 */
package com.pharos.ws.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.TypeDTO;
import com.pharos.service.BookTypeService;
import com.pharos.ws.TypeWS;

/**
 * @author TOSHIBA
 *
 */

@RestController
public class TypeWsImpl implements TypeWS {

	private static final Logger LOGGER = LogManager.getLogger(TypeWsImpl.class);

	@Autowired
	BookTypeService typeService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pharos.ws.TypeWS#getAllType()
	 */
	@Override
	public ResponseEntity<List<TypeDTO>> getAllType() {
		LOGGER.info("Begin load TypeDTO");
		List<TypeDTO> typeDTOs = typeService.loadTypes();
		
		
		LOGGER.info("End load TypeDTO with result: " + typeDTOs);
		return new ResponseEntity<List<TypeDTO>>(typeDTOs, HttpStatus.OK);
	}

}
