package com.itwill.tmr_house.cart.성민모;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.itwill.tmr_house.cart.성민모.CartSQL;
import com.itwill.tmr_house.common.DataSource;

public class CartDao {
	private DataSource dataSource;
	public CartDao() throws Exception{
		dataSource = new DataSource();
	}
	
	/*
	 * 카트에서 존재하는 상품을 추가(수량 변경)
	 */
	
	public int updateByCartNo(int c_no, int qty) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE_BY_CART_NO);
		int rowCount = 0;
		pstmt.setInt(1, qty);
		pstmt.setInt(2, c_no);
		rowCount = pstmt.executeUpdate();

		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int updateByProductNo(int p_no, int qty, String m_id) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE_BY_PRODUCT_NO_ID);
		int rowCount = 0;
		pstmt.setInt(1, qty);
		pstmt.setString(2, m_id);
		pstmt.setInt(3, p_no);
		rowCount = pstmt.executeUpdate();

		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	/*
	 * 카트에 제품 존재하는지 확인(countByProductNo)
	 */
	
	public int countByProductNo(String m_id, int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		java.sql.ResultSet rs = null;
		int count = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_COUNT_BY_USERID_PRODUCT_NO);
			pstmt.setString(1, m_id);
			pstmt.setInt(2, p_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} finally {
			if (con != null) {
				dataSource.close(con);
			}
		}
		return count;
	}
}	