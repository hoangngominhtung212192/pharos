/**
 * 
 */
package com.pharos.dto;

/**
 * @author Tung Hoang Ngo Minh
 *
 */
public class AccountDTO {
	int id;
	String username;
	String password;
	int roleId;
	boolean enable;
	
	public AccountDTO(int id, String username, String password, int roleId, boolean enable) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.enable = enable;
	}
	
	public AccountDTO(String username, String password, int roleId, boolean enable) {
		super();
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.enable = enable;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the enable
	 */
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	
}
