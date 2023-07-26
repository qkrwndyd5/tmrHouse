package com.itwill.tmr_house.cart.성민모;

public class CartSQL {
	
	public static final String CART_UPDATE_BY_CART_NO = "update cart set c_qty = ? where c_no = ?";
	public static final String CART_UPDATE_BY_PRODUCT_NO_ID = "update cart set c_qty = c_qty + ? where m_id = ? and p_no = ?";
	public static final String CART_COUNT_BY_USERID_PRODUCT_NO = "select count(*) as p_count from cart c join member m on c.m_id = m.m_id where m.m_id = ? and c.p_no= ?";
	}
