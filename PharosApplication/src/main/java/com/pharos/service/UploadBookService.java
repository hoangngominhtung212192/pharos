package com.pharos.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pharos.dto.BookDTO;

@Service
@Transactional
public interface UploadBookService {
	
	void uploadBook(BookDTO newBook);
	
	String saveBook(MultipartFile file, int saveType);
}
