package com.pharos.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String pdf;

	private float price;

	@Temporal(TemporalType.TIMESTAMP)
	private Date publishedDate;

	private String title;

	private int viewCount;

	private int voteCount;

	//bi-directional many-to-one association to Author
	@ManyToOne
	@JoinColumn(name="publisherID")
	private Author author;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="languageID")
	private Language language;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="statusID")
	private Status status;

	//bi-directional many-to-one association to Booktype
	@OneToMany(mappedBy="book")
	private List<Booktype> booktypes;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="book")
	private List<Favorite> favorites;

	//bi-directional many-to-one association to Store
	@OneToMany(mappedBy="book")
	private List<Store> stores;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="book")
	private List<Transaction> transactions;

	public Book() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPdf() {
		return this.pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getPublishedDate() {
		return this.publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getVoteCount() {
		return this.voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Booktype> getBooktypes() {
		return this.booktypes;
	}

	public void setBooktypes(List<Booktype> booktypes) {
		this.booktypes = booktypes;
	}

	public Booktype addBooktype(Booktype booktype) {
		getBooktypes().add(booktype);
		booktype.setBook(this);

		return booktype;
	}

	public Booktype removeBooktype(Booktype booktype) {
		getBooktypes().remove(booktype);
		booktype.setBook(null);

		return booktype;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setBook(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setBook(null);

		return favorite;
	}

	public List<Store> getStores() {
		return this.stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public Store addStore(Store store) {
		getStores().add(store);
		store.setBook(this);

		return store;
	}

	public Store removeStore(Store store) {
		getStores().remove(store);
		store.setBook(null);

		return store;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setBook(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setBook(null);

		return transaction;
	}

}