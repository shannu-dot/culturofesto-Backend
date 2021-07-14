package com.CulturoFesto.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Registration")
public class Registration implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Registration_Id")
	private String registrationId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="Festival_Id", updatable=false)
	private Festival festival;
	
	private long NumberOfAdults;
	
	private long NumberOfChildren;
	
	private String festivalDate;
	
	private boolean foodOption;

	@ManyToOne(optional=false)
	@JoinColumn(name="iDp", updatable=false)
    private UserInfo userinfo;
	
	public Registration() {
		
	}

	public Registration(String registrationId, Festival festival, long numberOfAdults, long numberOfChildren,
			String festivalDate, boolean foodOption, UserInfo userinfo) {
		super();
		this.registrationId = registrationId;
		this.festival = festival;
		NumberOfAdults = numberOfAdults;
		NumberOfChildren = numberOfChildren;
		this.festivalDate = festivalDate;
		this.foodOption = foodOption;
		this.userinfo = userinfo;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public long getNumberOfAdults() {
		return NumberOfAdults;
	}

	public void setNumberOfAdults(long numberOfAdults) {
		NumberOfAdults = numberOfAdults;
	}

	public long getNumberOfChildren() {
		return NumberOfChildren;
	}

	public void setNumberOfChildren(long numberOfChildren) {
		NumberOfChildren = numberOfChildren;
	}

	public String getFestivalDate() {
		return festivalDate;
	}

	public void setFestivalDate(String festivalDate) {
		this.festivalDate = festivalDate;
	}

	public boolean isFoodOption() {
		return foodOption;
	}

	public void setFoodOption(boolean foodOption) {
		this.foodOption = foodOption;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Registration [registrationId=" + registrationId + ", festival=" + festival + ", NumberOfAdults="
				+ NumberOfAdults + ", NumberOfChildren=" + NumberOfChildren + ", festivalDate=" + festivalDate
				+ ", foodOption=" + foodOption + ", userinfo=" + userinfo + "]";
	}

	
	

}