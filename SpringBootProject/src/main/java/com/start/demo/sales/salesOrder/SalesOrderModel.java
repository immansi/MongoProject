package com.start.demo.sales.salesOrder;


import java.util.List;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import com.start.demo.product.ProductModel;
import com.start.demo.sales.salesParty.SalesPartyModel;


@Document(collation = "SalesOrder")
public class SalesOrderModel {


	@Id
	private String sid;
   

//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int salesNum;
	private String sdate;
	private long gtotal;
	
	
	public long getGtotal() {
		return gtotal;
	}
	public void setGtotal(long gtotal) {
		this.gtotal = gtotal;
	}

	
	private SalesPartyModel salespartymodel;
//	
//	@DBRef
//	private List<ProductModel> productmodel;
//	
	private List<ProductOrder> productorder;
	
	public List<ProductOrder> getProductorder() {
		return productorder;
	}
	public void setProductorder(List<ProductOrder> productorder) {
		this.productorder = productorder;
	}
	public SalesPartyModel getSalespartymodel() {
		return salespartymodel;
	}
	public void setSalespartymodel(SalesPartyModel soma) {
		this.salespartymodel = soma;
	}
//	public List<ProductModel> getProductmodel() {
//		return productmodel;
//	}
//	public void setProductmodel(List<ProductModel> productmodel) {
//		this.productmodel = productmodel;
//	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getSalesNum() {
		return salesNum;
	}
	public void setSalesNum(int salesNum) {
		this.salesNum = salesNum;
	}
	
	
	
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	@Override
	public String toString() {
		return "SalesOrderModel [sid=" + sid + ", salesNum=" + salesNum + ", sdate=" + sdate + "]";
	}
	public SalesOrderModel(String sid, int salesNum, String sdate) {
		super();
		this.sid = sid;
		this.salesNum = salesNum;
		this.sdate = sdate;
	}
	public SalesOrderModel() {
		super();
	}
//	public void setProductorder(ProductOrder po) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
}
