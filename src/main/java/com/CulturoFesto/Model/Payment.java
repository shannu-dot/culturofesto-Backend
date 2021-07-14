package com.CulturoFesto.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="payment")
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="paymentId")
	private int paymentid;
	@Column(name="CustomerFname")
	private String customerfname;
	@Column(name="CustomerLname")
	private String customerlname;
	@Column(name="CustomerMail")
	private String customermail;
	@Column(name="CustomerAddress")
	private String customeraddress;
	@Column(name="CustomerPno")
	private long customerpno;
	
	
	//@OneToMany(mappedBy="payment",cascade = CascadeType.ALL)
	@JsonIgnore
    //private List<Registration> registration;
	
	/*@OneToMany(targetEntity = Movies.class,mappedBy="payment",orphanRemoval = false, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Registration> registration;
	

	//@OneToMany(targetEntity = Seats.class,mappedBy="payment",cascade = CascadeType.ALL,orphanRemoval = false, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Registration> registration;*/
	
	public Payment() {
		super();
	}

	
	public Payment(int paymentid, String customerfname, String customerlname, String customermail,
			String customeraddress, long customerpno) {
		super();
		this.paymentid = paymentid;
		this.customerfname = customerfname;
		this.customerlname = customerlname;
		this.customermail = customermail;
		this.customeraddress = customeraddress;
		this.customerpno = customerpno;
	}


	public int getPaymentid() {
		return paymentid;
	}


	public String getCustomerfname() {
		return customerfname;
	}


	public String getCustomerlname() {
		return customerlname;
	}


	public String getCustomermail() {
		return customermail;
	}


	public String getCustomeraddress() {
		return customeraddress;
	}


	public long getCustomerpno() {
		return customerpno;
	}


	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}


	public void setCustomerfname(String customerfname) {
		this.customerfname = customerfname;
	}


	public void setCustomerlname(String customerlname) {
		this.customerlname = customerlname;
	}


	public void setCustomermail(String customermail) {
		this.customermail = customermail;
	}


	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}


	public void setCustomerpno(long customerpno) {
		this.customerpno = customerpno;
	}


	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", customerfname=" + customerfname + ", customerlname="
				+ customerlname + ", customermail=" + customermail + ", customeraddress=" + customeraddress
				+ ", customerpno=" + customerpno + "]";
	}

   

}