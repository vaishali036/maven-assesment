package com.locationweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locationweb.entities.Locations;
import com.locationweb.repositories.LocationRepository;
@Service
public class LocationServiceImpl implements LocationService {

	
	@Autowired
	private LocationRepository locationrepo;
	@Override
	public void savaLocation(Locations location) {
		locationrepo.save(location);
		
	}
	@Override
	public List<Locations> getAllLocations() {
		List<Locations> locations = locationrepo.findAll();
		return locations;
	}
	@Override
	public void deleteLocationById(long id) {
		locationrepo.deleteById(id);
		
	}
	@Override
	public Locations getLocationById(long id) {
		Optional<Locations> findById = locationrepo.findById(id);
		Locations locations = findById.get();
		return locations;
	}

}
