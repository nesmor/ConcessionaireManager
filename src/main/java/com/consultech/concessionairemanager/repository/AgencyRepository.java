package com.consultech.concessionairemanager.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.consultech.concessionairemanager.model.Agency;
import com.consultech.concessionairemanager.model.Location;


/**
 * Spring Data  repository for the Agency entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
	
	public List<Agency> findByLocationId(Long locationId);

}
