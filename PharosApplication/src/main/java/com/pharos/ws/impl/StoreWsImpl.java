/**
 * 
 */
package com.pharos.ws.impl;

import java.util.Collections;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.CartDTO;
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
	public CartDTO shoppingBook(int memberId, int bookId) {

		LOGGER.info("Begin shoppingBook with memberId:" + memberId + " and bookId:" + bookId);

		try {
			CartDTO dto = shoppingBookService.purchaseBook(memberId, bookId);

			LOGGER.info("End shoppingBook with result:" + dto);

			return dto;
		} catch (Exception e) {
			LOGGER.error("StoreWsImpl error: " + e.getMessage());
		}

		return null;
	}

}
