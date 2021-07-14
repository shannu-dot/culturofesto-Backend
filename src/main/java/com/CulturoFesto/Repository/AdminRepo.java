package com.CulturoFesto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CulturoFesto.Model.AdminInfo;


@Repository
public interface AdminRepo extends JpaRepository<AdminInfo, String>{

	//List<AdminInfo> findByadminUsernameAndadminPassword(String adminUsername, String adminPassword);

}
