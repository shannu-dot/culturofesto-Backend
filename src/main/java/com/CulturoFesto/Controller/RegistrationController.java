package com.CulturoFesto.Controller;

import java.net.BindException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CulturoFesto.Model.Festival;
import com.CulturoFesto.Exception.BookingNotFoundException;
import com.CulturoFesto.Exception.FestivalNotFoundException;
import com.CulturoFesto.Model.Registration;
import com.CulturoFesto.Service.RegistrationService;
@CrossOrigin
@RestController
public class RegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	RegistrationService registrationService;

	// controller to insert data in database
	@PostMapping("/Register/insert")
	public String addRegistrations( @RequestBody Registration registration) throws Exception {
		logger.info("in Booking controller to insert Booking into the Database");

		try {
			return registrationService.addRegistrations(registration);
		} catch (Exception exception) {
			throw new BindException("binding error");
		}

	}

	// find all Bookings from the database
	@GetMapping("/Register/findAll")
	public List<Registration> getAllRegistrations() {
		logger.info("Get the details of all Festival Registrations ");
		return registrationService.getAllRegistrations();
	}

	// find the Booking with specific id from the database
	@GetMapping("/Register/find/{registrationId}")
	public Registration getRegistrationById(@PathVariable String registrationId) throws BookingNotFoundException {

		logger.info("In Registration Controller to retrieve a registration  by Id ..>!!!");

		Registration registration = null;
		try {
			logger.info("Booking Id to be searched..." + registrationId);
			registration = registrationService.getRegistrationById(registrationId);
		} catch (Exception exception) {
			logger.info("In catch block of getRegistrationById() ...!");
			throw new BookingNotFoundException("Enter valid registrationId  ");
		}

		return registration;
	}

	// delete the Booking with specific id from the database
	@DeleteMapping("/Register/delete/{registrationId}")
	public String deleteRegistration(@PathVariable String registrationId) throws BookingNotFoundException {

		logger.info("In Registration Controller to delete a registration by Id ..>!!!");

		try {
			logger.info("Booking Id to be deleted..." + registrationId);
			registrationService.getRegistrationById(registrationId);
		} catch (Exception exception) {
			logger.info("In catch block of Delete Booking ...!");
			throw new BookingNotFoundException("Enter an existing  Booking id to be deleted  ");
		}
		return registrationService.deleteRegistration(registrationId);
	}
	
	@GetMapping("/Register/totalCost/{registration}")
	public long calculateTotalCost(@PathVariable Registration registration) {
		
		logger.info("In Booking Controller to calculate total cost of registration ..>!!!");
		return registrationService.calculateTotalCost(registration);
		
	}

}
