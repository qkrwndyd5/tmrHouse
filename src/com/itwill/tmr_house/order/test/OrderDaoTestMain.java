package com.itwill.tmr_house.order.test;

import java.util.ArrayList;

import com.itwill.tmr_house.order.OrderItem;
import com.itwill.tmr_house.order.Orders;
import com.itwill.tmr_house.order.OrdersDao;
import com.itwill.tmr_house.product.Product;

public class OrderDaoTestMain {
	public static void main(String[] args) throws Exception {
		OrdersDao ordersDao = new OrdersDao();
		/*
		 *  주문 생성 
		 *  - ccc 님이 제품번호 1번 1개 2번 2개 주문
		 */
		/*int rowCount = ordersDao.insertOrder(new Orders(0, "스틸원형 테이블 외 1건", 1, 300000, null, "cccc"));
		System.out.println(">> " + rowCount + "주문 삽입");
		
		
		 *  주문번호로 주문 삭제
		 
		
		rowCount = ordersDao.deleteByOrderNo(4);
		System.out.println(">> " + rowCount + "주문 삭제");
		
		 
		 
		  * 회원아이디로 주문 전체삭제
		  
		 
		rowCount = ordersDao.deleteByMemberId("cccc");
		System.out.println(">> cccc 회원님 주문 " + rowCount + "건 삭제");*/

		/*
		 * 고객아이디로 주문리스트 불러오기
		 */

		//System.out.println(ordersDao.findById("cccc"));

		/*
		 * 고객 아이디 , 주문번호로 주문 1개 보기
		 */

		System.out.println(ordersDao.findByOrderNo("aaaa", 1));
		// 현재 고객아이디 , 주문번호로 주문1개 보기 시 주문생성에서 insert 해준 주문의 경우 product 정보가 없어서 주문리스트는 불러올
		// 수 있으나 고객아이디, 주문번호로 주문1개 보기는 불가능함

	}
}
