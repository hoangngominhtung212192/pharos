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

import com.google.gson.JsonObject;
import com.pharos.dto.BookDTO;
import com.pharos.service.BookStoreService;
import com.pharos.service.BookTypeService;
import com.pharos.service.UploadBookService;
import com.pharos.transformer.BookTransformer;
import com.pharos.ws.BookWS;

import springfox.documentation.spring.web.json.Json;

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

	@Autowired
	private BookTransformer bookTrans;
	
	@Override
	public ResponseEntity<JsonObject> createBook(MultipartFile file, String book_info) {
		JsonObject jsonObject=new JsonObject();
		ResponseEntity<JsonObject> response;
		
		boolean sucess=true;
		try {
		String pdfLocate=uploadBook.saveBook(file);
		BookDTO dto=bookTrans.convertDataToDto(book_info, pdfLocate);
		dto.setViewCount(0);
		dto.setVoteCount(0);
		dto.setPdfLocate(pdfLocate);
		
		bookStoreService.saveBookInfo(dto);
		}catch (Exception e) {
			e.printStackTrace();
			sucess=false;
		}
		
		if (sucess) {
			jsonObject.addProperty("status", "OK");
			jsonObject.addProperty("Message", "Save success");
			response = new ResponseEntity<JsonObject>(jsonObject, HttpStatus.OK);
		}else {
			jsonObject.addProperty("status", "False");
			jsonObject.addProperty("Message", "Save false");
			response = new ResponseEntity<JsonObject>(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return  response;
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
