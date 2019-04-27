package com.consultech.concessionairemanager.service;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultech.concessionairemanager.exception.BadRequestAlertException;
import com.consultech.concessionairemanager.exception.EntityNotFoundException;
import com.consultech.concessionairemanager.model.Agency;
import com.consultech.concessionairemanager.repository.AgencyRepository;

@Service
public class AgencyService implements DAO<Agency> {
	
	private final Logger log = LoggerFactory.getLogger(AgencyService.class);
	
	@Autowired
    private final AgencyRepository agencyRepository;

	public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

	
	@Override
	public Agency get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Agency> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Agency> getByLocationId(Long locationId) {
		return this.agencyRepository.findByLocationId(locationId);
	}

	@Override
	public Agency create(Agency t) throws BadRequestAlertException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agency update(Agency t) throws BadRequestAlertException, EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agency delete(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
