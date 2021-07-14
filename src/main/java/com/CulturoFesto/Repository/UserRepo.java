package com.CulturoFesto.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CulturoFesto.Model.UserInfo;



@Repository
public interface UserRepo extends CrudRepository<UserInfo, String> {	
	void saveAndFlush(UserInfo userinfo);	
//	public List<UserInfo> findUserInfo();
	UserInfo findByMobile(String mobile);
	List<UserInfo> findByGnUidAndGnPassword(String gnUid, String gnPassword);

}