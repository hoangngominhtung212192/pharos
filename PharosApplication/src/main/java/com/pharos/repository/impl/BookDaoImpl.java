/**
 * 
 */
package com.pharos.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.pharos.entity.Book;
import com.pharos.entity.Store;
import com.pharos.repository.BookDao;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@Repository
public class BookDaoImpl extends GenericDaoImpl<Book, Integer> implements BookDao {

	private static final Logger LOGGER = LogManager.getLogger(BookDaoImpl.class);

	public BookDaoImpl() {
		super(Book.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pharos.repository.BookDao#getAllBooks()
	 */
	@Override
	public List<Book> getAllBooks(int memberId) {

		LOGGER.info("Begin getAllBooks with memberId: " + memberId);

		List<Book> listBooks = new ArrayList<Book>();

		String sql = "SELECT b FROM " + Book.class.getName() + " AS b WHERE b.status.id = 1"
				+ " AND b.id NOT IN (SELECT s.book.id FROM " + Store.class.getName()
				+ " AS s WHERE s.member.id =:memberId)";

		Query query = this.entitymanager.createQuery(sql);
		query.setParameter("memberId", memberId);

		listBooks = query.getResultList();

		LOGGER.info("End getAllBooks with result: " + listBooks);

		return listBooks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pharos.repository.BookDao#getBookById(int)
	 */
	@Override
	public Book getBookById(int bookId) {

		LOGGER.info("Begin getBookById with bookId: " + bookId);

		Book book = null;

		book = this.read(bookId);

		LOGGER.info("End getBookById with result: " + book);

		return book;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pharos.repository.BookDao#searchByTitle(java.lang.String)
	 */
	@Override
	public List<Book> searchByTitle(String title) {

		LOGGER.info("Begin searchByTitle with title: " + title);

		List<Book> listBooks = new ArrayList<Book>();

		String sql = "SELECT b FROM " + Book.class.getName() + " AS b WHERE b.title LIKE '%" + title + "%' AND "
				+ "b.status.id=1";

		Query query = this.entitymanager.createQuery(sql);

		listBooks = query.getResultList();

		LOGGER.info("End searchByTitle with result: " + listBooks);

		return listBooks;
	}

	@Override
	public List<Book> getAllBooksByAuthorId(int authorId) {

		LOGGER.info("Begin getAllBooksByAuthorId with authorId: " + authorId);

		List<Book> listBooks = new ArrayList<Book>();

		String sql = "SELECT b FROM " + Book.class.getName() + " AS b WHERE b.author.id =:authorId AND "
				+ "b.status.id=1";

		Query query = this.entitymanager.createQuery(sql);
		query.setParameter("authorId", authorId);
		
		listBooks = query.getResultList();

		LOGGER.info("End searchByTitle with result: " + listBooks);

		return listBooks;
	}

}
