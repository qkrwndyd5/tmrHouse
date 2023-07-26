package com.itwill.tmr_house.order.test;

import com.itwill.tmr_house.order.OrdersService;

public class OrderServiceTestMain {

	public static void main(String[] args) throws Exception {
		OrdersService ordersService = new OrdersService();
		
		// 주문 한개 삭제(주문번호)
		int rowCount = ordersService.deleteByOrderNo(11);
		System.out.println(">> " + rowCount + "건 주문 삭제");
		
		// 아이디로 주문 전체삭제
		rowCount = ordersService.deleteByM_id("cccc");
		System.out.println(">> cccc님 주문" + rowCount + "건 삭제" );
		
		// 주문리스트 아이디로 찾기
		System.out.println(ordersService.orderList("aaaa"));
		
		// 주문 상세보기
		System.out.println(ordersService.orderListDetail("aaaa",1));
		
		// 카트에서 주문
		rowCount = ordersService.cartOrder("bbbb");
		System.out.println(">> " + rowCount + "개 주문");
		
		// 카트에서 선택주문
		String[] cart_item_checks = {"1"};
		rowCount = ordersService.cartSelectOrder("aaaa",cart_item_checks);
		System.out.println("aaaa님" + rowCount + "개 주문");
		
		// 상품페이지에서 바로주문
		
		System.out.println(ordersService.directOrder("aaaa", 1, 1));
		
		
		
	}

}
