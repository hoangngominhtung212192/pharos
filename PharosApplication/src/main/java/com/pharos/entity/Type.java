package com.pharos.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type database table.
 * 
 */
@Entity
@NamedQuery(name="Type.findAll", query="SELECT t FROM Type t")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Booktype
	@OneToMany(mappedBy="type")
	private List<Booktype> booktypes;

	public Type() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Booktype> getBooktypes() {
		return this.booktypes;
	}

	public void setBooktypes(List<Booktype> booktypes) {
		this.booktypes = booktypes;
	}

	public Booktype addBooktype(Booktype booktype) {
		getBooktypes().add(booktype);
		booktype.setType(this);

		return booktype;
	}

	public Booktype removeBooktype(Booktype booktype) {
		getBooktypes().remove(booktype);
		booktype.setType(null);

		return booktype;
	}

}