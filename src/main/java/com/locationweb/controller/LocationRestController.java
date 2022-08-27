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

import com.locationweb.entities.Locations;
import com.locationweb.repositories.LocationRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.locationweb.dto.LocationData;
import com.locationweb.entities.Locations;
import com.locationweb.services.LocationService;
import com.locationweb.utility.EmailService;

@Controller
@RequestMapping("/location/api")
public class LocationRestController {

	@Autowired
	private LocationRepository locationRepo;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private EmailService emailService;
	
	//handler method
	
	@RequestMapping("show")
	public String showLocationPage() {
		return "create_location"; 
	}
	@RequestMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("loc") Locations location, ModelMap model) {
		locationService.savaLocation(location);
		//emailService.sendSimpleMessage("rajmandale18@gmail.com", "Test", "welcome msg");
		//model.addAttribute("msg", "LOCATION IS SAVED...!");
		model.addAttribute("msg", "LOCATION IS Saved...!");
		return "create_location";
	}
	
	@RequestMapping("listall")
	public String listAll(ModelMap model) {
		List<Locations> locations = locationService.getAllLocations();
		model.addAttribute("locations" , locations);
		return "search_Result";
	}
	@RequestMapping("/delete")
	public String deleteLocation(@RequestParam("id") long id,ModelMap model) {
		locationService.deleteLocationById(id);
		List<Locations> locations = locationService.getAllLocations();
		model.addAttribute("locations" , locations);
		return "search_Result";
	}
	
	@RequestMapping("/update")
	public String updateLocation(@RequestParam("id") long id,ModelMap model) {
		Locations location = locationService.getLocationById(id);
		model.addAttribute("location" , location);
		return "update_location";
	}
	
	@RequestMapping("/updateData")
	public String updateLocation(@ModelAttribute("loc") Locations location, ModelMap model) {
		locationService.savaLocation(location);
		model.addAttribute("msg", "LOCATION IS updated...!");
		return "update_location";
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
