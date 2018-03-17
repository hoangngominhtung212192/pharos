/**
 * 
 */
package com.pharos.transformer;

import com.pharos.dto.BookDTO;
import com.pharos.entity.Book;

/**
 * @author Tung Hoang Ngo Minh
 *
 */
public interface BookTransformer {
	BookDTO convertToDTO(Book book);
	
	Book convertToEntity(BookDTO dto);
}
