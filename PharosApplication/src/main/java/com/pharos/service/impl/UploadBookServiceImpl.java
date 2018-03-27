package com.pharos.service.impl;

import com.pharos.dto.BookDTO;

import com.pharos.service.UploadBookService;

import java.io.IOException;
import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@Transactional
public class UploadBookServiceImpl implements UploadBookService {


	private final static String BOOKS_FOLDER = "C:/books/";
	private final static String CARD_IMAGE_FOLDER = "C:/cardImage/";

	@Override
	public void uploadBook(BookDTO newBook) {
		// TODO Auto-generated method stub

	}

	@Override
	public String saveBook(MultipartFile file, int saveType) {
		String filename = null;
		String locate="";
		if (file.isEmpty()) {
		} else {
			switch (saveType) {
			case 1:
				locate = BOOKS_FOLDER;
				break;
			case 2:
				locate = CARD_IMAGE_FOLDER;
				break;
			default:
				break;
			}

			try {
				// Get the file and save it somewhere
				byte[] bytes = file.getBytes();
				filename = locate + file.getOriginalFilename();
				Path path = Paths.get(filename);
				Files.write(path, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        
		return filename;
	}
}
