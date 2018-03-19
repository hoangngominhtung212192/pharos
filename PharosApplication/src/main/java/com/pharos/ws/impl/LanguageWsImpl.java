/**
 * 
 */
package com.pharos.ws.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.LanguageDTO;
import com.pharos.service.LanguageService;
import com.pharos.ws.LanguageWS;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@RestController
public class LanguageWsImpl implements LanguageWS {

	private static final Logger LOGGER = LogManager.getLogger(LanguageWsImpl.class);
	
	@Autowired
	private LanguageService languageService;
	
	@Override
	public ResponseEntity<Integer> createLanguage() {
		
		LanguageDTO dto = new LanguageDTO();
		
		dto.setId(0);
		dto.setName("Success");
		
		LOGGER.info("Begin create Language with dto: " + dto);
		int status = 0;
		
		try {
			languageService.createLanguage(dto);
			status = 200;
		} catch (Exception e) {
			status = 500;
			LOGGER.error("Error createLanguage: ", e);
		}
		
		LOGGER.info("End create Language with status: " + status);
		
		ResponseEntity<Integer> response = new ResponseEntity<Integer>(status, HttpStatus.OK);
		return response;
	}

}
