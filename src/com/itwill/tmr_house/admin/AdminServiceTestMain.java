package com.itwill.tmr_house.admin;

import com.itwill.tmr_house.product.Product;

public class AdminServiceTestMain {

	public static void main(String[] args) throws Exception {
		AdminService adminService = new AdminService();
		int rowCount =0;
		//회원전체리스트
		System.out.println(adminService.adMemberListAll());
		//주문전체리스트 //오더서비스에 findAll() 메소드 추가 //sql문 추가
		//System.out.println(adminService.adOrderListAll());
		//상품추가
		rowCount =adminService.adProductInsert(new Product(0,"고구마인형",10000,null,"귀여운인형","Y"));
		System.out.println(rowCount);
		//상품삭제
		rowCount =adminService.adProductDelete(3); //테이블 생성 Product참조fk on delete cascade 추가 
		System.out.println(rowCount);
		//상품업데이트
		rowCount =adminService.adProductUpdate(new Product(1,"사과인형",10000,null,"귀여운인형","Y"));
		System.out.println(rowCount);
	}

}
