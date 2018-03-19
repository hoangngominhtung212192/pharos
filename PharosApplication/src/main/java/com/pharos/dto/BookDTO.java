package com.pharos.dto;

import java.awt.image.BufferedImage;
import java.util.Date;

public class BookDTO {
	int id;
	String title;
	String description;
	int viewCount;
	float price;
	int voteCount;
	int statusId;
	int languageId;
	int authorId;
	String pdfLocate;
	Date publishDate;
	byte[] image;

	public BookDTO(String title, String description, int viewCount, float price, int voteCount, int statusId,
			int languageId, String pdfLocate, Date publishDate, int authorId) {
		super();
		this.title = title;
		this.description = description;
		this.viewCount = viewCount;
		this.price = price;
		this.voteCount = voteCount;
		this.statusId = statusId;
		this.languageId = languageId;
		this.pdfLocate = pdfLocate;
		this.publishDate = publishDate;
		this.authorId = authorId;
	}

	public BookDTO(int id, String title, String description, int viewCount, float price, int voteCount, int statusId,
			int languageId, String pdfLocate, Date publishDate, int authorId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.viewCount = viewCount;
		this.price = price;
		this.voteCount = voteCount;
		this.statusId = statusId;
		this.languageId = languageId;
		this.pdfLocate = pdfLocate;
		this.publishDate = publishDate;
		this.authorId = authorId;
	}

	public BookDTO(int id, String title, String description, int viewCount, float price, int voteCount, int statusId,
			int languageId, String pdfLocate, Date publishDate, byte[] image, int authorId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.viewCount = viewCount;
		this.price = price;
		this.voteCount = voteCount;
		this.statusId = statusId;
		this.languageId = languageId;
		this.pdfLocate = pdfLocate;
		this.publishDate = publishDate;
		this.image = image;
		this.authorId = authorId;
	}
	
	/**
	 * 
	 */
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getPdfLocate() {
		return pdfLocate;
	}

	public void setPdfLocate(String pdfLocate) {
		this.pdfLocate = pdfLocate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * @return the authorId
	 */
	public int getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	
}
