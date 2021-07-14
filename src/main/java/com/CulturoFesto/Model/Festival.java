package com.CulturoFesto.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Festival")
public class Festival implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Festival_id")
	private String festivalId;

	@Column(name = "Festival_Name")
	private String festivalName;

	@Column(name = "Festival_Region")
	private String festivalRegion;
	@Column(name = "Festival_Venue")
	private String festivalVenue;

	@Column(name = "Festival_Amount_Adult")
	private long festivalAmountAdult;

	@Column(name = "Festival_Amount_Children")
	private long festivalAmountChildren;

	@Column(name = "Festival_Date")
	private String festivalDate;



	@Column(name = "Festival_Food")
	private String fooditem;


	@Column(name = "Festival_FoodPrice_Adult")
	private long foodPriceAdult;

	@Column(name = "Festival_FoodPrice_Children")
	private long foodPriceChildren;


	public Festival() {
	}


	public Festival(String festivalId, String festivalName, String festivalRegion, String festivalVenue,
			long festivalAmountAdult, long festivalAmountChildren, String festivalDate, String fooditem,
			long foodPriceAdult, long foodPriceChildren) {
		super();
		this.festivalId = festivalId;
		this.festivalName = festivalName;
		this.festivalRegion = festivalRegion;
		this.festivalVenue = festivalVenue;
		this.festivalAmountAdult = festivalAmountAdult;
		this.festivalAmountChildren = festivalAmountChildren;
		this.festivalDate = festivalDate;
		this.fooditem = fooditem;
		this.foodPriceAdult = foodPriceAdult;
		this.foodPriceChildren = foodPriceChildren;
	}


	public String getFestivalId() {
		return festivalId;
	}


	public void setFestivalId(String festivalId) {
		this.festivalId = festivalId;
	}


	public String getFestivalName() {
		return festivalName;
	}


	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}


	public String getFestivalRegion() {
		return festivalRegion;
	}


	public void setFestivalRegion(String festivalRegion) {
		this.festivalRegion = festivalRegion;
	}


	public String getFestivalVenue() {
		return festivalVenue;
	}


	public void setFestivalVenue(String festivalVenue) {
		this.festivalVenue = festivalVenue;
	}


	public long getFestivalAmountAdult() {
		return festivalAmountAdult;
	}


	public void setFestivalAmountAdult(long festivalAmountAdult) {
		this.festivalAmountAdult = festivalAmountAdult;
	}


	public long getFestivalAmountChildren() {
		return festivalAmountChildren;
	}


	public void setFestivalAmountChildren(long festivalAmountChildren) {
		this.festivalAmountChildren = festivalAmountChildren;
	}


	public String getFestivalDate() {
		return festivalDate;
	}


	public void setFestivalDate(String festivalDate) {
		this.festivalDate = festivalDate;
	}


	public String getFooditem() {
		return fooditem;
	}


	public void setFooditem(String fooditem) {
		this.fooditem = fooditem;
	}


	public long getFoodPriceAdult() {
		return foodPriceAdult;
	}


	public void setFoodPriceAdult(long foodPriceAdult) {
		this.foodPriceAdult = foodPriceAdult;
	}


	public long getFoodPriceChildren() {
		return foodPriceChildren;
	}


	public void setFoodPriceChildren(long foodPriceChildren) {
		this.foodPriceChildren = foodPriceChildren;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Festival [festivalId=" + festivalId + ", festivalName=" + festivalName + ", festivalRegion="
				+ festivalRegion + ", festivalVenue=" + festivalVenue + ", festivalAmountAdult=" + festivalAmountAdult
				+ ", festivalAmountChildren=" + festivalAmountChildren + ", festivalDate=" + festivalDate
				+ ", fooditem=" + fooditem + ", foodPriceAdult=" + foodPriceAdult + ", foodPriceChildren="
				+ foodPriceChildren + "]";
	}


}
