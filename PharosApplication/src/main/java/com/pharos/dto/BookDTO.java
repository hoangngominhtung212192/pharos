package com.pharos.dto;

import java.util.Date;

public class BookDTO {
	int id;
	String tiltle;
	String description;
	int viewCount;
	float price;
	int voteCount;
	int statusId;
	int languageId;
	String pdfLocate;
	Date publishDate;

	public BookDTO(String tiltle, String description, int viewCount, float price, int voteCount, int statusId,
			int languageId, String pdfLocate, Date publishDate) {
		super();
		this.tiltle = tiltle;
		this.description = description;
		this.viewCount = viewCount;
		this.price = price;
		this.voteCount = voteCount;
		this.statusId = statusId;
		this.languageId = languageId;
		this.pdfLocate = pdfLocate;
		this.publishDate = publishDate;
	}
	
	public BookDTO(int id, String tiltle, String description, int viewCount, float price, int voteCount, int statusId,
			int languageId, String pdfLocate, Date publishDate) {
		super();
		this.id = id;
		this.tiltle = tiltle;
		this.description = description;
		this.viewCount = viewCount;
		this.price = price;
		this.voteCount = voteCount;
		this.statusId = statusId;
		this.languageId = languageId;
		this.pdfLocate = pdfLocate;
		this.publishDate = publishDate;
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
	
	public String getTiltle() {
		return tiltle;
	}

	public void setTiltle(String tiltle) {
		this.tiltle = tiltle;
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

}
