package com.CulturoFesto.Model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String iDp;
	
	private String firstName ;
	
	private String lastName;

	@Column(unique=true)
	private String mobile;

	private String dob;
	
	private String gnPassword;
	
	private String gnUid;
	
	
	public UserInfo() {}
	
	public UserInfo(String iDp, String firstName, String lastName, String mobile, String dob, String gnPassword,
			String gnUid) {
		super();
		this.iDp = iDp;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.dob = dob;
		this.gnPassword = gnPassword;
		this.gnUid = gnUid;
	}



	public String getiDp() {
		return iDp;
	}

	public void setiDp(String iDp) {
		this.iDp = iDp;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getGnPassword() {
		return gnPassword;
	}

	public void setGnPassword(String gnPassword) {
		this.gnPassword = gnPassword;
	}

	public String getGnUid() {
		return gnUid;
	}

	public void setGnUid(String gnUid) {
		this.gnUid = gnUid;
	}

	@Override
	public String toString() {
		return "UserInfo [iDp=" + iDp + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", dob=" + dob + ", gnPassword=" + gnPassword + ", gnUid=" + gnUid + "]";
	}
}