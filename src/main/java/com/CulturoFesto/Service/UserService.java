package com.CulturoFesto.Service;

import java.util.List;

import com.CulturoFesto.Model.UserInfo;

public interface UserService {

	String addUser(UserInfo userinfo);

	String updateUser(UserInfo userinfo, String iDp);

	Iterable<UserInfo> getAllUsers();

	String deleteUser(String iDp);

	UserInfo getUserById(String iDp);

}
