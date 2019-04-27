package com.consultech.concessionairemanager.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.consultech.concessionairemanager.model.Location;


/**
 * Spring Data  repository for the Location entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
