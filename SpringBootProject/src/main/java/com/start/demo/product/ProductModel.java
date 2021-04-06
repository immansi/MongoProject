package com.start.demo.product;

//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "product")
public class ProductModel {

	@Id
	private String proid;
	private String proname;
	private String prodes;
	private int propprice;
	private int prosprice;
	private int proostock;

	//@ManyToOne
	// @JoinColumn(name="partyBuyProduct")
	//private PurchaseModel purchasemodel;
	
	public ProductModel(String proid, String proname, String prodes, int propprice, int prosprice, int proostock) {
		super();
		this.proid = proid;
		this.proname = proname;
		this.prodes = prodes;
		this.propprice = propprice;
		this.prosprice = prosprice;
		this.proostock = proostock;
	}


	public ProductModel() {
		super();
	}


	@Override
	public String toString() {
		return "ProductModel [proid=" + proid + ", proname=" + proname + ", prodes=" + prodes + ", propprice="
				+ propprice + ", prosprice=" + prosprice + ", proostock=" + proostock + "]";
	}


	public ProductModel(String proname, String prodes, int propprice, int prosprice, int proostock) {
		super();
		this.proname = proname;
		this.prodes = prodes;
		this.propprice = propprice;
		this.prosprice = prosprice;
		this.proostock = proostock;
	}


	public String getProid() {
		return proid;
	}


	public void setProid(String proid) {
		this.proid = proid;
	}


	public String getProname() {
		return proname;
	}


	public void setProname(String proname) {
		this.proname = proname;
	}


	public String getProdes() {
		return prodes;
	}


	public void setProdes(String prodes) {
		this.prodes = prodes;
	}


	public int getPropprice() {
		return propprice;
	}


	public void setPropprice(int propprice) {
		this.propprice = propprice;
	}


	public int getProsprice() {
		return prosprice;
	}


	public void setProsprice(int prosprice) {
		this.prosprice = prosprice;
	}


	public int getProostock() {
		return proostock;
	}


	public void setProostock(int proostock) {
		this.proostock = proostock;
	}
	
}
