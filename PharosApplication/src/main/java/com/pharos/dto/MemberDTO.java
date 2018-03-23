/**
 * 
 */
package com.pharos.dto;

import java.util.Date;

/**
 * @author Tung Hoang Ngo Minh
 *
 */
public class MemberDTO {
	int id;
	int accountId;
	String fullname;
	Date birthdate;
	String email;
	String avatar;
	String address;
	float money;
	String tel;
	
	
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(int id, int accountId, String fullname, Date birthdate, String email, String avatar,
			String address, float money, String tel) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.fullname = fullname;
		this.birthdate = birthdate;
		this.email = email;
		this.avatar = avatar;
		this.address = address;
		this.money = money;
		this.tel = tel;
	}
	
	public MemberDTO(int accountId, String fullname, Date birthdate, String email, String avatar,
			String address, float money, String tel) {
		super();
		this.accountId = accountId;
		this.fullname = fullname;
		this.birthdate = birthdate;
		this.email = email;
		this.avatar = avatar;
		this.address = address;
		this.money = money;
		this.tel = tel;
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
	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}
	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the money
	 */
	public float getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(float money) {
		this.money = money;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
