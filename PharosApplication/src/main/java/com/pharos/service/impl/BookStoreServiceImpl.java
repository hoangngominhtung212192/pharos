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
import com.sun.mail.iap.ByteArray;

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
		// String sourceDir = "C:/Users/Tung Hoang Ngo Minh/Downloads/pdf/Vo
		// Han Tuong Lai - Zhttty.pdf";
		// String destinationDir = "C:/Users/Tung Hoang Ngo
		// Minh/Documents/Image/";
		// File sourceFile = new File(sourceDir);
		// File destinationFile = new File(destinationDir);
		// if (!destinationFile.exists()) {
		// destinationFile.mkdir();
		// System.out.println("Folder Created -> " +
		// destinationFile.getAbsolutePath());
		// }
		// if (sourceFile.exists()) {
		// PDDocument document = PDDocument.load(sourceDir);
		// @SuppressWarnings("unchecked")
		// List<PDPage> list = document.getDocumentCatalog().getAllPages();
		//
		// String fileName = sourceFile.getName().replace(".pdf", "");
		// int pageNumber = 1;
		// for (PDPage page : list) {
		// BufferedImage image = page.convertToImage();
		// File outputfile = new File(destinationDir + fileName + "_" +
		// pageNumber + ".png");
		// ImageIO.write(image, "png", outputfile);
		// pageNumber++;
		// }
		// document.close();
		// System.out.println("Image saved at -> " +
		// destinationFile.getAbsolutePath());
		// } else {
		// System.err.println(sourceFile.getName() + " File does not
		// exist");
		// }
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
							
							document.close();
						} else {
							System.err.println(sourceFile.getName() + " File does not exist");
						}

						BookDTO dto = bookTransformer.convertToDTO(book);
						dto.setImage(array);
						
						listBookDTO.add(dto);
					}
				}

				return listBookDTO;
			}
		} catch (

		Exception e) {

		}

		return null;
	}

}
