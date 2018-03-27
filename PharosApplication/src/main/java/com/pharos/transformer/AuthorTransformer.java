package com.pharos.transformer;

import org.springframework.stereotype.Service;

import com.pharos.dto.AuthorDTO;
import com.pharos.entity.Author;

@Service
public interface AuthorTransformer {
	public AuthorDTO convertDataToAuthorDto(String data);
	
	public Author convertDtoToEntity(AuthorDTO authorDto);
	
	public AuthorDTO convertToDto(Author author);
}
