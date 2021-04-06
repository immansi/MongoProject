package com.start.demo.sales.salesParty;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesPartyController {

	
	@Autowired
	public SalesPartyService salespartyservice;
	
	@CrossOrigin(origins = "http://localhost:8080")
	
	@GetMapping("/salesparty")
	public List<SalesPartyModel> getAllProduct(){
		//System.out.println(productservice.getAllProduct());
		return salespartyservice.getAllParty();
		}
	
	
	@GetMapping("/salesparty/{saleid}")
	private SalesPartyModel getProduct(@PathVariable("parid") String pid)   {  
		return salespartyservice.getPartyById(pid);  
	}  

	@PostMapping("/salesparty")
	public String createProduct(@RequestBody SalesPartyModel smodel) {
		salespartyservice.addParty(smodel);
		return "Sucessfully added " + smodel.getSalename();		
	}
	

	
	@PutMapping("/salespartyupdate/{saleid}")
	public HashMap<String,SalesPartyModel> updateParty(@PathVariable("saleid") String sid , @RequestBody SalesPartyModel smodel){
		
		return salespartyservice.updateParty(sid,smodel);
	}
	
	@DeleteMapping("/salesparty/{saleid}")
	public String dlt(@PathVariable("saleid") String sid ) {
		salespartyservice.deleteParty(sid);
		return "Deleted successfully" ;
	}
	
}
