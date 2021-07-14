package com.CulturoFesto.Service;

import java.util.List;

import com.CulturoFesto.Model.Registration;

public interface RegistrationService {
	
	public String addRegistrations(Registration registration);
	
	public List<Registration> getAllRegistrations();
	
	public Registration getRegistrationById(String registration);
	
	public String deleteRegistration(String registrationId);
	
	public long calculateTotalCost(Registration registration);

}
