package com.pharos.ws.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.AuthorDTO;
import com.pharos.service.AuthorService;
import com.pharos.ws.AuthorWS;

@RestController
public class AuthorWsImpl implements AuthorWS {

	private static final Logger LOGGER = LogManager.getLogger(AuthorWsImpl.class);
	
	@Autowired
	private AuthorService authorService;
	
	@Override
	public AuthorDTO getAuthorById(int authorId) {
		LOGGER.info("Begin getAuthorById with authorId: " + authorId);

		AuthorDTO dto = new AuthorDTO();

		try {
			dto = authorService.findAuthorById(authorId);
		} catch (Exception e) {
			LOGGER.error("AuthorWsImpl error: " + e.getMessage());
		}

		LOGGER.info("End getAuthorById with result: " + dto);

		return dto;
	}
}
