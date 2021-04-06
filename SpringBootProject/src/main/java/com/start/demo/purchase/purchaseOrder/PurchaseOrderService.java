package com.start.demo.purchase.purchaseOrder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.start.demo.product.ProductModel;
import com.start.demo.product.ProductService;
import com.start.demo.purchase.party.PurchaseModel;
import com.start.demo.purchase.party.PurchaseService;


@Service
public class PurchaseOrderService {

	@Autowired
	PurchaseOrderRepository purchaseorderrepository ;
	
	@Autowired
	PurchaseService purchaseservice;
	
	@Autowired
	ProductService productservice;
	   int sum=0 ;
	   int total;
	   int grandTotal;
	PurchaseModel purchasemodel = new PurchaseModel();
	ProductModel pow = new ProductModel();
	ProductModel pow1 = new ProductModel();

	List<ProductModel> product_list = new ArrayList<ProductModel>();
	List<ProductModel> product_list_update = new ArrayList<ProductModel>();

	List<Integer> pro_p_list = new ArrayList<Integer>();
//public PurchaseOrderModel Addetails(PurchaseOrderModel purchaseordermodel) {
//	Date date = new Date();
//	String strDateFormat = "hh:mm:ss a";
//	DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
//	String formattedDate= dateFormat.format(date);
//	purchaseordermodel.setDate(formattedDate);
//	return purchaseorderrepository.insert(purchaseordermodel);	
//	}
	
	public List<PurchaseOrderModel> getAllPurchase() {
		return purchaseorderrepository.findAll();
	}
	
	public PurchaseOrderModel Addetails(PurchaseOrderModel purchaseordermodel) {
		//purchaseorderrepository.insert(purchaseordermodel);
		Date date = new Date();
		String strDateFormat = "hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate= dateFormat.format(date);
		purchaseordermodel.setDate(formattedDate);
		
		//PARTY ID 
		purchasemodel = purchaseservice.getPartyById(purchaseordermodel.getPurchasemodel().getParid());
		//line1
		//product
		product_list = purchaseordermodel.getProductmodel();
		for(int i =0;i<product_list.size();i++) {
			String id = purchaseordermodel.getProductmodel().get(i).getProid();
			pow = productservice.getProductById(id);
			product_list_update.add(pow);
		}
		purchaseordermodel.setProductmodel(product_list_update);
//		System.out.println(product_list_update);
	for(int i=0;i<product_list_update.size();i++) {
			// int price = product_list_update.get(i).getPropprice();
			  total=(product_list_update.get(i).getPropprice())*(purchaseordermodel.getQty().get(i));
			 System.out.println(total);
			 pro_p_list.add(total);
		}
		 for (int i: pro_p_list) {
		        sum += i;
		 }
		 purchaseordermodel.setSum(sum);
		 System.out.println(sum);
		 //purchase party
			purchasemodel = purchaseservice.getPartyById(purchaseordermodel.getPurchasemodel().getParid());
			 grandTotal = purchasemodel.getOpeningacc();
			 grandTotal = grandTotal-sum;
			 System.out.println(grandTotal);
			 purchasemodel.setOpeningacc(grandTotal);
			 purchaseservice.updateParty(purchasemodel.getParid(), purchasemodel);
				//line1 
			 purchaseordermodel.setPurchasemodel(purchasemodel);
			 return purchaseorderrepository.save(purchaseordermodel);	
	}
//	public int sum(PurchaseOrderModel purchaseordermodel) {
//		for(ProductModel promodel : product_list) { 
//			   if(promodel.getProid()!=null) { 
//				   pro_p_list.add( pow.getPropprice());
//			   }
//			}
//		
//		    int sum = 0;
//		    for (int i: pro_p_list) {
//		        sum += i;
//		        System.out.println(sum);
//		       return sum;
//		}
////		product_list=purchaseordermodel.getProductmodel();
////		productservice.getProductById(purchaseordermodel.getProductmodel());
//		//return null;
//		
//	}
	public Optional<PurchaseOrderModel> getPurchaseOrderById(String puid) {
		return purchaseorderrepository.findById(puid);
	
	}
	
	public void deletePurchase(String pid) {
		purchaseorderrepository.deleteById(pid); 
		
	}
}
