package com.CulturoFesto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CulturoFesto.Model.AdminInfo;
import com.CulturoFesto.Repository.AdminRepo;


@Service
public class AdminService {
	
	@Autowired
	AdminRepo adminRepo;
	
	public String addAdmin() {
		AdminInfo adminInfo =new AdminInfo();
		adminInfo.setFirstName("Harshith");
		adminInfo.setLastName("Oberoi");
		adminInfo.setAdminUsername("adminroot");
		adminInfo.setAdminPassword("adminroot");
		adminInfo.setId("admin1");
		
		adminRepo.save(adminInfo);
		
	//AdminInfo admin=adminRepo.save(new AdminInfo("1Admin", "Harshith", "Oberoi", "RootAdmin", "Rootpassword"));
	return "Admin Added";
	}
}
