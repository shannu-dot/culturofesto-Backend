package com.CulturoFesto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CulturoFesto.Model.Registration;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, String> {

}
