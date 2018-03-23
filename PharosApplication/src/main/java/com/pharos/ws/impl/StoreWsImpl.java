/**
 * 
 */
package com.pharos.ws.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.BookDTO;
import com.pharos.dto.CartDTO;
import com.pharos.service.BookStoreService;
import com.pharos.service.ShoppingBookService;
import com.pharos.ws.StoreWS;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@RestController
public class StoreWsImpl implements StoreWS {

	private static final Logger LOGGER = LogManager.getLogger(StoreWsImpl.class);

	@Autowired
	private ShoppingBookService shoppingBookService;

	@Autowired
	private BookStoreService bookStoreService;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pharos.ws.StoreWS#didBuyBook(int, int)
	 */
	@Override
	public Map<String, Boolean> didBuyBook(int memberId, int bookId) {

		LOGGER.info("Begin didBuyBook_controller with memberId:" + memberId + " and bookId:" + bookId);

		try {
			boolean didBuyBook = shoppingBookService.didBuyBook(memberId, bookId);

			LOGGER.info("End didBuyBook with result:" + didBuyBook);

			return Collections.singletonMap("existed", didBuyBook);
		} catch (Exception e) {
			LOGGER.error("StoreWsImpl error: " + e.getMessage());
		}

		return Collections.singletonMap("existed", false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pharos.ws.StoreWS#shoppingBook(int, int)
	 */
	@Override
	public Map<String, Boolean> shoppingBook(int memberId, int bookId) {

		LOGGER.info("Begin shoppingBook with memberId:" + memberId + " and bookId:" + bookId);

		try {
			boolean shopping = shoppingBookService.purchaseBook(memberId, bookId);

			LOGGER.info("End shoppingBook with result:" + shopping);

			return Collections.singletonMap("shopping", shopping);
		} catch (Exception e) {
			LOGGER.error("StoreWsImpl error: " + e.getMessage());
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see com.pharos.ws.StoreWS#getAllPurchasedBooks(int)
	 */
	@Override
	public List<BookDTO> getAllPurchasedBooks(int memberId) {
		
		LOGGER.info("Begin getAllPurchasedBooks with memberId:" + memberId);

		try {
			List<BookDTO> listBookDTOs = bookStoreService.getAllPurchasedBook(memberId);
			
			LOGGER.info("End shoppingBook with result:" + listBookDTOs);

			return listBookDTOs;
		} catch (Exception e) {
			LOGGER.error("StoreWsImpl error: " + e.getMessage());
		}

		return null;
	}

}
