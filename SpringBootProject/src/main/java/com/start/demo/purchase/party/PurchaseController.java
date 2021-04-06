package com.start.demo.purchase.party;

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
public class PurchaseController {


	@Autowired
	public PurchaseService purchaseservice;
	
	@CrossOrigin(origins = "http://localhost:8080")
	
	@GetMapping("/purchaseparty")
	public List<PurchaseModel> getAllProduct(){
		//System.out.println(productservice.getAllProduct());
		return purchaseservice.getAllParty();
		}
	
	
	@GetMapping("/purchaseparty/{parid}")
	private PurchaseModel getProduct(@PathVariable("parid") String pid)   {  
		return purchaseservice.getPartyById(pid);  
	}  

	@PostMapping("/purchaseparty")
	public String createProduct(@RequestBody PurchaseModel pumodel) {
		purchaseservice.addParty(pumodel);
		return "Sucessfully added " + pumodel.getParname();		
	}
	
//	@PutMapping("/products/{pro_id}")
//	public String updateP(@PathVariable("pro_id") String pid,@RequestBody ProductModel pmodel) {
//		productservice.updateProduct(pid,pmodel);
//		return "Updated successfully";
//	}
	
	
	@PutMapping("/purchasepartyupdate/{parid}")
	public HashMap<String,PurchaseModel> updateParty(@PathVariable("parid") String id , @RequestBody PurchaseModel pumodel){
		
		return purchaseservice.updateParty(id,pumodel);
	}
	
	@DeleteMapping("/purchaseparty/{parid}")
	public String dlt(@PathVariable("parid") String pid ) {
		purchaseservice.deleteParty(pid);
		return "Deleted successfully" ;
	}
	
}
