package com.CulturoFesto.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CulturoFesto.Model.LoginInfo;


@Repository
public interface LoginRepo extends CrudRepository<LoginInfo, String>{
	List<LoginInfo> findByGnUidAndGnPassword(String str1,String str2);
}
