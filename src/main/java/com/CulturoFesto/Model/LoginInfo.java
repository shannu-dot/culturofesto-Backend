package com.CulturoFesto.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class LoginInfo {
	
	@Id
	private String gnUid;
	private String gnPassword;
	public String getGnUid() {
		return gnUid;
	}
	public void setGnUid(String gnUid) {
		this.gnUid = gnUid;
	}
	public String getGnPassword() {
		return gnPassword;
	}
	public void setGnPassword(String gnPassword) {
		this.gnPassword = gnPassword;
	}
	public LoginInfo(String gnUid, String gnPassword) {
		super();
		this.gnUid = gnUid;
		this.gnPassword = gnPassword;
	}
	public LoginInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}