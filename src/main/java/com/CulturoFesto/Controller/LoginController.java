package com.CulturoFesto.Controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.CulturoFesto.Exception.LoginException;
import com.CulturoFesto.Model.AdminInfo;
import com.CulturoFesto.Model.LoginInfo;
import com.CulturoFesto.Model.UserInfo;
import com.CulturoFesto.Repository.AdminRepo;
import com.CulturoFesto.Repository.LoginRepo;
import com.CulturoFesto.Repository.UserRepo;
import com.CulturoFesto.Service.LoginService;



@CrossOrigin
@RestController
public class LoginController {
	@Autowired
	LoginService loginservice;
	@Autowired
	UserRepo userrepo;
	@Autowired
	LoginRepo loginrepo;
	
	@Autowired
	AdminRepo adminrepo;
	
	
	
	//creating admin
		@GetMapping("/createAdmin")
		public String addAdmin()
		{
			// save a single Customer
			UserInfo user23=userrepo.findByMobile("9654651234");
			if(user23==null)
			{
				userrepo.save(new UserInfo("vt110011", "Taranjeet", "Singh", "9654651234", "31-10-1997", "taranu56", "adminsaluja"));
				
				return "Admin Registered";
			}
			//{"firstName":"Vikram","lastName":"Shetty","iDp":"awrr123456","mobile":"998765431","dob":"1997-26-09"}
			else 
			{
				return "Admin already exist......!!!";
				//throw new TechLearnException("Admin already exist......!!!");
			}
		}
		
	
	
	@PostMapping("/home/login")
	public String loginuser(@Valid @RequestBody LoginInfo login){
		List<UserInfo> lst=userrepo.findByGnUidAndGnPassword(login.getGnUid(), login.getGnPassword());
		System.out.println(lst);
		System.out.println(login.getGnUid());
		System.out.println(login.getGnPassword());
		if(lst.size()>0) {
			return login.getGnUid();
		}else {
				throw new LoginException("Login Unsuccessful, as password does not match with given "+login.getGnUid());
		}
	}
	
	  //this method displays the home of the Application.
	@RequestMapping(method = RequestMethod.GET,value = "/home")
	public String sayHi() {
		String greet = "COME CELEBRATE WITH US" ;
		return greet;
	}
	
	//this method allows the user to put his/her credentials and also check if the user is already registered or not.
	@PostMapping("/home/register")
	public String RegisterUser(@Valid @RequestBody UserInfo user) {

		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setGnUid(loginservice.GenerateUid(user.getFirstName(), user.getLastName()));
		LocalDateTime timestamp = LocalDateTime.now();
		loginInfo.setGnPassword(loginservice.GeneratePassword(user.getFirstName(), user.getLastName(), user.getMobile(),
				user.getDob()));

		if (!userrepo.existsById(user.getiDp())) {
			userrepo.save(new UserInfo(user.getiDp(), user.getFirstName(), user.getLastName(), user.getMobile(), user.getDob(), loginInfo.getGnPassword(), loginInfo.getGnUid()));
			loginrepo.save(loginInfo);
			return (user.getFirstName() + " you have succeeded in registering with CulturoFesto.Please find your login credentials:\n" + "Username :"
					+ loginInfo.getGnUid() + "\n" + "Password:" + loginInfo.getGnPassword() + "\n" + "Time: "
					+ timestamp);
		} else
			return "Already Registered";
	}

	
	//this method allows the user to reset the generated password.
	@PutMapping("/reset")
	public String updateuser(@RequestBody LoginInfo login) {
		loginrepo.save(login);
		return "User Password is Updated";
	}

	//this method will display the information provided by the user.
	@GetMapping("/display")
	List<UserInfo> findUserInfo() {
		List<UserInfo> Information = (List<UserInfo>) userrepo.findAll();
		return Information;
	}

	//if credentials are wrongly entered or there is any null value given .this annotation will be invoked. 
	@ExceptionHandler(NullPointerException.class)
	public String HandleExceptions() {
		return "Something Went Wrong";
	}
}