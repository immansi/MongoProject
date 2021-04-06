package com.start.demo.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	public ProductService productservice;
	
	@CrossOrigin(origins = "http://localhost:8080")
	
	@GetMapping("/products")
	public List<ProductModel> getAllProduct(){
		//System.out.println(productservice.getAllProduct());
		return productservice.getAllProduct();
		}
	
	
	@GetMapping("/products/{pro_id}")
	private ProductModel getProduct(@PathVariable("pro_id") String pid)   {  
		return productservice.getProductById(pid);  
	}  

	@PostMapping("/products")
	public String createProduct(@RequestBody ProductModel pmodel) {
		productservice.addProduct(pmodel);
		return "Sucessfully added " + pmodel.getProname();		
	}
	
//	@PutMapping("/products/{pro_id}")
//	public String updateP(@PathVariable("pro_id") String pid,@RequestBody ProductModel pmodel) {
//		productservice.updateProduct(pid,pmodel);
//		return "Updated successfully";
//	}
	
//	
//	@PutMapping("/update/{id}")
//	public HashMap<String,ProductModel> updateProduct(@PathVariable("id") String id , @RequestBody ProductModel pmodel){
//		
//		return productservice.updateProduct(id,pmodel);
//	}
	
	@DeleteMapping("/products/{pro_id}")
	public String dlt(@PathVariable("pro_id") String pid ) {
		productservice.deleteProduct(pid);
		return "Deleted successfully" ;
	}
	
	
}
