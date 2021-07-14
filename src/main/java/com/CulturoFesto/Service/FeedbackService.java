package com.CulturoFesto.Service;

import java.util.List;

import com.CulturoFesto.Model.Feedback;


public interface FeedbackService {
	
	public List<Feedback> getAllFeedbacks();
	
	public String addFeedback(Feedback feedback);

}