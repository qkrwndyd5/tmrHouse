package com.itwill.tmr_house.product.김혜지;

public class ProductServiceTestMain {

	public static void main(String[] args) throws Exception {
		ProductService productService = new ProductService();
		
		/*
		 * 1~4 insert, update, delete
		 */
		
		//상품 번호로 특정 상품 찾기
		System.out.println("5. Product_findByProductNo");
		System.out.println(">> "+productService.findByProductNo(1));
		
		
		//상품 전체 찾기
		System.out.println("6. Product_productList");
		System.out.println(">> "+productService.ProductList());
	}

}
