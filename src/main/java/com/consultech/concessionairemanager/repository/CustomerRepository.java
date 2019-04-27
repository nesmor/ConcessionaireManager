package com.consultech.concessionairemanager.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.consultech.concessionairemanager.model.Customer;


/**
 * Spring Data  repository for the Customer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
