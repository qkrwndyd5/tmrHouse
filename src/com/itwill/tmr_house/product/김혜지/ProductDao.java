package com.itwill.tmr_house.product.김혜지;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.itwill.tmr_house.common.DataSource;

public class ProductDao {
	private DataSource dataSource;
	public ProductDao() throws Exception {
		dataSource = new DataSource();
	}
	
	/*
	 * insert, update, delete
	 */

	//상품 번호로 특정 상품 찾기
	public Product findByProductNo(int p_no) throws Exception {
		Product product = null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.PRODUCT_SELECT_BY_P_NO);
		pstmt.setInt(1, p_no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			product = new Product(rs.getInt("p_no"),
											rs.getString("p_name"),
											rs.getInt("p_price"),
											rs.getString("p_img"),
											rs.getString("p_desc"),
											rs.getString("p_freeDelivery"));
		}
		return product;
	}
	
	
	//상품 전체 찾기
	public ArrayList<Product> findAll() throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Product> productList = new ArrayList<Product>();
		while(rs.next()) {
			productList.add(new Product(rs.getInt("p_no"),
										rs.getString("p_name"),
										rs.getInt("p_price"),
										rs.getString("p_img"),
										rs.getString("p_desc"),
										rs.getString("p_freeDelivery")));
		}
		return productList;
	}
	
}
