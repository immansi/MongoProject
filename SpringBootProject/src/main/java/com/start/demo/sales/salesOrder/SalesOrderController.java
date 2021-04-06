package com.start.demo.sales.salesOrder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;
@RestController
public class SalesOrderController {
	
	@Autowired
	private SalesOrderService salesorderservice;
	
	@GetMapping("/sales")
	public List<SalesOrderModel> getall() {
		return salesorderservice.getAllSales();
		
	}
	
	@GetMapping("/sales/{sid}")
	public Optional<SalesOrderModel> getallbyid(@PathVariable("sid") String sid){
		return salesorderservice.getSalesById(sid);
	}
	@PostMapping("/salesOrder")
	public String addnum(@RequestBody SalesOrderModel som ) {
		salesorderservice.Addetails(som);
		return "Added Successfully " + som.getSalesNum()+" "+som.getSdate();
	}
	@DeleteMapping("/sales/{sid}")
	public void dltsalesbyid(@PathVariable("sid") String sid) {
		
	}

}
