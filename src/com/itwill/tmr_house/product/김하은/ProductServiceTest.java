package com.itwill.tmr_house.product.김하은;

import java.util.List;

public class ProductServiceTest {

	public static void main(String[] args) throws Exception {
		ProductService productService = new ProductService();
		/*
		 * 상품 주이름으로 상품검색
		 */
		List<Product> psList= productService.searchAll("의자");
		
		for (Product product : psList) {
			System.out.println(product);
		}
		
	
	}

}
