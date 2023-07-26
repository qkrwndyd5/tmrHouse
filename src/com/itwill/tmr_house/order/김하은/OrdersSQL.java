package com.itwill.tmr_house.order.김하은;

public class OrdersSQL {
	public final static String ORDERS_INSERT = "insert into orders(o_no, o_desc, o_qty, o_price, o_date,m_id) values(orders_o_no_SEQ.nextval,?,?,?,sysdate,?)";
	public final static String ORDERS_ITEM_INSERT = "insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval,?,orders_o_no_SEQ.currval,?)";
	public final static String ORDERS_DELETE_BY_M_ID = "delete from orders where m_id=?";
	public final static String ORDERS_DELETE_BY_O_NO = "delete from orders where o_no=?";
	public final static String ORDERS_SELECT_BY_M_ID = "select * from orders where m_id = ?";
	public final static String ORDERS_SELECT_WITH_PRODUCT_BY_M_ID = "select * from orders o join order_item oi on o.o_no = oi.o_no join product p on oi.p_no = p.p_no where o.m_id=? and o.o_no=?";
}
