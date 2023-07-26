package com.itwill.tmr_house.order.김하은;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itwill.tmr_house.order.OrderItem;

public class Orders {
	private int o_no;
	private String o_desc;
	private int o_qty;
	private int o_price;
	private Date o_date;
	private String m_id;
	private List<OrderItem> orderItemList;
	
	public Orders() {
		orderItemList = new ArrayList<OrderItem>();
	}

	public Orders(int o_no, String o_desc, int o_qty, int o_price, Date o_date, String m_id) {
		super();
		this.o_no = o_no;
		this.o_desc = o_desc;
		this.o_qty = o_qty;
		this.o_price = o_price;
		this.o_date = o_date;
		this.m_id = m_id;
		this.orderItemList = new ArrayList<OrderItem>();
	}

	public int getO_no() {
		return o_no;
	}

	public void setO_no(int o_no) {
		this.o_no = o_no;
	}

	public String getO_desc() {
		return o_desc;
	}

	public void setO_desc(String o_desc) {
		this.o_desc = o_desc;
	}

	public int getO_qty() {
		return o_qty;
	}

	public void setO_qty(int o_qty) {
		this.o_qty = o_qty;
	}

	public int getO_price() {
		return o_price;
	}

	public void setO_price(int o_price) {
		this.o_price = o_price;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}



	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	@Override
	public String toString() {
		return "Orders [o_no=" + o_no + ", o_desc=" + o_desc + ", o_qty=" + o_qty + ", o_price=" + o_price + ", o_date="
				+ o_date + ", m_id=" + m_id + ", orderItemList=" + orderItemList + "]";
	}

}
