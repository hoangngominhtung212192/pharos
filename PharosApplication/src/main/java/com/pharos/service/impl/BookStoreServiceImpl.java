/**
 * 
 */
package com.pharos.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.stereotype.Service;

import com.pharos.service.BookStoreService;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
public class BookStoreServiceImpl implements BookStoreService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pharos.service.BookStoreService#test()
	 */
	@Override
	public void test() {
		try {
			String sourceDir = "C:/Users/Tung Hoang Ngo Minh/Downloads/pdf/Vo Han Tuong Lai - Zhttty.pdf";
			String destinationDir = "C:/Users/Tung Hoang Ngo Minh/Documents/Image/";
			File sourceFile = new File(sourceDir);
			File destinationFile = new File(destinationDir);
			if (!destinationFile.exists()) {
				destinationFile.mkdir();
				System.out.println("Folder Created -> " + destinationFile.getAbsolutePath());
			}
			if (sourceFile.exists()) {
				PDDocument document = PDDocument.load(sourceDir);
				@SuppressWarnings("unchecked")
				List<PDPage> list = document.getDocumentCatalog().getAllPages();
 
				String fileName = sourceFile.getName().replace(".pdf", "");
				int pageNumber = 1;
				for (PDPage page : list) {
					BufferedImage image = page.convertToImage();
					File outputfile = new File(destinationDir + fileName + "_" + pageNumber + ".png");
					ImageIO.write(image, "png", outputfile);
					pageNumber++;
				}
				document.close();
				System.out.println("Image saved at -> " + destinationFile.getAbsolutePath());
			} else {
				System.err.println(sourceFile.getName() + " File does not exist");
			}
		} catch (Exception e) {

		}

	}

}
