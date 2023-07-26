package com.itwill.tmr_house.product.김혜지;

import java.util.List;

public class ProductService {
	private ProductDao productDao;
	public ProductService() throws Exception {
		productDao = new ProductDao();
	}
	
	/*
	 * insert, update, delete
	 */
	
	
	//상품 번호로 특정 상품을 출력
	public Product findByProductNo(int p_no) throws Exception {
		return productDao.findByProductNo(p_no);
	}
	
	
	//전체 상품 리스트 출력
	public List<Product> ProductList() throws Exception{
		return productDao.findAll();
	}
	
	
	
	
	
	
}
