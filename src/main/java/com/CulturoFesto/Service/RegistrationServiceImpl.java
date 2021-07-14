package com.CulturoFesto.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CulturoFesto.Model.Registration;
import com.CulturoFesto.Repository.RegistrationRepo;

@Service("RegistrationService")
public class RegistrationServiceImpl implements RegistrationService{
	
		private static final Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);
		
		@Autowired
		RegistrationRepo registrationRepo;

		@Override
		public String addRegistrations(Registration registration) {
			logger.info("Add Details of Booking");
			registrationRepo.saveAndFlush(registration);
			return "Booking Added Successfully";
			
		}

		@Override
		public List<Registration> getAllRegistrations() {
			logger.info("Get all the details of booking");
			return registrationRepo.findAll();
		}

		@Override
		public Registration getRegistrationById(String registrationId) {
			logger.info("Get the details of Festivals by id");
			Optional<Registration> b= registrationRepo.findById(registrationId);
			if(b.isPresent())
				return b.get();
			else
				return null;
			
		}

		@Override
		public String deleteRegistration(String registrationId) {
			logger.info("Delete the registration");
			registrationRepo.deleteById(registrationId);
			return "booking Deleted Successfully";
		}

		@Override
		public long calculateTotalCost(Registration registration) { 
			
			long total_cost;
			if(registration.isFoodOption()) {
				
				total_cost = ( registration.getFestival().getFestivalAmountAdult() + registration.getFestival().getFoodPriceAdult())
						* (registration.getNumberOfAdults()) 
						+
						 ( registration.getFestival().getFestivalAmountChildren() + registration.getFestival().getFoodPriceChildren()) 
						*(  registration.getNumberOfChildren());					
			}
			
			else {
				total_cost = ( registration.getFestival().getFestivalAmountAdult() * registration.getNumberOfAdults())
						+
						 ( registration.getFestival().getFestivalAmountChildren() * registration.getNumberOfChildren());			
			}
			
			return total_cost;
		
		}
		

}
