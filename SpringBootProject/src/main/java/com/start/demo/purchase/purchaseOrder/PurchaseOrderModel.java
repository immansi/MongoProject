package com.start.demo.purchase.purchaseOrder;
import java.util.List;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.start.demo.product.ProductModel;
import com.start.demo.purchase.party.PurchaseModel;
//import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "PurchaseOrder")
public class PurchaseOrderModel {

	@Id
	private String id;
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderNum;
	private String date;
	private long sum;
	private List<Integer> qty;

	
	private PurchaseModel purchasemodel;
	

	private List<ProductModel> productmodel;
	
	public List<ProductModel> getProductmodel() {
		return productmodel;
	}
	public void setProductmodel(List<ProductModel> productmodel) {
		this.productmodel = productmodel;
	}
	public PurchaseModel getPurchasemodel() {
		return purchasemodel;
	}
	public void setPurchasemodel(PurchaseModel purchasemodel) {
		this.purchasemodel = purchasemodel;
	}
	public PurchaseOrderModel(String id, int orderNum, String date) {
		super();
		this.id = id;
		this.orderNum = orderNum;
		this.date = date;
	}
	public PurchaseOrderModel() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
//	@JsonFormat(pattern="yyyy-MM-dd")
	public String getDate() {
		return date;
	}
	public void setDate(String formattedDate) {
		this.date = formattedDate;
	}
	
	public long getSum() {
		return sum;
	}
	public void setSum(long sum) {
		this.sum = sum;
	}
	public List<Integer> getQty() {
		return qty;
	}
	public void setQty(List<Integer> qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "PurchaseOrderModel [id=" + id + ", orderNum=" + orderNum + ", date=" + date + ", sum=" + sum + ", qty="
				+ qty + "]";
	}
	
	
	
	
	
	
}
