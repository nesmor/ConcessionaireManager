package com.consultech.concessionairemanager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultech.concessionairemanager.exception.BadRequestAlertException;
import com.consultech.concessionairemanager.exception.EntityNotFoundException;
import com.consultech.concessionairemanager.model.Customer;
import com.consultech.concessionairemanager.model.enumeration.CustomerStatus;
import com.consultech.concessionairemanager.repository.CustomerRepository;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements DAO<Customer> {

    private final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private static final String ENTITY_NAME = "customer";

    @Autowired
    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer customer) throws BadRequestAlertException {
        log.debug("REST request to save Customer : {}", customer);
        if (customer.getId() != null) {
            throw new BadRequestAlertException("A new customer cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Instant today = new Date().toInstant();
        customer.setCreateDate(today);
        Customer result = customerRepository.save(customer);
        return result;
    }

    public Customer update(Customer customer) throws BadRequestAlertException, EntityNotFoundException {
        log.debug("REST request to update Customer : {}", customer);
        
        if (customer.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Optional<Customer> oCustomer = customerRepository.findById(customer.getId());
        if(oCustomer.isPresent()) {
        	Instant today = new Date().toInstant();
        	oCustomer.get().setUpdatedDate(today);
        	Customer result = customerRepository.save(oCustomer.get());
        	return  result;
        } else {
        	throw new EntityNotFoundException();
        }
    }

    public List<Customer> getAll() {
        log.debug("REST request to get all Customers");
        return customerRepository.findAll();
    }


    public Customer get(Long id) {
        log.debug("REST request to get Customer : {}", id);
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    public Customer delete(Long id) throws EntityNotFoundException {
    	Instant today = new Date().toInstant();
        log.debug("REST request to delete Customer : {}", id);
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
        	customer.get().setDeletedDate(today);
        	customer.get().setStatus(CustomerStatus.DELETED);
        	Customer result = customerRepository.save(customer.get());
        	return  result;
        }
        else {
        	throw new EntityNotFoundException();
        }
         
    }


}
