package com.locationweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locationweb.entities.Locations;
import com.locationweb.repositories.LocationRepository;

@RestController
@RequestMapping("/location/api")
public class LocationRestController {

	@Autowired
	private LocationRepository locationRepo;
	
	@RequestMapping("show")
	public String showLocationPage() {
		return "create_location"; 
	}
	
	@GetMapping
	public List<Locations> getLocations(){
		List<Locations> locations = locationRepo.findAll();
		return locations;
	}
	
	@PostMapping
	public void saveLocation(@RequestBody Locations location) {
		locationRepo.save(location);
	}
	
	@PutMapping
	public void updateLocation(@RequestBody Locations location) {
		locationRepo.save(location);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLocation(@PathVariable("id") long id) {
		locationRepo.deleteById(id);
	}
	@GetMapping("/get/{id}")
	public Locations getLocationById(@PathVariable("id") long id) {
		try {
			Optional<Locations> findById = locationRepo.findById(id);
			Locations locations = findById.get();
			return locations;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
