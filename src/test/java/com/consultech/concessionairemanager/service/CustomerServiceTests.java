package com.consultech.concessionairemanager.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.consultech.concessionairemanager.ConcessionaireManagerApplication;
import com.consultech.concessionairemanager.model.Agency;
import com.consultech.concessionairemanager.model.Customer;
import com.consultech.concessionairemanager.repository.CustomerRepository;
import org.hamcrest.collection.IsEmptyCollection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author root
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest(classes = ConcessionaireManagerApplication.class)
public class CustomerServiceTests {
	
	@Autowired
	private CustomerRepository customerRepository;
	
    private CustomerService customerService;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerService(customerRepository);
    }

    @Test @Transactional
    public void testCreateCustomer() throws Exception {
    	Agency a = new Agency();
    	a.setId(1l);
    	Customer c = new Customer();
    	c.setAgency(a);
    	c.setName("Doris Barazarte");
    	c.setDocumentNumber("1463256");
    	c.setPhoneNumber("584123324480");
    	c.setEmail("dorotea@gmail.com");
    	c = customerService.create(c);
        assertNotNull(c.getId());
    }
    
    @Test @Transactional 
    @Commit
    public void testUpdateCustomer() throws Exception {
    	Customer c = customerService.get(2l);
    	Agency a = new Agency();
    	a.setId(2l);
    	c.setAgency(a);
    	c.setName("Doris Barazarte");
    	c.setDocumentNumber("2000000");
    	c.setPhoneNumber("584123324480");
    	c.setEmail("dorotea@gmail.com");
    	c = customerService.update(c);
        assertNotNull(c.getId());
    }
    
    @Test @Transactional 
    @Commit
    public void testGetCustomers() throws Exception {
    	List<Customer> customers = customerService.getAll();
        assertNotNull(customers);
        assertThat(customers,  not(IsEmptyCollection.empty()));
    }

    

}
