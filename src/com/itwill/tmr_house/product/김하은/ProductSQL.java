package com.itwill.tmr_house.product.김하은;

public class ProductSQL {
	
	public static final String PRODUCT_SELECT_BY_P_NO=
			"select * from product where p_no = ?";
	
	public static final String PRODUCT_SELECT_ALL =
			"select * from product";
	public static final String PRODUCT_SELECT_BY_P_NAME = "select p_name, p_price , p_img, p_desc from product where p_name like ? ";
}
