package com.itwill.tmr_house.cart.김혜지;

import com.itwill.tmr_house.product.김혜지.Product;

public class CartServiceTestMain {

	public static void main(String[] args) throws Exception {
		CartService cartService = new CartService();
		
		
		//카트에 새로운 상품 추가
		System.out.println("1. insertCart");
		System.out.println(">> "+cartService.insertCart(new Cart(1, 1, "aaaa", new Product(1, null, 0, null, null, null))));
		
		
		/*
		 * updateByCartNo, countByProductNo
		 */
		
		
		//카트에 담긴 특정 상품 삭제
		System.out.println("5. deleteCartItemByCartNo");
		System.out.println(">> "+cartService.deleteCartItemByCartNo(21));
		
		//회원의 카트에 담긴 상품 전체 삭제
		System.out.println("6. deleteCartItemByUserId");
		System.out.println(">> "+cartService.deleteCartItemByUserId("aaaa"));
		
		//카트에 담긴 특정 상품 찾기(카트 번호로)
		System.out.println("7. findCartItemByCartNo");
		System.out.println(">> "+cartService.findCartItemByCartNo(30));

		//회원의 카트에 담긴 상품 전체 찾기
		System.out.println("7. findCartItemByCartNo");
		System.out.println(">> "+cartService.findCartItemByUserId("bbbb"));

	
	
	
	}
}
