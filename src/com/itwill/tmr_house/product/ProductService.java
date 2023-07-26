package com.itwill.tmr_house.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.tmr_house.common.DataSource;

public class ProductService {
	private ProductDao productDao;
	private DataSource dataSource;
	public ProductService() throws Exception {
		productDao = new ProductDao();
		dataSource = new DataSource();
	}

	
	// insert
	public int insertProduct(Product product) throws Exception {
		return productDao.insert(product);
	}
	
	// update
	public int updateProduct(Product product) throws Exception {
		return productDao.updateProduct(product);
	}
	
	// delete(구현여부 미정)
	
	
	//상품 번호로 특정 상품을 출력
	public Product findByProductNo(int p_no) throws Exception {
		return productDao.findByProductNo(p_no);
	}
	
	
	//전체 상품 리스트 출력
	public List<Product> ProductList() throws Exception{
		return productDao.findAll();
	}
	
	/*
	 * product 카테고리(?) 이름으로 검색 시 관련된 모든 상품 노출
	 * ex) 의자 검색 시 xxx의자 상품 다 나오게
	 */
	
	public List<Product> searchAll(String p_name) throws Exception{
		List<Product> productList = new ArrayList<Product>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_BY_P_NAME);
		pstmt.setString(1,"%"+ p_name );
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			productList.add(new Product(rs.getInt("p_no"),
										rs.getString("p_name"),
										rs.getInt("p_price"),
										rs.getString("p_img"),
										rs.getString("p_desc"),
										rs.getString("p_freedelivery")
					));
		}
		
		return productList;
	}
	
}