package com.itwill.tmr_house.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.tmr_house.common.DataSource;

public class ProductDao {
	private DataSource dataSource;

	public ProductDao() throws Exception {
		dataSource = new DataSource();
	}

	// insert(admin)
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

	// delete by no(admin)
	public int deleteByNo (int p_no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_DELETE_BY_P_NO);		
		pstmt.setInt(1, p_no);
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	// update(admin)
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

	// 상품 번호로 특정 상품 찾기
	public Product findByProductNo(int p_no) throws Exception {
		Product product = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_BY_P_NO);
		pstmt.setInt(1, p_no);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			product = new Product(rs.getInt("p_no"), rs.getString("p_name"), rs.getInt("p_price"),
								  rs.getString("p_img"), rs.getString("p_desc"), rs.getString("p_freeDelivery"));
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return product;
	}

	// 상품 전체 찾기
	public List<Product> findAll() throws Exception {
		List<Product> productList = new ArrayList<Product>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			productList.add(new Product(rs.getInt("p_no"), rs.getString("p_name"), rs.getInt("p_price"),
										rs.getString("p_img"), rs.getString("p_desc"), rs.getString("p_freeDelivery")));
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return productList;
	}

}
