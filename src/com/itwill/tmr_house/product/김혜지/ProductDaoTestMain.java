package com.itwill.tmr_house.product.김혜지;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception {
		ProductDao productDao = new ProductDao();

		/*
		 * 1~4 insert, update, delete
		 */
		
		//상품번호로 특정 상품 출력
		System.out.println("5. Product_findByProductNo");
		System.out.println(">> "+productDao.findByProductNo(1));
		
		//상품 전체 출력
		System.out.println("6. Product_findAll");
		System.out.println(">> "+productDao.findAll());
		
		
	}

}
