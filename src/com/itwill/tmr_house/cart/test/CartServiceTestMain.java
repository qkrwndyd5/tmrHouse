package com.itwill.tmr_house.cart.test;

import com.itwill.tmr_house.cart.Cart;
import com.itwill.tmr_house.cart.CartService;
import com.itwill.tmr_house.product.ProductService;

public class CartServiceTestMain {

	public static void main(String[] args) throws Exception {
		CartService cartService = new CartService();
		ProductService productService = new ProductService();

		// 카트에 새로운 상품 추가
		System.out.println("1. insertCart");
		System.out.println(">> " + cartService.insertCart(new Cart(1, 1, "cccc", productService.findByProductNo(1))));

		// updateByCartNo
		System.out.println("2. updateByCartNo");
		System.out.println(">> " + cartService.updateCartByCartNo(3, 10));

		// updateByProductNo
		System.out.println("3. updateByProductNo");
		System.out.println(">> " + cartService.updateCartByProductNo(3, 100, "bbbb"));

		// 카트에 담긴 특정 상품 삭제
		System.out.println("4. deleteCartItemByCartNo");
		System.out.println(">> " + cartService.deleteCartItemByCartNo(4));

		// 회원의 카트에 담긴 상품 전체 삭제
		System.out.println("5. deleteCartItemByUserId");
		System.out.println(">> " + cartService.deleteCartItemByUserId("aaaa"));

		// 카트에 담긴 특정 상품 찾기(카트 번호로)
		System.out.println("6. findCartItemByCartNo");
		System.out.println(">> " + cartService.findCartItemByCartNo(3));

		// 회원의 카트에 담긴 상품 전체 찾기
		System.out.println("7. findCartItemByCartNo");
		System.out.println(">> " + cartService.findCartItemByUserId("bbbb"));
	}

}
