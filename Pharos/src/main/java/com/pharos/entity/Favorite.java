package com.pharos.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the favorite database table.
 * 
 */
@Entity
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f")
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="bookID")
	private Book book;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="memberID")
	private Member member;

	public Favorite() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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