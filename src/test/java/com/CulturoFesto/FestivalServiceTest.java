package com.CulturoFesto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.CulturoFesto.Model.AdminInfo;
import com.CulturoFesto.Model.Festival;
import com.CulturoFesto.Repository.AdminRepo;
import com.CulturoFesto.Repository.FestivalRepo;
import com.CulturoFesto.Service.AdminService;
import com.CulturoFesto.Service.FestivalServiceImpl;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FestivalServiceTest {
	
	@Autowired
	private FestivalServiceImpl festivalService;
	@Autowired
	private AdminService adminService;
	@MockBean
	private FestivalRepo festivalRepo;
	@MockBean
	private AdminRepo adminRepo;
	
	//test case to check inserted festival
	@Test
	public void addFestivalTest() {
		Festival festival = new Festival("F100","Holi","West","Mumbai",600,300,"20-3-2021","Lassi snacks",200,100);
		Mockito.when(festivalRepo.saveAndFlush(festival)).thenReturn(festival);
		assertThat(festivalService.addFestival(festival)).isEqualTo("Festival Added Successfully");
	}
		
	//test case to check Updated festival	
		@Test
		public void getAllFestivalsTest()
	{
			List<Festival> list = new ArrayList<>();
			Festival festivalOne = new Festival("F100","Holi","West","Mumbai",600,300,"20-3-2021","Lassi snacks",200,100);
			Festival festivalTwo = new Festival("F200","Holi","West","Pune",800,400,"22-3-2021","Lassi snacks",300,100);
			Festival festivalThree = new Festival("F300","Ganesh","West","Goa",1000,600,"26-9-2021","Modak snacks",300,100);
			list.add(festivalOne);
			list.add(festivalTwo);
			list.add(festivalThree);
			when(festivalRepo.findAll()).thenReturn(list);
			List<Festival> festivalList = festivalService.getAllFestivals();
			assertEquals(3, festivalList.size());
			verify(festivalRepo, times(1)).findAll();
		}
		
		
	// test case to check the method findFestivalById
	
//		@Test
//		public void findFestivalByIdTest() {
//			Festival festival = new Festival("F100","Holi","West","Mumbai",600,300,"20-3-2021","Lassi snacks",200,100);
//			festival.setFestivalId("F100");
//			//System.out.println(festivalRepo.findById("F100"));
//			//Assert.assertTrue(festivalRepo.findById("F100").isPresent());
//			//Assert.assertTrue(festivalRepo.findById("F100").isEmpty());
//			Mockito.when(festivalRepo.saveAndFlush(festival)).thenReturn(festival);
//			assertThat(festivalService.getFestivalById(festival.getFestivalId())).isEqualTo(festival);
//		}	
		
		
		// test case to check the method deleteFestivalById
		
		@Test
		public void deleteFestivalByIdTest() {
			Festival festival = new Festival("F100","Holi","West","Mumbai",600,300,"20-3-2021","Lassi snacks",200,100);
			festival.setFestivalId("F100");
			Mockito.when(festivalRepo.saveAndFlush(festival)).thenReturn(festival);
			assertThat(festivalService.deleteFestival(festival.getFestivalId())).isEqualTo("Festival Deleted Successfully");
		}
		

}
