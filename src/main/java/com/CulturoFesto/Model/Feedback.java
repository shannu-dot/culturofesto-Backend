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
import javax.validation.constraints.NotBlank;

@Entity
@Table(name ="Feedback")
public class Feedback implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="Feedback_id")
	private String feedbackId;
	
	@NotBlank(message="Ratings is mandatory")
	@Column(name ="ratings")
	private String ratings;
	
	@NotBlank(message="Comments is mandatory")
	@Column(name ="comment")
	private String comment;

	@ManyToOne(optional=false)
	@JoinColumn(name="Registration_Id", updatable=false)
	private Registration registration;
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Feedback(String feedbackId, @NotBlank(message = "Ratings is mandatory") String ratings,
			@NotBlank(message = "Comments is mandatory") String comment, Registration registration) {
		super();
		this.feedbackId = feedbackId;
		this.ratings = ratings;
		this.comment = comment;
		this.registration = registration;
	}



	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feedbackId == null) ? 0 : feedbackId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		if (feedbackId == null) {
			if (other.feedbackId != null)
				return false;
		} else if (!feedbackId.equals(other.feedbackId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", ratings=" + ratings + ", comment=" + comment
				+ ", registration=" + registration + "]";
	}

	

}
