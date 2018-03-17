/**
 * 
 */
package com.pharos.dto;

/**
 * @author Tung Hoang Ngo Minh
 *
 */
public class AuthorDTO {
	int id;
	int accountId;
	String name;
	String tel;
	int cardNo;
	String frontCardImg;
	String backCardImg;
	String address;
	String email;
	String avatar;
	String motto;
	
	public AuthorDTO(int id, int accountId, String name, String tel, int cardNo, String frontCardImg,
			String backCardImg, String address, String email, String avatar, String motto) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.name = name;
		this.tel = tel;
		this.cardNo = cardNo;
		this.frontCardImg = frontCardImg;
		this.backCardImg = backCardImg;
		this.address = address;
		this.email = email;
		this.avatar = avatar;
		this.motto = motto;
	}
	
	public AuthorDTO(int accountId, String name, String tel, int cardNo, String frontCardImg,
			String backCardImg, String address, String email, String avatar, String motto) {
		super();
		this.accountId = accountId;
		this.name = name;
		this.tel = tel;
		this.cardNo = cardNo;
		this.frontCardImg = frontCardImg;
		this.backCardImg = backCardImg;
		this.address = address;
		this.email = email;
		this.avatar = avatar;
		this.motto = motto;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * @return the cardNo
	 */
	public int getCardNo() {
		return cardNo;
	}

	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	/**
	 * @return the frontCardImg
	 */
	public String getFrontCardImg() {
		return frontCardImg;
	}

	/**
	 * @param frontCardImg the frontCardImg to set
	 */
	public void setFrontCardImg(String frontCardImg) {
		this.frontCardImg = frontCardImg;
	}

	/**
	 * @return the backCardImg
	 */
	public String getBackCardImg() {
		return backCardImg;
	}

	/**
	 * @param backCardImg the backCardImg to set
	 */
	public void setBackCardImg(String backCardImg) {
		this.backCardImg = backCardImg;
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
	 * @return the motto
	 */
	public String getMotto() {
		return motto;
	}

	/**
	 * @param motto the motto to set
	 */
	public void setMotto(String motto) {
		this.motto = motto;
	}
	
	
}
