package com.itwill.tmr_house.product.성민모;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itwill.tmr_house.common.DataSource;
import com.itwill.tmr_house.product.성민모.Product;
import com.itwill.tmr_house.product.성민모.ProductSQL;

public class ProductDao {
	private DataSource dataSource;
	public ProductDao() throws Exception {
		dataSource = new DataSource();
	}
	
	/*
	 * insert 상품추가
	 */
	
	public int insert(Product product) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_INSERT);
		pstmt.setString(1, product.getP_name());
		pstmt.setInt(2, product.getP_price());
		pstmt.setString(3, product.getP_img());
		pstmt.setString(4, product.getP_desc());
		pstmt.setString(5, product.getP_freeDelivery());
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	/*
	 * 상품pk로삭제
	 */
	
	public int deleteByNo (int p_no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_DELETE_BY_P_NO);		
		pstmt.setInt(1, p_no);		
		int rowCount = pstmt.executeUpdate();		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
		
	/*
	 * update 상품변경
	 */
	
	public int updateProduct(Product product) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_UPDATE);
		pstmt.setString(1, product.getP_name());
		pstmt.setInt(2, product.getP_price());
		pstmt.setString(3, product.getP_img());
		pstmt.setString(4, product.getP_desc());
		pstmt.setString(5, product.getP_freeDelivery());
		pstmt.setInt(6, product.getP_no());
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
}	