package com.itwill.tmr_house.order.박주용;

import java.util.ArrayList;

import com.itwill.tmr_house.product.김혜지.Product;


public class OrderDaoTestMain {
	public static void main(String[] args) throws Exception{
		OrderDao orderDao = new OrderDao();
		
		/*
		 * 주문생성
		 */
		Order order = new Order();
		order.setO_desc("장롱 외 1개");
		order.setO_price(20000);
		order.setM_id("cccc");
		
		OrderItem orderItem = new OrderItem();
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		orderItem.setOi_qty(1);
		orderItem.setProduct(new Product(1,"", 0, "", "", ""));
		
		orderItemList.add(orderItem);
		
		order.setOrderItemList(orderItemList);
		
		orderDao.insertOrder(order);
		
		/*
		 * 주문번호로 주문삭제
		 */
		System.out.println("2. 주문번호로 주문1개 삭제");
		System.out.println(orderDao.deleteByOrderNo(1));
		
		/*
		 * 아이디로 주문삭제
		 */
		System.out.println(orderDao.deleteByMemberId("aaaa"));
		
		/*
		 * 주문 1개 찾기
		 */		
		System.out.println(orderDao.findByOrderNo("bbbb", 2));
		
		/*
		 * 주문 전체 검색
		 */
		
		System.out.println("주문 전체 검색");
		ArrayList<Order> orderList = orderDao.findByMemberId("aaaa");
		for(Order orders : orderList) {
			System.out.println(orders.getO_no() +"\t"+
							   orders.getO_desc() +"\t" +
							   orders.getO_qty() +"\t"+
							   orders.getO_price() +"\t"+
							   orders.getO_date() +"\t"+
							   orders.getM_id() +"\t");
		}
		
		
		
		
		
	}
}
