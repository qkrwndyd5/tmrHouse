package com.itwill.tmr_house.cart;

public class CartSQL {
	public static final String CART_INSERT = "insert into cart (c_no, c_qty, m_id, p_no) values (cart_c_no_SEQ.nextval, ?, ?, ?)";
	public static final String CART_UPDATE_BY_CART_NO = "update cart set c_qty = ? where c_no = ?";
	public static final String CART_UPDATE_BY_PRODUCT_NO_ID = "update cart set c_qty = c_qty + ? where m_id = ? and p_no = ?";
	public static final String CART_DELETE_BY_ID = "delete from cart where m_id = ?";
	public static final String CART_DELETE_BY_CART_NO = "delete from cart where c_no = ?";
	public static final String CART_SELECT_BY_CART_NO = "select c.*, p.* from cart c join product p on c.p_no = p.p_no where c_no = ?";
	public static final String CART_SELECT_BY_ID = "select c.*, p.* from cart c join product p on c.p_no = p.p_no where m_id = ? order by c.c_no";
	public static final String CART_COUNT_BY_USERID_PRODUCT_NO = "select count(*) as p_count from cart c join member m on c.m_id = m.m_id where m.m_id = ? and c.p_no= ?";
}
