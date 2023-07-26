package com.itwill.tmr_house.product.성민모;

public class ProductSQL {
	public static final String PRODUCT_INSERT = "insert into product values (product_p_no_seq.nextval,?,?,?,?,?)"; // insert 상품추가
	public static final String PRODUCT_DELETE_BY_P_NO = "delete from product where p_no = ?"; // 상품 pk로 삭제
	public static final String PRODUCT_UPDATE = "update product set p_name = ?, p_price = ?, p_img = ?, p_desc = ?, p_freedelivery = ? where p_no = ?"; // update 상품변경
	
}