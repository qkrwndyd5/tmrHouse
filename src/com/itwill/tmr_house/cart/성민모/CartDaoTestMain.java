package com.itwill.tmr_house.cart.성민모;

public class CartDaoTestMain {
	
	public static void main(String[] args) throws Exception {
	CartDao cartDao = new CartDao();
	
	/*
	 * update, count
	 */
	
	//카트에 존재하는 상품을 추가(수량 변경)
	System.out.println("Cart_updateByCartNo");
	System.out.println(">> " + cartDao.updateByCartNo(6, 10));
	
	System.out.println("Cart_updateByProductNo");
	System.out.println(">> " + cartDao.updateByProductNo(2, 10, "bbbb"));
	
	//카트에 재품 존재하는지 확인
	System.out.println("Cart_countByProductNo");
	System.out.println(">> " + cartDao.countByProductNo("cccc", 1));
	
    }
}		