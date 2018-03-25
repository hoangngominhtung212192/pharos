package com.pharos.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public interface AuthorService {
	boolean checkEmail(String email);
}
