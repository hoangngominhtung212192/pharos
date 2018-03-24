package com.pharos.repository;

import org.springframework.stereotype.Repository;

import com.pharos.entity.Author;

@Repository
public interface AuthorDao extends GenericDao<Author, Integer> {
	
	boolean checkExistEmail(String email);
}
