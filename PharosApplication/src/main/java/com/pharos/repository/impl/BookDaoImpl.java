/**
 * 
 */
package com.pharos.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pharos.entity.Book;
import com.pharos.repository.BookDao;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Repository
public class BookDaoImpl extends GenericDaoImpl<Book, Integer> implements BookDao {

	/* (non-Javadoc)
	 * @see com.pharos.repository.BookDao#getAllBooks()
	 */
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
