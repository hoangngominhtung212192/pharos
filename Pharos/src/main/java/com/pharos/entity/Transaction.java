package com.pharos.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private float difference;

	@Temporal(TemporalType.TIMESTAMP)
	private Date purchasedDate;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="bookID")
	private Book book;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="memberID")
	private Member member;

	public Transaction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getDifference() {
		return this.difference;
	}

	public void setDifference(float difference) {
		this.difference = difference;
	}

	public Date getPurchasedDate() {
		return this.purchasedDate;
	}

	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}