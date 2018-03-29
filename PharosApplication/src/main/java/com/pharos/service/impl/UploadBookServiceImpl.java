package com.pharos.service.impl;

import com.pharos.dto.BookDTO;

import com.pharos.service.UploadBookService;

import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@Transactional
public class UploadBookServiceImpl implements UploadBookService {

	private final static String BOOKS_FOLDER = "books";
	private final static String CARD_IMAGE_FOLDER = "upload";

	@Override
	public void uploadBook(BookDTO newBook) {
		// TODO Auto-generated method stub

	}

	@Override
	public String saveBook(MultipartFile file, int saveType, HttpServletRequest request) {

		String uploadRootPath = "";

		String filename = null;

		if (file.isEmpty()) {
		} else {
			switch (saveType) {
			case 1:
				uploadRootPath = request.getServletContext().getRealPath(BOOKS_FOLDER);
				break;
			case 2:
				uploadRootPath= request.getServletContext().getRealPath(CARD_IMAGE_FOLDER);
				break;
			default:
				break;
			}
			
			File uploadRootDir = new File(uploadRootPath);
			// Tạo thư mục gốc upload nếu nó không tồn tại.
			if (!uploadRootDir.exists()) {
				uploadRootDir.mkdirs();
			}

			try {
				// Get the file and save it somewhere
				byte[] bytes = file.getBytes();
				filename = uploadRootPath + "/" + file.getOriginalFilename();
				
				Path path = Paths.get(filename);
				Files.write(path, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return filename;
	}
}
