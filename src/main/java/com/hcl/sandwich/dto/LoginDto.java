package com.hcl.sandwich.dto;

import java.io.Serializable;

public class LoginDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String uName;
	private String password;
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}