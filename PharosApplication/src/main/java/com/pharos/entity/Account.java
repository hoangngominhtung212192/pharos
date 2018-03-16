package com.pharos.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte enable;

	private String password;

	private String username;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="roleID")
	private Role role;

	//bi-directional many-to-one association to Author
	@OneToMany(mappedBy="account")
	private List<Author> authors;

	//bi-directional many-to-one association to Member
	@OneToMany(mappedBy="account")
	private List<Member> members;

	public Account() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Author addAuthor(Author author) {
		getAuthors().add(author);
		author.setAccount(this);

		return author;
	}

	public Author removeAuthor(Author author) {
		getAuthors().remove(author);
		author.setAccount(null);

		return author;
	}

	public List<Member> getMembers() {
		return this.members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Member addMember(Member member) {
		getMembers().add(member);
		member.setAccount(this);

		return member;
	}

	public Member removeMember(Member member) {
		getMembers().remove(member);
		member.setAccount(null);

		return member;
	}

}