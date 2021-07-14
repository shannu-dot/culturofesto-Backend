package com.CulturoFesto.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CulturoFesto.Exception.*;
import com.CulturoFesto.Model.Payment;
import com.CulturoFesto.Service.PaymentService;



import com.CulturoFesto.Repository.*;

@CrossOrigin
@RestController
@RequestMapping("/payment")
public class PaymentController {
	//private static final Logger LOGGER = LogManager.getLogger(Controller.class);
	
	@Autowired
	PaymentService paymentService;
	
	
	 @PostMapping("/insert")
		//@ApiOperation(value="Insert Details", notes="Insert customer details", response=Payment.class)
	   public ResponseEntity<Payment> makePayment(@RequestBody Payment payment) {
		 paymentService.makePayment(payment);
	       return ResponseEntity.noContent().build();
	   } 
 }