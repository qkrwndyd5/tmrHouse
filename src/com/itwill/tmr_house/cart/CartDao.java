package com.itwill.tmr_house.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.tmr_house.common.DataSource;
import com.itwill.tmr_house.product.Product;

public class CartDao {
	private DataSource dataSource;

	public CartDao() throws Exception {
		dataSource = new DataSource();
	}

	// Cart 객체로 insert
	public int insert(Cart cart) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_INSERT);
		pstmt.setInt(1, cart.getC_qty());
		pstmt.setString(2, cart.getM_id());
		pstmt.setInt(3, cart.getProduct().getP_no());

		int rowCount = pstmt.executeUpdate();

		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

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

	// 카트에서 특정 상품 삭제(카트 번호로)
	public int deleteByCartNo(int c_no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_CART_NO);
		pstmt.setInt(1, c_no);
		int deleteRowCount = pstmt.executeUpdate();

		pstmt.close();
		dataSource.close(con);
		return deleteRowCount;
	}

	// 회원의 카트에 담긴 상품 전체 삭제
	public int deleteByUserId(String m_id) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_ID);
		pstmt.setString(1, m_id);
		int deleteRowCount = pstmt.executeUpdate();

		pstmt.close();
		dataSource.close(con);
		return deleteRowCount;
	}

	// 카트에 담긴 특정 상품 찾기(카트 번호로)
	public Cart findByCartNo(int c_no) throws Exception {
		Cart cartItem = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_CART_NO);
		pstmt.setInt(1, c_no);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			cartItem = new Cart(rs.getInt("c_no"), 
								rs.getInt("c_qty"), 
								rs.getString("m_id"),
								(new Product(rs.getInt("p_no"), 
										rs.getString("p_name"), 
										rs.getInt("p_price"), 
										rs.getString("p_img"),
										rs.getString("p_desc"), 
										rs.getString("p_freeDelivery"))));
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return cartItem;
	}

	// 회원의 카트에 담긴 상품 전체 찾기
	public List<Cart> findByUserId(String m_id) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_ID);
		pstmt.setString(1, m_id);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			cartList.add(new Cart(rs.getInt("c_no"), rs.getInt("c_qty"), rs.getString("m_id"),
					(new Product(rs.getInt("p_no"), rs.getString("p_name"), rs.getInt("p_price"), rs.getString("p_img"),
							rs.getString("p_desc"), rs.getString("p_freeDelivery")))));
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return cartList;
	}

	// count
	public int countByProductNo(String m_id, int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
			rs.close();
			pstmt.close();
		} finally {
			if (con != null) dataSource.close(con);
		}
		return count;
	}
}
