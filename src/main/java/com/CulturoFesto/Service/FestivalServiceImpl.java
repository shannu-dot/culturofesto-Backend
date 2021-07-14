package com.CulturoFesto.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CulturoFesto.Exception.FestivalNotFoundException;
import com.CulturoFesto.Model.Festival;
import com.CulturoFesto.Repository.FestivalRepo;



@Service("FestivalService")
public class FestivalServiceImpl implements FestivalService{
	
	private static final Logger logger = LoggerFactory.getLogger(FestivalServiceImpl.class);
	
	@Autowired
	FestivalRepo festivalrepo;

	@Override
	public String addFestival(Festival festival) {
		logger.info("Add details of Festival ");
		festivalrepo.saveAndFlush(festival);
		return "Festival Added Successfully";
	}
	
	@Override
	public String updateFestival(Festival festival, String festivalId) {
		logger.info("Update Festival Details ");
		festivalrepo.save(festival);
		return "Festival Updated Successfully";
	}

	
	@Override
	public List<Festival> getAllFestivals() {
		logger.info("Get all the details of Festivals");
		return festivalrepo.findAll();
	}

	@Override
	public String deleteFestival(String festivalId) {
		logger.info("Delete the Festival");
		festivalrepo.deleteById(festivalId);
		return "Festival Deleted Successfully";
	}


	@Override
	public Festival getFestivalById(String festivalId) {
		logger.info("Get the details of Festivals by id");
		Optional<Festival> f= festivalrepo.findById(festivalId);
		if(f.isPresent())
			return f.get();
		else
			return null;
	}


	@Override
	public List<Festival> getFestivalByName(String festivalName) {
		logger.info("Get Festival by Name");
		return festivalrepo.findFestivalByName(festivalName);
	}

	@Override
	public List<Festival> getFestivalByRegion(String festivalRegion) {
		logger.info("Get Festival by Region");
		return festivalrepo.findFestivalByRegion(festivalRegion);
	}

	@Override
	public List<Festival> getFestivalByVenue(String festivalVenue) {
		logger.info("Get Festival by Venue");
		return festivalrepo.findFestivalByVenue(festivalVenue);
	}

	@Override
	public List<Festival> getFestivalByDate(String festivalDate) {
		logger.info("Get Festival by Date");
		return festivalrepo.findFestivalByDate(festivalDate);
	}

	//@Override
	//public List<Festival> getFestivalByName(String festivalName) {
	//	logger.info("Get Festival by name");
	//	return festivalrepo.findFestivalByName(festivalName);
	//}
	
	

}
