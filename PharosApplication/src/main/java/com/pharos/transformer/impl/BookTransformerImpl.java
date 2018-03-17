/**
 * 
 */
package com.pharos.transformer.impl;

import com.pharos.dto.BookDTO;
import com.pharos.entity.Book;
import com.pharos.transformer.BookTransformer;

/**
 * @author Tung Hoang Ngo Minh
 *
 */
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
			dto.setTiltle(book.getTitle());
			dto.setDescription(book.getDescription());
			dto.setViewCount(book.getViewCount());
			dto.setPrice(book.getPrice());
			dto.setLanguageId(book.getLanguage().getId());
			dto.setStatusId(book.getStatus().getId());
			dto.setVoteCount(book.getVoteCount());
			
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pharos.transformer.BookTransformer#convertToEntity(com.pharos.dto.BookDTO)
	 */
	@Override
	public Book convertToEntity(BookDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
