package com.pharos.ws.impl;

import javax.transaction.Transactional;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pharos.service.UploadBookService;
import com.pharos.ws.BookWS;


@Service
@Transactional
public class BookWsImpl implements BookWS {
	private static final Logger LOGGER = LogManager.getLogger(LanguageWsImpl.class);

	@Autowired
	private UploadBookService uploadBook;

	@Override
	public ResponseEntity<Integer> createBook(MultipartFile file) {
		uploadBook.saveBook(file);
		return null;
	}

}
