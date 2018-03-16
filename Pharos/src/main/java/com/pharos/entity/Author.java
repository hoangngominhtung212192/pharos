package com.pharos.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the author database table.
 * 
 */
@Entity
@NamedQuery(name="Author.findAll", query="SELECT a FROM Author a")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String avatar;

	private String backCardImg;

	private int cardNo;

	private String email;

	private String frontCardImg;

	private String motto;

	private String name;

	private String tel;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="accountID")
	private Account account;

	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="author")
	private List<Book> books;

	public Author() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getBackCardImg() {
		return this.backCardImg;
	}

	public void setBackCardImg(String backCardImg) {
		this.backCardImg = backCardImg;
	}

	public int getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFrontCardImg() {
		return this.frontCardImg;
	}

	public void setFrontCardImg(String frontCardImg) {
		this.frontCardImg = frontCardImg;
	}

	public String getMotto() {
		return this.motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setAuthor(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setAuthor(null);

		return book;
	}

}