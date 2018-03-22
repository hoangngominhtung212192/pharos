/**
 * 
 */
package com.pharos.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharos.dto.BookDTO;
import com.pharos.entity.Book;
import com.pharos.exception.BusinessException;
import com.pharos.repository.BookDao;
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
						} else {
							System.err.println(sourceFile.getName() + "--> File does not exist");
						}

						BookDTO dto = bookTransformer.convertToDTO(book);
						dto.setImage(array);

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

}
