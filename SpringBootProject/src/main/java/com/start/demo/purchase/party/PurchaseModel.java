package com.start.demo.purchase.party;



//import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "party")
public class PurchaseModel {

	@Id
	private String parid;
	private String parname;
	private int contactno;
	private int openingacc;
	
	//@OneToMany(mappedBy = "PurchaseModel")
//	private List<ProductModel> product;
	public String getParid() {
		return parid;
	}
	public void setParid(String parid) {
		this.parid = parid;
	}
	public String getParname() {
		return parname;
	}
	public void setParname(String parname) {
		this.parname = parname;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	public int getOpeningacc() {
		return openingacc;
	}
	public void setOpeningacc(int openingacc) {
		this.openingacc = openingacc;
	}
	public PurchaseModel(String parid, String parname, int contactno, int openingacc) {
		super();
		this.parid = parid;
		this.parname = parname;
		this.contactno = contactno;
		this.openingacc = openingacc;
	}
	public PurchaseModel() {
		super();
	}
	@Override
	public String toString() {
		return "PurchaseModel [parid=" + parid + ", parname=" + parname + ", contactno=" + contactno + ", openingacc="
				+ openingacc + "]";
	}
	
	
	
}
