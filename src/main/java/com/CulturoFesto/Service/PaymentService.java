package com.CulturoFesto.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CulturoFesto.Model.Payment;

import com.CulturoFesto.Repository.*;


@Service
public class PaymentService {
	private static final Logger LOGGER = LogManager.getLogger(PaymentService.class);

	
	@Autowired
	PaymentRepository paymentRepository;
	
	
	public Payment makePayment(Payment payment)
	{
		return paymentRepository.save(payment);
	}

	}