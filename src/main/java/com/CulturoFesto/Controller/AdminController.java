package com.CulturoFesto.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.CulturoFesto.Model.AdminInfo;

import com.CulturoFesto.Repository.AdminRepo;
import com.CulturoFesto.Service.AdminService;
@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	AdminRepo adminRepo;
	
	@PostMapping("/admin")
    public String addAdmin(){
            return adminService.addAdmin();
	}
	@GetMapping("/welcome/{name}")
	public String welcome(@PathVariable("name") String name) {
		return name + "Welcome to CulturoFesto!!";
	}
	/*
	 * @PostMapping("/admin/login") public String loginadmin(@RequestBody AdminInfo
	 * admin){ List<AdminInfo> lst
	 * =adminRepo.findByadminUsernameAndadminPassword(admin.getAdminUsername(),
	 * admin.getAdminPassword()); System.out.println(admin.getAdminUsername());
	 * System.out.println(admin.getAdminPassword()); if(lst.size() > 0) { return
	 * "Admin successfully logged in"; }else { return
	 * "access Denied "+admin.getAdminUsername(); } }
	 */
	
}
	
