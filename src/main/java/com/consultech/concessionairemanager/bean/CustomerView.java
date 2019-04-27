package com.consultech.concessionairemanager.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.consultech.concessionairemanager.exception.BadRequestAlertException;
import com.consultech.concessionairemanager.exception.EntityNotFoundException;
import com.consultech.concessionairemanager.model.Agency;
import com.consultech.concessionairemanager.model.Customer;
import com.consultech.concessionairemanager.model.Location;
import com.consultech.concessionairemanager.model.enumeration.CustomerStatus;
import com.consultech.concessionairemanager.service.AgencyService;
import com.consultech.concessionairemanager.service.CustomerService;
import com.consultech.concessionairemanager.service.LocationService;

@ManagedBean
@Component 
public class CustomerView {
	
	public static final String DISABLE_ACTION = "DISABLE";
	
	public static final String ENABLE_ACTION = "ENABLE";
	
	public static final String DELETE_ACTION = "DELETE";

	private Customer customer;
	
	private List customers;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AgencyService agencyService;
	
	@Autowired
	private LocationService locationService;
	
	private List<Agency> agencies;
	
	private List<Location> locations;
	
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	//TODO ADD PAGINATION
	public void init() {
		loadLocations();
		loadCustomers();
		
	}	
	
	public void loadLocations() {
		locations = locationService.getAll();
	}
	
	public void loadCustomers() {
		customers = customerService.getAll();
	}
	
	public void loadAgencies() {
		String locationId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("locationId");
		if(locationId == null) agencies = new ArrayList<>();
		else agencies = agencyService.getByLocationId(new Long(locationId));
	}
	
	public void loadAgencies(Long locationId) {
		if(locationId == null) agencies = new ArrayList<>();
		else agencies = agencyService.getByLocationId(locationId);
	}
	
	@RequestMapping(value = "/customer/save",  method = RequestMethod.POST, produces = "application/json")
	public void addCustomer(@RequestParam("customer")  Customer customer) {
	    FacesMessage message = null;
	    boolean success = false;
	    if(validateCustomer(customer)) {
	    	try {
				if(customer.getId() == null) {
					customerService.create(customer);
				}else {
					customerService.update(customer);
				}
		        FacesContext.getCurrentInstance().addMessage(null, message);
		        PrimeFaces.current().ajax().addCallbackParam("success", success);
			} catch (BadRequestAlertException e) {
				//TODO SEND DIALOG WITH ERROR
			} catch (EntityNotFoundException e) {
				// TODO SEND DIALOG WITH ERROR
			}
	    }
	}
	
	private boolean validateCustomer(Customer customer2) {
		// TODO IMPLEMENTAR, VALIDAR SI CLIENTE NO ESTA REGISTRADO, ETC
		return true;
	}

	public void updateCustomer(Customer customer) {
		
	}
	
	
	public void changeCustomerStatus(long id, CustomerStatus status) {
		Customer customer = customerService.get(id);
		try {
			switch (status) {
			case DISABLE:
				customer.setStatus(CustomerStatus.DISABLE);
			case ENABLE:
				customer.setStatus(CustomerStatus.ENABLE);
				customerService.update(customer);
				break;
			case DELETED:
				customer.setStatus(CustomerStatus.DELETED);
				customerService.delete(id);

			}
		} catch (BadRequestAlertException e) {
			//TODO SEND DIALOG WITH ERROR
			
		} catch (EntityNotFoundException e) {
			//TODO SEND DIALOG WITH ERROR
			
		}
	}
	
	
	public Customer getCustomer() {
		customer = new Customer();
		Agency agency = new Agency();
		Location location = new Location();
		agency.setLocation(location);
		customer.setAgency(agency);
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List getCustomers() {
		return customers;
	}

	public void setCustomers(List customers) {
		this.customers = customers;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public AgencyService getAgencyService() {
		return agencyService;
	}

	public void setAgencyService(AgencyService agencyService) {
		this.agencyService = agencyService;
	}

	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public List<Agency> getAgencies() {
		return agencies;
	}

	public void setAgencies(List<Agency> agencies) {
		this.agencies = agencies;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	
	
	

}
