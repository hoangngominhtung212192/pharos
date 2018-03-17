/**
 * 
 */
package com.pharos.dto;

import java.util.Date;

/**
 * @author Tung Hoang Ngo Minh
 *
 */
public class TransactionDTO {
	int id;
	int memberId;
	int bookId;
	Date purchasedDate;
	float difference;		
	
	public TransactionDTO(int id, int memberId, int bookId, Date purchasedDate, float difference) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.bookId = bookId;
		this.purchasedDate = purchasedDate;
		this.difference = difference;
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
	/**
	 * @return the difference
	 */
	public float getDifference() {
		return difference;
	}
	/**
	 * @param difference the difference to set
	 */
	public void setDifference(float difference) {
		this.difference = difference;
	}
	
	
}
