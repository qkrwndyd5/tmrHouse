package com.itwill.tmr_house.product.test;

import java.util.List;

import com.itwill.tmr_house.product.Product;
import com.itwill.tmr_house.product.ProductService;

public class ProductServiceTestMain {

	public static void main(String[] args) throws Exception {
		ProductService productService = new ProductService();

		// 상품 등록하기
		System.out.println("1. Product_insert");
		Product insertProduct = new Product(0, "insert", 88888, "null", "desc", "Y");
		System.out.println(">> " + productService.insertProduct(insertProduct));
	
		// 상품 업데이트
		System.out.println("2. Product_update");
		Product updateProduct = new Product(5, "update", 12121, "img.jpg", "details", "N");
		System.out.println(">> " + productService.updateProduct(updateProduct));
		
		// 상품 번호로 특정 상품 찾기
		System.out.println("3. Product_findByProductNo");
		System.out.println(">> " + productService.findByProductNo(1));

		// 상품 전체 찾기
		System.out.println("4. Product_productList");
		System.out.println(">> " + productService.ProductList());

		// 상품 주이름으로 상품검색
		System.out.println("5. Product_serchAll(키워드로 검색)");
		List<Product> psList = productService.searchAll("의자");
		for (Product product : psList) {
			System.out.println(product);
		}

	}

}