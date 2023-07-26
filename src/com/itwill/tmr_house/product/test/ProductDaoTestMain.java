package com.itwill.tmr_house.product.test;

import com.itwill.tmr_house.product.Product;
import com.itwill.tmr_house.product.ProductDao;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception {
		ProductDao productDao = new ProductDao();

		// insert(admin)
		System.out.println("1. Product_insert");
		Product product = new Product(0, "장스탠드", 50000, "null", "반짝반짝", "N");
		System.out.println(">> " + productDao.insert(product));
	
		// delete(admin)
		System.out.println("2. Product_delete");
		System.out.println(">> " + productDao.deleteByNo(7));
	
		// update(admin)
		System.out.println("3. Product_update");
		Product updateProduct = new Product(7, "edit", 11111, "edit_img", "edit_desc", "Y");
		System.out.println(">> " + productDao.updateProduct(updateProduct));
		System.out.println(productDao.findByProductNo(3));

		// 상품번호로 특정 상품 출력
		System.out.println("4. Product_findByProductNo");
		System.out.println(">> " + productDao.findByProductNo(1));

		// 상품 전체 출력
		System.out.println("5. Product_findAll");
		System.out.println(">> " + productDao.findAll());

	}

}