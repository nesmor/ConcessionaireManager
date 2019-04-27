package com.consultech.concessionairemanager.service;import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultech.concessionairemanager.exception.BadRequestAlertException;
import com.consultech.concessionairemanager.exception.EntityNotFoundException;
import com.consultech.concessionairemanager.model.Agency;
import com.consultech.concessionairemanager.model.Location;
import com.consultech.concessionairemanager.repository.LocationRepository;

@Service
public class LocationService implements DAO<Location>{
	
	private final Logger log = LoggerFactory.getLogger(LocationService.class);
	
	@Autowired
    private final LocationRepository locationRepository;


    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

	@Override
	public Location get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getAll() {
		log.debug("REST request to get all Customers");
        return  locationRepository.findAll();
	}

	@Override
	public Location create(Location t) throws BadRequestAlertException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location update(Location t) throws BadRequestAlertException, EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location delete(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
