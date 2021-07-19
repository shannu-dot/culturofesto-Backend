package com.CulturoFesto;
import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import org.junit.Assert;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.CulturoFesto.Model.*;
import com.CulturoFesto.Repository.AdminRepo;

//import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class LoginTest {
	  @LocalServerPort
      int randomServerPort;
      @Autowired
      AdminRepo adminrepo;
      @Autowired   // _____________________________
  	private TestRestTemplate restTemplate;
       @SuppressWarnings("deprecation")
       @Test
       public void LoginTest() throws URISyntaxException 
       {
       RestTemplate restTemplate = new RestTemplate();
         
       final String baseUrl = "http://localhost:" + randomServerPort + "/home/register";
       URI uri = new URI(baseUrl);
       LoginInfo loginInfo=new LoginInfo();
       loginInfo.getGnUid();
       loginInfo.getGnPassword();
       LocalDateTime timestamp = LocalDateTime.now();
       UserInfo userinfo=new UserInfo("vt110011", "Taranjeet", "Singh", "9654651234", "31-10-1997", "taranu56", "adminsaluja");
    
       HttpHeaders headers = new HttpHeaders();
       
       HttpEntity<UserInfo> request = new HttpEntity<>(userinfo, headers);
   
       ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

       Assert.assertEquals(200, result.getStatusCodeValue());
       Assert.assertEquals(false, result.getBody().contains( userinfo.getFirstName() + " you have succeeded in registering with CulturoFesto.Please find your login credentials:\n" + "Username :"
				+ loginInfo.getGnUid() + "\n" + "Password:" + loginInfo.getGnPassword() + "\n" + "Time: "
				+ timestamp));
       
}
     
       @Test
       public void TestBlukCreateTrainer() throws URISyntaxException 
       {
           RestTemplate restTemplate = new RestTemplate();
         
           final String baseUrl = "http://localhost:" + randomServerPort + "/createAdmin";
           URI uri = new URI(baseUrl);
        
           ResponseEntity<String> result = restTemplate.getForEntity(uri,String.class);
            
           //Verify request succeed
           Assert.assertEquals(200, result.getStatusCodeValue());
           Assert.assertEquals(true, result.getBody().contains("Admin Registered"));
}
}
