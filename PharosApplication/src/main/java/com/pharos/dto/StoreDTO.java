/**
 * 
 */
package com.pharos.dto;

import java.util.Date;

/**
 * @author Tung Hoang Ngo Minh
 *
 */
public class StoreDTO {
	int id;
	int memberId;
	int bookId;
	String description;
	Date purchasedDate;	
	
	public StoreDTO(int id, int memberId, int bookId, String description, Date purchasedDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.bookId = bookId;
		this.description = description;
		this.purchasedDate = purchasedDate;
	}
	
	public StoreDTO(int memberId, int bookId, String description, Date purchasedDate) {
		super();
		this.memberId = memberId;
		this.bookId = bookId;
		this.description = description;
		this.purchasedDate = purchasedDate;
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
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the purchasedDate
	 */
	public Date getPurchasedDate() {
		return purchasedDate;
	}
	/**
	 * @param purchasedDate the purchasedDate to set
	 */
	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	
	
}
