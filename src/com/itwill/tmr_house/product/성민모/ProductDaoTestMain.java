package com.itwill.tmr_house.product.성민모;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception {
		ProductDao productDao = new ProductDao();

		/*
		 * insert, deleteByProductNo, deleteByName, updateByProductNo
		 */
		
		//insert 상품추가
		System.out.println("1. Product_insert");
		Product product = new Product(0, "장스탠드", 50000, "null", "반짝반짝", "N");
		System.out.println(">> " + productDao.insert(product));				
		
		//상품 pk로삭제
		//child record 있어서(orderitem이 fk로 product의 p_no를 가짐) 삭제할 수 없음
		System.out.println("2. Product_deleteByNo");
		System.out.println(">> " + productDao.deleteByNo(7));
				
		//update 상품변경
		System.out.println("3. Product_update");
		Product updateProduct = new Product(7, "edit", 11111, "edit_img", "edit_desc", "Y");
		System.out.println(">> " + productDao.updateProduct(updateProduct));				
	}
}	