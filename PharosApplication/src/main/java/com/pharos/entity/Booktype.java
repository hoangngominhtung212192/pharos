package com.pharos.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the booktype database table.
 * 
 */
@Entity
@NamedQuery(name="Booktype.findAll", query="SELECT b FROM Booktype b")
public class Booktype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="bookID")
	private Book book;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="typeID")
	private Type type;

	public Booktype() {
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

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}