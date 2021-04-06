package com.start.demo.product;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {

	@Autowired
	ProductRepository productrepository ;
	HashMap<String,ProductModel> map = new HashMap<String,ProductModel>();
	
	public List<ProductModel> getAllProduct() {
		return productrepository.findAll();
	}

	public ProductModel getProductById(String pid) {
		
		Optional<ProductModel> optionalparty = productrepository.findById(pid);
		return optionalparty.get();

	
	}

	public void addProduct(ProductModel pmodel) {
		productrepository.save(pmodel);
	}

//	public HashMap<String, ProductModel> updateProduct(String id, ProductModel pmodel) {
//		java.util.Optional<ProductModel> rt = productrepository.findById(id);
//
//		  if (rt.isPresent()) {
//			  ProductModel st = rt.get();
//		    st.setProname(pmodel.getProname());
//		   st.setProdes(pmodel.getProdes());
//		  st.setPropprice(pmodel.getPropprice());
//		  st.setPropprice(pmodel.getPropprice());
//		  st.setProsprice(pmodel.getProsprice());
//		  st.setProostock(pmodel.getProostock());
//		  pmodel = productrepository.save(st);
//		  map.put("Updated", st);
//		  return map;
//		  }else {
//			  map.put("null", null);
//			  return map;
//		  }
//	}

	public void deleteProduct(String pid) {
		productrepository.deleteById(pid); 
		
	}

}
