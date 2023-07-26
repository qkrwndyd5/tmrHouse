package com.itwill.tmr_house.product.성민모;

public class ProductServiceTestMain {

	public static void main(String[] args) throws Exception {
		ProductService productService = new ProductService();
		
		/*
		 * insert, update, delete
		 */
		
		//insert 상품추가
		System.out.println("1. Product_insert");
		Product insertProduct = new Product(0, "insert", 88888, "null", "desc", "Y");
		System.out.println(">> " + productService.insert(insertProduct));
		//상품 pk로삭제(구현 미지정)
	
		//update 상품변경
		System.out.println("2. Product_update");
		Product updateProduct = new Product(5, "update", 12121, "img.jpg", "details", "N");
		System.err.println(">> " + productService.updateProduct(updateProduct));
	}

}	