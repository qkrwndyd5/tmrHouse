package com.itwill.tmr_house.product.성민모;

import java.util.List;

import com.itwill.tmr_house.cart.김혜지.Cart;

public class ProductService {
	private ProductDao productDao;
	public ProductService() throws Exception{
		productDao=new ProductDao();
	}
	
	/*
	 * insert, deleteByProductNo, deleteByName, updateByProductNo
	 */
	
	//insert 상품추가
	public int insert(Product product) throws Exception {
        return productDao.insert(product);
		}
	
	//상품 삭제(구현여부 미정)
	
	//update 상품변경
	public int updateProduct(Product product) throws Exception {
		return productDao.updateProduct(product);
	}
	
}