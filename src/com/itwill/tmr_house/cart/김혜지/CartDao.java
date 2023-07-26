package com.itwill.tmr_house.cart.김혜지;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.tmr_house.common.DataSource;
import com.itwill.tmr_house.product.김혜지.Product;




public class CartDao {
	
	private DataSource dataSource;
	public CartDao() throws Exception {
		dataSource = new DataSource();
	
	}
	
	/************성민모님 CartDao에서 가져온 메서드*************/

	/*
	 * 카트에서 존재하는 상품을 추가(수량 변경)
	 */
	
	public int updateByCartNo(String m_id, int c_qty, int p_no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE_BY_CART_NO);
		
		pstmt.setInt(1, c_qty);
		pstmt.setString(2, m_id);
		pstmt.setInt(3, p_no);
		
		int updateRowCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();
		return updateRowCount;
	}
	/*
	 * 카트에 제품 존재하는지 확인(countByProductNo)
	 */
	
	public int countByProductNo(String m_id, int p_no, int c_qty) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_COUNT_BY_PRODUCT_NO);
		
		pstmt.setInt(1, c_qty);
		pstmt.setString(2, m_id);
		pstmt.setInt(3, p_no);
		
		int countRowCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();
		return countRowCount;
	}
	/********************************************************/
	
	
	//카트에 새로운 상품 추가
	public int insertCart(Cart cart) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_INSERT_CART);
		
		pstmt.setInt(1, cart.getC_qty());
		pstmt.setString(2, cart.getM_id());
		pstmt.setInt(3, cart.getProduct().getP_no());
		
		int insertRowCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();
		return insertRowCount;
	}
	
	
	//카트에서 특정 상품 삭제(카트 번호로)
	public int deleteByCartNo(int c_no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_CART_NO);
		pstmt.setInt(1, c_no);
		int deleteRowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return deleteRowCount;
	}
	
	
	//회원의 카트에 담긴 상품 전체 삭제
	public int deleteByUserId(String m_id) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_USERID);
		pstmt.setString(1, m_id);
		int deleteRowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return deleteRowCount;
	}
	
	
	
	//카트에 담긴 특정 상품 찾기(카트 번호로)
	public Cart findByCartNo(int c_no) throws Exception {
		Cart cartItem = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_CART_NO);
		pstmt.setInt(1, c_no);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			cartItem = new Cart(rs.getInt("c_no"),
									rs.getInt("c_qty"),
									rs.getString("m_id"),
									(new Product(rs.getInt("p_no"),
												 rs.getString("p_name"),
												 rs.getInt("p_price"),
												 rs.getString("p_img"),
												 rs.getString("p_desc"),
												 rs.getString("p_freeDelivery")))
					);
	}

		
		
		return cartItem;
	}
	
	
	//회원의 카트에 담긴 상품 전체 찾기
	public List<Cart> findByUserId(String m_id) throws Exception{
		List<Cart> cartList = new ArrayList<Cart>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_USERID);
		pstmt.setString(1, m_id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			cartList.add(new Cart(rs.getInt("c_no"),
									rs.getInt("c_qty"),
									rs.getString("m_id"),
									(new Product(rs.getInt("p_no"),
													rs.getString("p_name"),
													rs.getInt("p_price"),
													rs.getString("p_img"),
													rs.getString("p_desc"),
													rs.getString("p_freeDelivery"))))
					);
		}

		return cartList;
	}


}
