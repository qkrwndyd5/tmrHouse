package com.itwill.tmr_house.cart.성민모;

public class CartServiceTestMain {
	
	public static void main(String[] args) throws Exception {
	    CartService cartService=new CartService();
	    
	    /*
	     * update, count
	     */
	    
	    //카트에 존재하는 상품을 추가(수량 변경)
	    System.out.println("updateByCartNo");
		System.out.println(">> " + cartService.updateCartByCartNo(3, 10));
        
		System.out.println("updateByProductNo");
		System.out.println(">> " + cartService.updateCartByProductNo(3, 100, "bbbb"));
		
		//카트에 제품 존재하는지 확인
		System.out.println("countByProductNo");
		System.out.println(">> " + cartService.countByProductNo("cccc", 1));
	}
}