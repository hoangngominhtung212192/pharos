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

	private int bookID;

	private int typeID;

	public Booktype() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookID() {
		return this.bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public int getTypeID() {
		return this.typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

}