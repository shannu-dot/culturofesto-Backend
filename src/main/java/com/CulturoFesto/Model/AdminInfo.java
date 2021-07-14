package com.CulturoFesto.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.print.event.PrintJobAttributeEvent;

@Entity
public class AdminInfo {
 
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String adminPassword;
	private String adminUsername;
	
	public AdminInfo() {
		super();
	}
	
	public AdminInfo(String id, String firstName, String lastName, String adminPassword, String adminUsername) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adminPassword = adminPassword;
		this.adminUsername = adminUsername;
	}

	public AdminInfo(String adminPassword, String adminUsername) {
		super();
		this.adminPassword = adminPassword;
		this.adminUsername = adminUsername;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	
	
	
	
	
}