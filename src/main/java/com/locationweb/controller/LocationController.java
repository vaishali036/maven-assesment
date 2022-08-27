package com.locationweb.controller;

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
@RequestMapping("/hello")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private EmailService emailService;
	
	//handler method
	
	@GetMapping("/show")
	public String showLocationPage() {
		return "create_location"; 
	}
	
	//data transfer object (dto)
//	@RequestMapping("/saveLocation")
//	public String saveLocation(LocationData loc, ModelMap model) {
//		Locations location=new Locations();
//		location.setId(loc.getId());
//		location.setName(loc.getName());
//		location.setCodes(loc.getCodes());
//		location.setType(loc.getType());
//		model.addAttribute("msg", "LOCATION IS SAVED...!");
//		locationService.savaLocation(location);
//		
//		return "create_location";
//	}
	
	//request param
//	@RequestMapping("/saveLocation")
//	public String saveLocation(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("codes") String code,@RequestParam("type") String type) {
//		Locations location=new Locations();
//		location.setId(id);
//		location.setName(name);
//		location.setCodes(code);
//		location.setType(type);
//		locationService.savaLocation(location);
//		
//		return "create_location";
//	}
	
	//entity class
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
}
