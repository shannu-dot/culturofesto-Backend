package com.CulturoFesto.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CulturoFesto.Model.UserInfo;
import com.CulturoFesto.Repository.UserRepo;


@Service("UserService")
public class UserServiceImpl  implements UserService{
	
	
private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepo userRepo;

	@Override
	public String addUser(UserInfo userinfo) {
		logger.info("Add details of Festival ");
		userRepo.saveAndFlush(userinfo);
		return "User Added Successfully";
	}
	
	@Override
	public String updateUser(UserInfo userinfo, String iDp) {
		logger.info("Update User Details ");
		userRepo.save(userinfo);
		return "User Updated Successfully";
	}

	
	@Override
	public Iterable<UserInfo> getAllUsers() {
		logger.info("Get all the details of users");
		return userRepo.findAll();
	}

	
	@Override
	public String deleteUser(String iDp) {
		logger.info("Delete the Festival");
		userRepo.deleteById(iDp);
		return "User Deleted Successfully";
	}


	@Override
	public UserInfo getUserById(String iDp) {
		logger.info("Get the details of user by id");
		Optional<UserInfo> f= userRepo.findById(iDp);
		if(f.isPresent())
			return f.get();
		else
			return null;
	}
	
	


}
