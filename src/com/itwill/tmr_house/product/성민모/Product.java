package com.itwill.tmr_house.product.성민모;

public class Product {
	private int p_no;             //상품번호
	private String p_name;        //상품이름
	private int p_price;          //상품가격
	private String p_img;         //상품이미지
	private String p_desc;        //상품소재지
	private String p_freeDelivery;//무료배달서비스	
	
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