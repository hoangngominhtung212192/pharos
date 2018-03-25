/**
 * 
 */
package com.pharos.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pharos.entity.Book;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Repository
public interface BookDao extends GenericDao<Book, Integer> {
	
	/**
	 * 
	 * @return
	 */
	List<Book> getAllBooks(int memberId);
	
	/**
	 * 
	 * @param bookId
	 * @return
	 */
	Book getBookById(int bookId);
	
	/**
	 * 
	 * @param title
	 * @return
	 */
	List<Book> searchByTitle(String title);
}
