package com.CulturoFesto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CulturoFesto.Model.Festival;

@Repository
public interface FestivalRepo extends JpaRepository<Festival, String> {
	//public List<Festival> findFestivalByName(String festivalName);
	
	//custom query to get Festival by Name
	@Query("select f from Festival f where f.festivalName = ?1")
	public List<Festival> findFestivalByName(String festivalName);
	
	
	//custom query to get Festival by Region
	@Query("select f from Festival f where f.festivalRegion = ?1")
	public List<Festival> findFestivalByRegion(String festivalRegion);
	
	//custom query to get Festival by Venue
	@Query("select f from Festival f where f.festivalVenue = ?1")
	public List<Festival> findFestivalByVenue(String festivalVenue);
		
	//custom query to get Festival by Date
	@Query("select f from Festival f where f.festivalDate = ?1")
	public List<Festival> findFestivalByDate(String festivalDate);
	

}
