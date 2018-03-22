/**
 * 
 */
package com.pharos.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharos.dto.BookDTO;
import com.pharos.dto.CartDTO;
import com.pharos.entity.Book;
import com.pharos.entity.Member;
import com.pharos.entity.Store;
import com.pharos.exception.BusinessException;
import com.pharos.repository.BookDao;
import com.pharos.repository.StoreDao;
import com.pharos.service.ShoppingBookService;
import com.pharos.transformer.BookTransformer;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
@Transactional
public class ShoppingBookServiceImpl implements ShoppingBookService {

	private static final Logger LOGGER = LogManager.getLogger(ShoppingBookServiceImpl.class);
	
	@Autowired
	private StoreDao storeDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookTransformer bookTransformer;
	
	/* (non-Javadoc)
	 * @see com.pharos.service.PurchaseBookService#didBuyBook(int, int)
	 */
	@Override
	public boolean didBuyBook(int memberId, int bookId) throws BusinessException {
		
		LOGGER.info("Begin didBuyBook_service with memberId:" + memberId + " and bookId: " + bookId);
		
		try {
			boolean didBuy = storeDao.didBuyBook(memberId, bookId);
			
			LOGGER.info("End didBuyBook_service with result: " + didBuy);
			
			return didBuy;
		} catch (Exception e) {
			LOGGER.error("PurchaseBookServiceImpl error: " + e.getMessage());
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.pharos.service.ShoppingBookService#purchaseBook(int, int)
	 */
	@Override
	public CartDTO purchaseBook(int memberId, int bookId) throws BusinessException {
		
		LOGGER.info("Begin purchaseBook with memberId: " + memberId + " and bookId: " + bookId);
		
		Store store = new Store();
		
		Book book = new Book();
		book.setId(bookId);
		
		Member member = new Member();
		member.setId(memberId);
		
		store.setBook(book);
		store.setMember(member);
		
		store.setDescription("Member: " + memberId + " --> Book: " + bookId);
		
		Date purchasedDate = new Date();
		store.setPurchasedDate(purchasedDate);
		
		try {
			Store newStore = storeDao.buyNewBook(store);
			
			if (newStore != null) {
				boolean success = true;
				
				Book currentBook = bookDao.getBookById(bookId);
				
				BookDTO currentBookDTO = bookTransformer.convertToDTO(currentBook);
				
				String pdfUrl = currentBookDTO.getPdfLocate();
				
				byte[] buffer = new byte[8192];
				
				File pdfFile = new File(pdfUrl);
				
				if (pdfFile.exists()) {
					
					FileInputStream fis = new FileInputStream(pdfFile);
					
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					
					for (int readNum; (readNum = fis.read(buffer)) != -1;) {
						baos.write(buffer, 0, readNum);
					}
					
					byte[] bytes = baos.toByteArray();
					
					CartDTO cartDTO = new CartDTO(bytes, success, bookId);
					
					return cartDTO;
					
				} else {
					LOGGER.error(pdfFile.getName() + " does not exist !");
				}
			}
			
		} catch (IOException e) {
			LOGGER.error("PurchaseBookServiceImpl error: " + e.getMessage());
		} catch (Exception e) {
			LOGGER.error("PurchaseBookServiceImpl error: " + e.getMessage());
		}
		
		return null;
	}
	
}
