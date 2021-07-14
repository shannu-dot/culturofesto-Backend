package com.CulturoFesto.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CulturoFesto.Model.Feedback;
import com.CulturoFesto.Repository.FeedbackRepo;

@Service("FeedbackService")
public class FeedbackServiceImpl implements FeedbackService {

	private static final Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);

	@Autowired(required = true)
	FeedbackRepo feedbackrepo;

	@Override
	public List<Feedback> getAllFeedbacks() {
		logger.info("Get all the Feedbacks");
		return feedbackrepo.findAll();
	}

	@Override
	public String addFeedback(Feedback feedback) {
		logger.info("Add the feedback ");
		feedbackrepo.saveAndFlush(feedback);
		return "Feedback Added Successfully";
	}

}
