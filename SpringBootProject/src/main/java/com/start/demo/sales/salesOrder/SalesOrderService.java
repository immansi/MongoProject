package com.start.demo.sales.salesOrder;

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
import com.start.demo.sales.salesParty.SalesPartyModel;
import com.start.demo.sales.salesParty.SalesPartyService;

@Service
public class SalesOrderService {
	
	@Autowired
	private SalesOrderRepository salesorderrepository;
	
	@Autowired
	private SalesPartyService salespartyservice;
	
	@Autowired
	private ProductService opo;
	long gtotal,o;
	int qnt,total;
	SalesPartyModel som = new SalesPartyModel();
	List<ProductOrder> pro_olist = new ArrayList<ProductOrder>();
	List<Long> total_list = new ArrayList<Long>();
	ProductModel pmodel = new ProductModel();
	public List<SalesOrderModel> getAllSales(){
		return salesorderrepository.findAll();
	}
	public SalesOrderModel Addetails(SalesOrderModel salesordermodel) {
		Date date = new Date();
		String strDateFormat = "hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate= dateFormat.format(date);
		salesordermodel.setSdate(formattedDate);
		som = salespartyservice.getPartyById(salesordermodel.getSalespartymodel().getSaleid());
		salesordermodel.setSalespartymodel(som);
		
		
		for(int i =0;i<salesordermodel.getProductorder().size();i++) {
			//ProductOrder po = new ProductOrder(salesordermodel.getProductorder().get(i).getQty(),salesordermodel.getProductorder().get(i).getTotal(opo.getProductById(salesordermodel.getProductorder().get(i).getProductmodel1().getProid())),opo.getProductById(salesordermodel.getProductorder().get(i).getProductmodel1().getProid()));
			
			pmodel = opo.getProductById(salesordermodel.getProductorder().get(i).getProductmodel1().getProid());
			 qnt = salesordermodel.getProductorder().get(i).getQty();
			 total = qnt*pmodel.getProsprice();
			ProductOrder po = new ProductOrder(qnt,total,pmodel);
			pro_olist.add(po);
			o = pro_olist.get(i).getTotal();
			total_list.add(o);
		}	
//		for(int i =0;i<pro_olist.size();i++) {
//			 o = pro_olist.get(i).getTotal();
//			total_list.add(o);
//		}
		 for (Long k: total_list) {
		        gtotal += k;
		 }
		salesordermodel.setProductorder(pro_olist);
		salesordermodel.setGtotal(gtotal);
		
		//updateing in salesparty opening account7
		
		long oaccount = salesordermodel.getSalespartymodel().getSaleopeningacc();
		oaccount=oaccount-gtotal;
		som.setSaleopeningacc(oaccount);
		System.out.println(salesordermodel.getSalespartymodel().getSaleid());
		salespartyservice.updateParty(salesordermodel.getSalespartymodel().getSaleid(), som);
		salesordermodel.setSalespartymodel(som);
		return salesorderrepository.save(salesordermodel);	
	}
	public Optional<SalesOrderModel> getSalesById(String sid){
		return salesorderrepository.findById(sid);
	}
	public void deleteSalesById(String sid) {
		salesorderrepository.deleteById(sid);
		
	}

}
