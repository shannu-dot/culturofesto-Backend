package com.CulturoFesto.Controller;

import java.net.BindException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CulturoFesto.Model.Feedback;
import com.CulturoFesto.Service.FeedbackService;
@CrossOrigin
@RestController
@Validated

public class FeedbackController {
	
	private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);

	@Autowired(required = true)
	private FeedbackService feedbackservice;
	
	@PostMapping("feedback/postComment")
	public String addFeedback(@Valid Feedback feedback) throws Exception {
		logger.info("in Feedback controller to insert Feedback into the Database");

		try {
			return feedbackservice.addFeedback(feedback);
		} catch (Exception exception) {
			throw new BindException("binding error");
		}

	}

	// find all Feedback from the database
	@GetMapping("feedback/findAll")
	public List<Feedback> getAllFeedbacks() {
		logger.info("Get the details of all Feedbacks ");
		return feedbackservice.getAllFeedbacks();
	}

}
