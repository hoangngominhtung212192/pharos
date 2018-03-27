package com.pharos.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pharos.dto.AuthorDTO;
import com.pharos.entity.Author;

@Service
@Transactional
public interface AuthorService {
	
	boolean checkEmail(String email);
	
	public int createAuthor(AuthorDTO authorDTO);
}
