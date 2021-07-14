package com.CulturoFesto.Controller;

import java.net.BindException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CulturoFesto.Exception.FestivalNotFoundException;
import com.CulturoFesto.Model.Festival;
import com.CulturoFesto.Service.FestivalService;
@CrossOrigin
@RestController
@Validated
public class FestivalController {

	private static final Logger logger = LoggerFactory.getLogger(FestivalController.class);

	@Autowired
	FestivalService festivalService;

	// controller to insert data in database
	@PostMapping("/festival/insert")
	public String addFestivals(@RequestBody Festival festival) throws Exception {
		logger.info("in Festival controller to insert Festival into the Database");

		try {
			return festivalService.addFestival(festival);
		} catch (Exception exception) {
			throw new BindException("binding error");
		}

	}

	// find all Festivals from the database
	@GetMapping("/festival/findAll")
	public List<Festival> getAllFestivals() {
		logger.info("Get the details of all Festivals ");
		return festivalService.getAllFestivals();
	}

	// find the festival with specific id from the database
	@GetMapping("/festival/find/{festivalId}")
	public Festival getFestivalById(@PathVariable String festivalId) throws FestivalNotFoundException {

		logger.info("In Festival Controller to retrieve a Festival  by Id ..>!!!");

		Festival festival = null;
		try {
			logger.info("Festival Id to be searched..." + festivalId);
			festival = festivalService.getFestivalById(festivalId);
		} catch (Exception exception) {
			logger.info("In catch block of getFestivalById() ...!");
			throw new FestivalNotFoundException("Enter valid Festival id ");
		}

		return festival;
	}

	@PutMapping("/festival/update/{festivalId}")
	public String updateFestival(@PathVariable String festivalId, Festival festival) throws FestivalNotFoundException{
		
		logger.info("In Festival Controller to Update a Festival by Id ..>!!!");
		//Festival festival2 = festivalService.getFestivalById(festivalId)
		//	.orElseThrow(() -> new FestivalNotFoundException("Festival not exist with id :" + festivalId));
		
		try{
			logger.info("Festival Id to be Updated..."+festivalId);
			Festival festival2 =festivalService.getFestivalById(festivalId);
			
			festival2.setFestivalName(festival.getFestivalName());
			festival2.setFestivalId(festival.getFestivalId());
			festival2.setFestivalRegion(festival.getFestivalRegion());
			festival2.setFestivalVenue(festival.getFestivalVenue());
			festival2.setFestivalDate(festival.getFestivalDate());
			//festival2.setFestivalTime(festival.getFestivalTime());
			festival2.setFestivalAmountAdult(festival.getFestivalAmountAdult());
			festival2.setFestivalAmountChildren(festival.getFestivalAmountChildren());
			festival2.setFooditem(festival.getFooditem());
			festival2.setFoodPriceAdult(festival.getFoodPriceAdult());
			festival2.setFoodPriceChildren(festival.getFoodPriceChildren());
			
		}catch(Exception exception) {
			logger.info("In catch block of pdateFestival ...!");
			throw new FestivalNotFoundException("Enter an existing  Festival id to be Updated  ");
		}
		
		
		
		return festivalService.updateFestival(festival, festivalId);
	}

	
	// delete the Festival with specific id from the database
		@DeleteMapping("/festival/delete/{festivalId}")
		public String deleteFestival(@PathVariable String festivalId) throws FestivalNotFoundException{
			
			logger.info("In Festival Controller to delete a Festival by Id ..>!!!");
		
			try{
				logger.info("Festival Id to be deleted..."+festivalId);
				festivalService.getFestivalById(festivalId);
			}catch(Exception exception) {
				logger.info("In catch block of DeleteFestival ...!");
				throw new FestivalNotFoundException("Enter an existing  Festival id to be deleted  ");
			}
			return festivalService.deleteFestival(festivalId); 
		}
		
		
		@GetMapping("/festival/findFestivalByName/{festivalName}")
		public List<Festival> getFestivalByName(@PathVariable String festivalName){
			logger.info("To get Festival by name controller");
			return festivalService.getFestivalByName(festivalName);
		}
		
		@GetMapping("/festival/findFestivalByRegion/{festivalRegion}")
		public List<Festival> getFestivalByRegion(@PathVariable String festivalRegion){
			logger.info("To get Festival by Region controller");
			return festivalService.getFestivalByRegion(festivalRegion);
		}
		
		@GetMapping("/festival/findFestivalByVenue/{festivalVenue}")
		public List<Festival> getFestivalByVenue(@PathVariable String festivalVenue){
			logger.info("To get Festival by Venue controller");
			return festivalService.getFestivalByVenue(festivalVenue);
		}
		
		@GetMapping("/festival/findFestivalByDate/{festivalDate}")
		public List<Festival> getFestivalByDate(@PathVariable String festivalDate){
			logger.info("To get Festival by Date controller");
			return festivalService.getFestivalByDate(festivalDate);
		}
		
}

