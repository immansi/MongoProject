package com.start.demo.sales.salesOrder;

//import java.util.ArrayList;

import com.start.demo.product.ProductModel;

public class ProductOrder {

	private int qty;
	private long total;
	private ProductModel productmodel1;

	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
//	public long getTotal(ProductModel productmodel2) {
//		//String id = productmodel2.getProid();
//		System.out.println(productmodel2);
//		int yo=productmodel2.getPropprice();
//		System.out.println(yo);
//		int q = getQty();
//		sum=yo*q;
//		return sum;
//	}
//	public void setTotal(long total) {
//		this.total = total;
//	}
	public ProductModel getProductmodel1() {
		return productmodel1;
	}
	
	public void setProductmodel1(ProductModel productmodel1) {
		this.productmodel1 = productmodel1;
	}
	public ProductOrder(int qty, long total, ProductModel productmodel1) {
		super();
		this.qty = qty;
		this.setTotal(total);
		this.productmodel1 = productmodel1;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
}
