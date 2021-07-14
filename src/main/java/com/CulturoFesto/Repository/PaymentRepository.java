package com.CulturoFesto.Repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.CulturoFesto.Model.Payment;
//import com.CulturoFesto.Model.Registration;


public interface PaymentRepository extends CrudRepository<Payment,Integer>{
	
	
}