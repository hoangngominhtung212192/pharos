/**
 * 
 */
package com.pharos.dto;

/**
 * @author Tung Hoang Ngo Minh
 *
 */
public class BookTypeDTO {
	int id;
	int typeId;
	int bookId;
	
	public BookTypeDTO(int id, int typeId, int bookId) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.bookId = bookId;
	}

	public BookTypeDTO(int typeId, int bookId) {
		super();
		this.typeId = typeId;
		this.bookId = bookId;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the typeId
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	
}
