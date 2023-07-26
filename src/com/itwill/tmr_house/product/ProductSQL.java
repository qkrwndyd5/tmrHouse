package com.itwill.tmr_house.product;

public class ProductSQL {
	public static final String PRODUCT_INSERT = "insert into product values (product_p_no_seq.nextval,?,?,?,?,?)";
	public static final String PRODUCT_DELETE_BY_P_NO = "delete from product where p_no = ?";
	public static final String PRODUCT_UPDATE = "update product set p_name = ?, p_price = ?, p_img = ?, p_desc = ?, p_freedelivery = ? where p_no = ?";
	public static final String PRODUCT_SELECT_BY_P_NO = "select * from product where p_no = ?";
	public static final String PRODUCT_SELECT_ALL = "select * from product";
	public static final String PRODUCT_SELECT_BY_P_NAME = "select * from product where p_name like ? ";
}