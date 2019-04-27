package com.consultech.concessionairemanager.controller;




import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.consultech.concessionairemanager.model.Agency;
import com.consultech.concessionairemanager.service.AgencyService;
import com.consultech.concessionairemanager.service.CustomerService;


@Scope (value = "session")
@Controller
@ELBeanName(value = "main")
public class MainController {

	@Autowired
	private AgencyService agencyService;
	
	public MainController() {
		
	}
	@RequestMapping(value = "/index")
	public String index() {
		return "customer";
	}
	

    
    @RequestMapping(value = "/customer",  method = RequestMethod.GET)
	public String showCustomerView() {
		return "customer";
	}
    
//	@RequestMapping(value = "/report", params = "id",  method = RequestMethod.GET)
//	public String showReportView() {
//		return "report";
//	}
	//Preferiblemente un parse con json pero para agilizar
	@RequestMapping(value = "/agencies",  method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Agency> showAgencyUtilView(@RequestParam("id") Long id) {
		List<Agency> agencies = new ArrayList();
		if(id != null)
		  agencies = agencyService.getByLocationId(new Long(id));
		  
		  return agencies;
	}
	
	
	
}
