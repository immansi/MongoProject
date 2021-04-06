package com.start.demo.sales.salesParty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "salesParty")
public class SalesPartyModel {
	
	@Id
	private String saleid;
	private String salename;
	private int salecontactno;
	private long saleopeningacc;
	public String getSaleid() {
		return saleid;
	}
	public void setSaleid(String saleid) {
		this.saleid = saleid;
	}
	public String getSalename() {
		return salename;
	}
	public void setSalename(String salename) {
		this.salename = salename;
	}
	public int getSalecontactno() {
		return salecontactno;
	}
	public void setSalecontactno(int salecontactno) {
		this.salecontactno = salecontactno;
	}
	public long getSaleopeningacc() {
		return saleopeningacc;
	}
	public void setSaleopeningacc(long oaccount) {
		this.saleopeningacc = oaccount;
	}
	public SalesPartyModel(String saleid, String salename, int salecontactno, int saleopeningacc) {
		super();
		this.saleid = saleid;
		this.salename = salename;
		this.salecontactno = salecontactno;
		this.saleopeningacc = saleopeningacc;
	}
	public SalesPartyModel() {
		super();
	}
	@Override
	public String toString() {
		return "SalesPartyModel [saleid=" + saleid + ", salename=" + salename + ", salecontactno=" + salecontactno
				+ ", saleopeningacc=" + saleopeningacc + "]";
	}
	
	
	
}
