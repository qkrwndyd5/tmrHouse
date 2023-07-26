package com.itwill.tmr_house.order.이찬영;

import java.util.List;

import com.itwill.tmr_house.cart.김혜지.CartDao;


public class OrderServiceTestMain {

	public static void main(String[] args) throws Exception {
		OrdersService orderService = new OrdersService();
		CartDao cartDao = new CartDao();
		int rowCount = 0;
		// 주문 한개 삭제
		rowCount = orderService.deleteByOrderNo(2);

		// 주문 전체 삭제
		rowCount = orderService.deleteByM_id("aaaa");
		System.out.println(rowCount + "개 주문삭제");

		// 주문리스트 아이디로 찾기
		System.out.println(orderService.orderList("aaaa"));

		// 주문상세보기
		System.out.println(orderService.orderListDetail("aaaa", 1));

		// 상품에서 직접주문
		rowCount = orderService.directOrder("bbbb", 2, 9);
		System.out.println(rowCount + "개 주문");

		// 카트에서주문
		rowCount = orderService.cartOrder("bbbb");
		System.out.println(rowCount + "개 주문");

		// 카트에서 선택주문
		String[] cart_item_checks = { "16", "15" };// 카트번호
		rowCount = orderService.cartSelectOrder("bbbb", cart_item_checks);
		System.out.println(rowCount + "개 주문");
	}

}
