/**
 * 
 */
package com.pharos.transformer;

import org.springframework.stereotype.Service;

import com.pharos.dto.BookDTO;
import com.pharos.entity.Book;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Service
public interface BookTransformer {
	BookDTO convertToDTO(Book book);
	
	Book convertToEntity(BookDTO dto);
}
