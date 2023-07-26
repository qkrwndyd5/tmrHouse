package com.itwill.tmr_house.product.김혜지;

/*
이름             널?       유형            
-------------- -------- ------------- 
P_NO           NOT NULL NUMBER(10)    
P_NAME                  VARCHAR2(50)  
P_PRICE                 NUMBER(10)    
P_IMG                   VARCHAR2(50)  
P_DESC                  VARCHAR2(512) 
P_FREEDELIVERY          VARCHAR2(50) 
*/
public class Product {
	private int p_no;
	private String p_name;
	private int p_price;
	private String p_img;
	private String p_desc;
	private String p_freeDelivery;
	

public Product() {
	// TODO Auto-generated constructor stub
}


public Product(int p_no, String p_name, int p_price, String p_img, String p_desc, String p_freeDelivery) {
	super();
	this.p_no = p_no;
	this.p_name = p_name;
	this.p_price = p_price;
	this.p_img = p_img;
	this.p_desc = p_desc;
	this.p_freeDelivery = p_freeDelivery;
}


public int getP_no() {
	return p_no;
}


public void setP_no(int p_no) {
	this.p_no = p_no;
}


public String getP_name() {
	return p_name;
}


public void setP_name(String p_name) {
	this.p_name = p_name;
}


public int getP_price() {
	return p_price;
}


public void setP_price(int p_price) {
	this.p_price = p_price;
}


public String getP_img() {
	return p_img;
}


public void setP_img(String p_img) {
	this.p_img = p_img;
}


public String getP_desc() {
	return p_desc;
}


public void setP_desc(String p_desc) {
	this.p_desc = p_desc;
}


public String getP_freeDelivery() {
	return p_freeDelivery;
}


public void setP_freeDelivery(String p_freeDelivery) {
	this.p_freeDelivery = p_freeDelivery;
}


@Override
public String toString() {
	return "Product [p_no=" + p_no + ", p_name=" + p_name + ", p_price=" + p_price + ", p_img=" + p_img + ", p_desc="
			+ p_desc + ", p_freeDelivery=" + p_freeDelivery + "]"+"\n";
}



}
