package com.pharos.ws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pharos.dto.BookDTO;
import com.pharos.service.BookStoreService;
import com.pharos.service.BookTypeService;
import com.pharos.service.UploadBookService;
import com.pharos.ws.BookWS;

@Service
@Transactional
public class BookWsImpl implements BookWS {
	private static final Logger LOGGER = LogManager.getLogger(BookWsImpl.class);
	
	@Autowired
	private UploadBookService uploadBook;

	@Autowired
	private BookStoreService bookStoreService;
	
	@Autowired
	private BookTypeService bookTypeService;

	@Override
	public ResponseEntity<Integer> createBook(MultipartFile file) {
		uploadBook.saveBook(file);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pharos.ws.BookWS#getAllBooks()
	 */
	@Override
	public List<BookDTO> getAllBooks(int memberId) {

		LOGGER.info("Begin getAllBooks with memberId: " + memberId);
		
		List<BookDTO> listBooks = new ArrayList<BookDTO>();
		
		try {
			listBooks = bookStoreService.getAllBooks(memberId);
		} catch (Exception e) {
			LOGGER.error("BookWsImpl error: " + e.getMessage());
		}

		LOGGER.info("End getAllBooks with result: " + listBooks);
		
		return listBooks;
	}

	/* (non-Javadoc)
	 * @see com.pharos.ws.BookWS#getAllTypes(int)
	 */
	@Override
	public List<String> getAllTypes(int bookId) {
		LOGGER.info("Begin getAllTypes with bookId: " + bookId);
		
		List<String> listTypes = new ArrayList<String>();
		
		try {
			listTypes = bookTypeService.getListTypesByBookId(bookId);
		} catch (Exception e) {
			LOGGER.error("BookWsImpl error: " + e.getMessage());
		}

		LOGGER.info("End getAllTypes with result: " + listTypes);
		
		return listTypes;
	}

}
