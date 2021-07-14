package com.CulturoFesto.Service;

import java.util.List;


import com.CulturoFesto.Model.Festival;

public interface FestivalService {
	
	public String addFestival(Festival festival);
	
	public String updateFestival(Festival festival, String fid) ;
	
	public List<Festival> getAllFestivals();
	
	public Festival getFestivalById(String festivalId);
	
	public String deleteFestival(String festivalId);
	
	public List<Festival> getFestivalByName(String festivalName);
	
	public List<Festival> getFestivalByRegion(String festivalRegion);
	
	public List<Festival> getFestivalByVenue(String festivalVenue);
	
	public List<Festival> getFestivalByDate(String festivalDate);
	
	

}
