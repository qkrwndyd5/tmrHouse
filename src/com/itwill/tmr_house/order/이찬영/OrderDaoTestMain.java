package com.itwill.tmr_house.order.이찬영;

import java.util.ArrayList;

import com.itwill.tmr_house.order.Orders;
import com.itwill.tmr_house.product.성민모.Product;


public class OrderDaoTestMain {

	public static void main(String[] args) throws Exception{
		OrderDao orderDao=new OrderDao();
		orderDao.insert(new Order());
		
	/*****************주문실행*******************/	
		// 1. order 셋팅
		Order order = new Order();
		order.setO_desc("장롱 외 1개");	// 비고
		order.setO_price(1000);			// 가격
		order.setM_id("bbbb");		// 사용자번호
		// 2. orderItem 셋팅
		OrderItem orderItem = new OrderItem();
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		orderItem.setOi_qty(1);			// 수량
		orderItem.setProduct(new Product(1, "", 0, "", "", ""));	// 상품번호
		orderItemList.add(orderItem);
		order.setOrderItemList(orderItemList);
		// 3. 저장
		int rowCount =orderDao.insert(order);
		System.out.println(rowCount);
	/****************주문번호로 주문1건삭제*******************/
		rowCount =orderDao.deleteByOrderNo(2);
		System.out.println(rowCount);
	/****************아이디로 주문전체 삭제*******************/	
		rowCount =orderDao.deleteById("aaaa");
		System.out.println(rowCount);
	/****************주문 1개보기 고객아이디,주문번호*******************/		
	System.out.println(orderDao.findByOrderNo("aaaa",20)); 
	/****************유저 아이디로 주문리스트 불러오기*******************/		
	ArrayList<Order> ordersList = orderDao.findById("bbbb");
	System.out.println(orderItemList);
	
	
	}

}
