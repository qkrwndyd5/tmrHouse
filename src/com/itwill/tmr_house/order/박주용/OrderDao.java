package com.itwill.tmr_house.order.박주용;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itwill.tmr_house.common.DataSource;
import com.itwill.tmr_house.product.김혜지.Product;

public class OrderDao {
	private DataSource dataSource;
	
	public OrderDao() throws Exception{
		dataSource = new DataSource();
	}
	
	/*
	 * 주문생성
	 */
	public int insertOrder(Order order) throws Exception{
		/*
		private int o_no;
		private String o_desc;
		private int o_qty;
		private int o_price;
		private Date o_date;
		private String m_id;
		 */
		
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1=con.prepareStatement(OrderSQL.ORDER_INSERT);
			pstmt1.setString(1, order.getO_desc());
			pstmt1.setInt(2, order.getO_qty());
			pstmt1.setInt(3, order.getO_price());
			pstmt1.setString(4, order.getM_id());
			pstmt1.executeUpdate();
			
			pstmt2 = con.prepareStatement(OrderSQL.ORDERITEM_INSERT);
			for(OrderItem orderItem : order.getOrderItemList()) {
				pstmt2.setInt(1, orderItem.getOi_qty());
				pstmt2.setInt(2, orderItem.getProduct().getP_no());
				pstmt2.executeUpdate();
			}
			con.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		}finally {
			
			pstmt1.close();
			pstmt2.close();
			if(con!=null)con.close();
		}
	
		return 0;
	}
	
	/*
	 * 주문전체삭제(주문번호)
	 */
	public int deleteByOrderNo(int o_no) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_O_NO);
			pstmt.setInt(1, o_no);
			rowCount = pstmt.executeUpdate();
			con.commit();
			
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
				
		return rowCount;
	}
	
	/*
	 * 주문전체삭제(회원아이디)
	 */
	public int deleteByMemberId(String m_id) throws Exception{
		Connection con = null;
		PreparedStatement pstmt=null;
		int rowCount = 0;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_M_ID);
			pstmt.setString(1, m_id);
			rowCount = pstmt.executeUpdate();
			con.commit();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			
			if(con!=null)con.close();
		}
				
		return rowCount;
		
	}
	
	/*
	 * 주문전체출력 
	 */
	public ArrayList<Order> findByMemberId(String m_id) throws Exception{
		ArrayList<Order> orderList = new ArrayList<Order>();
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			/*
			 * private int o_no;
				private String o_desc;
				private int o_qty;
				private int o_price;
				private Date o_date;
				private String m_id;
			 */
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_BY_M_ID);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				orderList.add(new Order(rs.getInt("o_no"),
										rs.getString("o_desc"),
										rs.getInt("o_qty"),
										rs.getInt("o_price"),
										rs.getDate("o_date"),
										rs.getString("m_id")));
			}
		}finally {
			if(con!=null) {
				pstmt.close();
				con.close();
				rs.close();
			}
		}
		
		
		return orderList;
	}
	
	/*
	 * 주문1개보기
	 */
	public Order findByOrderNo(String m_id, int o_no) throws Exception{
		
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = dataSource.getConnection();
		
		pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_PRODUCT_BY_M_ID);
		pstmt.setString(1, m_id);
		pstmt.setInt(2, o_no);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			/*
			 private int o_no;
				private String o_desc;
				private int o_qty;
				private int o_price;
				private Date o_date;
				private String m_id;
			 */		
			order = new Order(rs.getInt("o_no"),
							  rs.getString("o_desc"),
							  rs.getInt("o_qty"),
							  rs.getInt("o_price"),
							  rs.getDate("o_date"),
							  rs.getString("m_id"));
			do {
				/*
				 private int oi_no;
				 private int oi_qty;
				 private int o_no;
				 private int p_no;
				 */
				/*
				 private int p_no;
				 private String p_name;
				 private int p_price;
				 private String p_img;
				 private String p_desc;
				 private char p_freeDelivery;
				 */
				order.getOrderItemList()
					 .add(new OrderItem(rs.getInt("oi_no"),
							 			rs.getInt("oi_qty"),
							 			rs.getInt("o_no"),
							 			new Product(rs.getInt("p_no"),
							 						rs.getString("p_name"),
							 						rs.getInt("p_price"),
							 						rs.getString("p_img"),
							 						rs.getString("p_desc"),
							 						rs.getString("p_freeDelivery"))
							 			));
				
			}while(rs.next());
		}
		
		return order;		
	}
	
	
}
