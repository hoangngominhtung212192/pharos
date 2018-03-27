/**
 * 
 */
package com.pharos.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharos.dto.BookDTO;
import com.pharos.dto.CartDTO;
import com.pharos.entity.Book;
import com.pharos.entity.Store;
import com.pharos.exception.BusinessException;
import com.pharos.repository.BookDao;
import com.pharos.repository.StoreDao;
import com.pharos.service.BookStoreService;
import com.pharos.transformer.BookTransformer;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
@Transactional
public class BookStoreServiceImpl implements BookStoreService {

	private static final Logger LOGGER = LogManager.getLogger(BookStoreServiceImpl.class);

	@Autowired
	private BookDao bookDao;

	@Autowired
	private StoreDao storeDao;

	@Autowired
	private BookTransformer bookTransformer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pharos.service.BookStoreService#getAllBooks()
	 */
	@Override
	public List<BookDTO> getAllBooks(int memberId) throws BusinessException {

		LOGGER.info("Begin getAllBooks with memberId: " + memberId);

		try {
			List<Book> listBooks = bookDao.getAllBooks(memberId);

			if (listBooks != null) {
				List<BookDTO> listBookDTO = new ArrayList<BookDTO>();

				byte[] array = null;

				if (listBooks.size() > 0) {
					for (Book book : listBooks) {

						BookDTO dto = bookTransformer.convertToDTO(book);

						String sourceDir = book.getPdf();
						File sourceFile = new File(sourceDir);

						if (sourceFile.exists()) {
							PDDocument document = PDDocument.load(sourceDir);

							PDPage firstPage = (PDPage) document.getDocumentCatalog().getAllPages().get(0);

							BufferedImage image = firstPage.convertToImage();

							ByteArrayOutputStream bao = new ByteArrayOutputStream();

							ImageIO.write(image, "jpg", bao);

							array = bao.toByteArray();

							bao.close();

							document.close();

							dto.setImage(array);
						} else {
							System.err.println(sourceFile.getName() + "--> File does not exist");
						}

						listBookDTO.add(dto);
					}
				}

				LOGGER.info("End getAllBooks with result: " + listBookDTO);

				return listBookDTO;
			}
		} catch (Exception e) {
			LOGGER.error("BookStoreServiceImpl error: " + e.getMessage());
		}

		return null;
	}

	@Override
	public int saveBookInfo(BookDTO bookDTO) {
		int id = 0;

		Book book = bookTransformer.convertToEntity(bookDTO);

		try {
			id = bookDao.create(book).getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pharos.service.BookStoreService#getAllPurchasedBook(int)
	 */
	@Override
	public List<BookDTO> getAllPurchasedBook(int memberId) throws BusinessException {

		LOGGER.info("Begin getAllPurchasedBook with memberId: " + memberId);

		try {

			List<Store> listStores = storeDao.getListBookByMemberId(memberId);

			if (listStores != null) {

				// delete duplicate entities result from socket timeout
				// exception
				for (int i = 0; i < listStores.size() - 1; i++) {
					for (int j = i + 1; j < listStores.size(); j++) {
						if (listStores.get(j).getMember().getId() == listStores.get(i).getMember().getId()
								&& listStores.get(j).getBook().getId() == listStores.get(i).getBook().getId()) {
							listStores.remove(j);
						}
					}
				}

				List<BookDTO> listBookDTOs = new ArrayList<BookDTO>();

				for (Store store : listStores) {
					Book book = bookDao.getBookById(store.getBook().getId());
					BookDTO bookDTO = bookTransformer.convertToDTO(book);
					listBookDTOs.add(bookDTO);
				}

				for (BookDTO dto : listBookDTOs) {
					String sourceDir = dto.getPdfLocate();
					File sourceFile = new File(sourceDir);

					byte[] imageByteArray = null;

					if (sourceFile.exists()) {
						PDDocument document = PDDocument.load(sourceDir);

						PDPage firstPage = (PDPage) document.getDocumentCatalog().getAllPages().get(0);

						BufferedImage image = firstPage.convertToImage();

						ByteArrayOutputStream bao = new ByteArrayOutputStream();

						ImageIO.write(image, "jpg", bao);

						imageByteArray = bao.toByteArray();

						bao.close();

						document.close();

						dto.setImage(imageByteArray);
					} else {
						System.err.println(sourceFile.getName() + "--> File does not exist");
					}
				}

				LOGGER.info("End getAllPurchasedBook with result: " + listBookDTOs);

				return listBookDTOs;
			}

		} catch (Exception e) {
			LOGGER.error("BookStoreServiceImpl error: " + e.getMessage());
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pharos.service.BookStoreService#redownloadPurchasedBook_UninstalledApp(
	 * int)
	 */
	@Override
	public byte[] readBook(int bookId) throws BusinessException {

		LOGGER.info("Begin readBook_Service with bookId: " + bookId);

		try {
			Book book = bookDao.getBookById(bookId);

			if (book != null) {
				BookDTO dto = bookTransformer.convertToDTO(book);

				String pdfUrl = dto.getPdfLocate();

				byte[] buffer = new byte[8192];

				File pdfFile = new File(pdfUrl);

				if (pdfFile.exists()) {

					boolean success = true;

					FileInputStream fis = new FileInputStream(pdfFile);

					ByteArrayOutputStream baos = new ByteArrayOutputStream();

					for (int readNum; (readNum = fis.read(buffer)) != -1;) {
						baos.write(buffer, 0, readNum);
					}

					byte[] bytes = baos.toByteArray();

					LOGGER.info("End readBook_Service with result: " + bytes);

					return bytes;
				} else {
					LOGGER.error(pdfFile.getName() + " does not exist !");
				}
			}
		} catch (Exception e) {
			LOGGER.error("BookStoreServiceImpl error: " + e.getMessage());
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pharos.service.BookStoreService#searchByTitle(java.lang.String)
	 */
	@Override
	public List<BookDTO> searchByTitle(String title) throws BusinessException {

		LOGGER.info("Begin searchByTitle with title: " + title);

		try {

			List<BookDTO> listBookDTOs = new ArrayList<BookDTO>();
			List<Book> listBooks = bookDao.searchByTitle(title);

			byte[] array = null;

			if (listBooks != null) {
				for (Book book : listBooks) {
					BookDTO dto = bookTransformer.convertToDTO(book);

					String sourceDir = book.getPdf();
					File sourceFile = new File(sourceDir);

					if (sourceFile.exists()) {
						PDDocument document = PDDocument.load(sourceDir);

						PDPage firstPage = (PDPage) document.getDocumentCatalog().getAllPages().get(0);

						BufferedImage image = firstPage.convertToImage();

						ByteArrayOutputStream bao = new ByteArrayOutputStream();

						ImageIO.write(image, "jpg", bao);

						array = bao.toByteArray();

						bao.close();

						document.close();

						dto.setImage(array);
					} else {
						System.err.println(sourceFile.getName() + "--> File does not exist");
					}

					listBookDTOs.add(dto);
				}

				LOGGER.info("End searchByTitle with result: " + listBookDTOs);

				return listBookDTOs;
			}

		} catch (Exception e) {
			LOGGER.error("BookStoreServiceImpl error: " + e.getMessage());
		}

		return null;
	}

}
