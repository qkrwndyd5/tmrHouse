package com.itwill.tmr_house.cart.김혜지;

import com.itwill.tmr_house.product.김혜지.Product;

public class CartDaoTestMain {

	public static void main(String[] args) throws Exception {
		CartDao cartDao = new CartDao();
		
		//카트에 새로운 상품 추가
		System.out.println("1. Cart_insertCartItem");
		System.out.println(">> "+ cartDao.insertCart(new Cart(2, 2, "aaaa", new Product(2, null, 0, null, null, null))));

		/*
		 * updateByCartNo, countByProductNo
		 */
		
		//카트에 담긴 특정 상품 삭제
		System.out.println("5. Cart_deleteByCartNo");
		System.out.println(">> "+cartDao.deleteByCartNo(17));
		
		//회원의 카트에 담긴 상품 전체 삭제
		System.out.println("6. Cart_deleteAll");
		System.out.println(">> "+cartDao.deleteByUserId("aaaa"));
		
		//카트에 담긴 특정 상품 찾기(카트 번호로)
		System.out.println("7. Cart_findByCartNo");
		System.out.println(">> "+cartDao.findByCartNo(30));
		
		//회원의 카트에 담긴 상품 전체 찾기
		System.out.println("8. Cart_findByUserId");
		System.out.println(">> "+cartDao.findByUserId("bbbb"));

	}

}
