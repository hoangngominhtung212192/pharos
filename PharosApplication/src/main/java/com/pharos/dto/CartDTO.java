/**
 * 
 */
package com.pharos.dto;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

public class CartDTO {
	byte[] pdf;
	boolean status;
	int bookId;
	
	public CartDTO(byte[] pdf, boolean status, int bookId) {
		super();
		this.pdf = pdf;
		this.status = status;
		this.bookId = bookId;
	}

	/**
	 * @return the pdf
	 */
	public byte[] getPdf() {
		return pdf;
	}

	/**
	 * @param pdf the pdf to set
	 */
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
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
