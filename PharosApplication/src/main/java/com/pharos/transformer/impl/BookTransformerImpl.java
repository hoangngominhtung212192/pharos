/**
 * 
 */
package com.pharos.transformer.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.pharos.dto.BookDTO;
import com.pharos.entity.Author;
import com.pharos.entity.Book;
import com.pharos.entity.Language;
import com.pharos.entity.Status;
import com.pharos.transformer.BookTransformer;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
public class BookTransformerImpl implements BookTransformer {

	/* (non-Javadoc)
	 * @see com.pharos.transformer.BookTransformer#convertToDTO(com.pharos.entity.Book)
	 */
	@Override
	public BookDTO convertToDTO(Book book) {
		
		BookDTO dto = null;
		
		if (book != null) {
			dto = new BookDTO();
			dto.setId(book.getId());
			dto.setTitle(book.getTitle());
			dto.setDescription(book.getDescription());
			dto.setViewCount(book.getViewCount());
			dto.setPrice(book.getPrice());
			dto.setLanguageId(book.getLanguage().getId());
			dto.setStatusId(book.getStatus().getId());
			dto.setVoteCount(book.getVoteCount());
			dto.setAuthorId(book.getAuthor().getId());
			dto.setPdfLocate(book.getPdf());
			
			Date publishedDateUtil = (Date) book.getPublishedDate();
			dto.setPublishDate(publishedDateUtil);
			
		}
		
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.pharos.transformer.BookTransformer#convertToEntity(com.pharos.dto.BookDTO)
	 */
	@Override
	public Book convertToEntity(BookDTO dto) {
		Book book = null;
		
		if (dto != null) {
			book = new Book();
			book.setTitle(dto.getTitle());
			book.setDescription(dto.getDescription());
			book.setViewCount(dto.getViewCount());
			book.setVoteCount(dto.getVoteCount());
			book.setPrice(dto.getPrice());
			
			Language language = new Language();
			language.setId(dto.getLanguageId());
			
			book.setLanguage(language);
			
			Status status = new Status();
			status.setId(dto.getStatusId());
			
			book.setStatus(status);
			
			Author author = new Author();
			author.setId(dto.getAuthorId());
			
			book.setAuthor(author);
			book.setPdf(dto.getPdfLocate());
			book.setPublishedDate(new java.sql.Date(dto.getPublishDate().getTime()));
		}
		
		return book;
	}

	@Override
	public BookDTO convertDataToDto(String data, String pdfLocate) {
		BookDTO dto=new BookDTO();
		
		String[] info=data.split("\\|");
		
		String title=info[0];
		int typeId=Integer.parseInt(info[1]);
		float price=Float.parseFloat(info[2]);
		String description=info[3];
		int authorId=Integer.parseInt(info[4]);
		int languageId=Integer.parseInt(info[5]);
		int statusId=Integer.parseInt(info[6]);
		Date publishDate=new Date();
		
		dto.setTitle(title);
		dto.setTypeId(typeId);
		dto.setPrice(price);
		dto.setDescription(description);
		dto.setPrice(price);
		dto.setAuthorId(authorId);
		dto.setPublishDate(publishDate);
		dto.setLanguageId(languageId);
		dto.setStatusId(statusId);
		return dto;
	}

}
