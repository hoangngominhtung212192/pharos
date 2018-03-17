/**
 * 
 */
package com.pharos.dto;

/**
 * @author Tung Hoang Ngo Minh
 *
 */
public class FavoriteDTO {
	int id;
	int memberId;
	int bookId;
	
	public FavoriteDTO(int memberId, int bookId) {
		super();
		this.memberId = memberId;
		this.bookId = bookId;
	}
	
	public FavoriteDTO(int id, int memberId, int bookId) {
		super();
		this.id = id;
		this.memberId = memberId;
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
	 * @return the memberId
	 */
	public int getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
