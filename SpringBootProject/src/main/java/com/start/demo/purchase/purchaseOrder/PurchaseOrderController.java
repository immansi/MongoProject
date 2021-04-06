package com.start.demo.purchase.purchaseOrder;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PurchaseOrderController {

	@Autowired
	PurchaseOrderService purchaseorderservice;
	
	@GetMapping("/purchaseorder")
	public List<PurchaseOrderModel> getAllPurchase(){
		//System.out.println(productservice.getAllProduct());
		
		return purchaseorderservice.getAllPurchase();
		}
	@GetMapping("/purchaseorder/{id}")
	private Optional<PurchaseOrderModel> getPurchase(@PathVariable("id") String puid)   {  
		return purchaseorderservice.getPurchaseOrderById(puid);  
	}  
	
	@PostMapping("/purchaseorder")
	public String addnum(@RequestBody PurchaseOrderModel pom ) {
		purchaseorderservice.Addetails(pom);
		return "Added Successfully " + pom.getOrderNum()+" "+pom.getDate();
	}
	@DeleteMapping("/purchaseorder/{id}")
	public String dlt(@PathVariable("id") String puid ) {
		purchaseorderservice.deletePurchase(puid);
		return "Deleted successfully" ;
	}

}
