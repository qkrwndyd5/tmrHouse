package com.itwill.tmr_house.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.tmr_house.common.DataSource;
import com.itwill.tmr_house.product.Product;

public class OrdersDao {
private DataSource dataSource;
	
	public OrdersDao() throws Exception{
		dataSource = new DataSource();
	}
	
	/*
	 * 주문생성
	 */
	public int insertOrder(Orders order) throws Exception{
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
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1=con.prepareStatement(OrdersSQL.ORDERS_INSERT);
			pstmt1.setString(1, order.getO_desc());
			pstmt1.setInt(2, order.getO_qty());
			pstmt1.setInt(3, order.getO_price());
			pstmt1.setString(4, order.getM_id());
			rowCount = pstmt1.executeUpdate();
			
			pstmt2 = con.prepareStatement(OrdersSQL.ORDERS_ITEM_INSERT);
			for (OrderItem orderItem : order.getOrderItemList()) {
				pstmt2.setInt(1, orderItem.getOi_qty());
				pstmt2.setInt(2, orderItem.getProduct().getP_no());
				pstmt2.executeUpdate();
			}
			con.commit();
			pstmt1.close();
			pstmt2.close();
		}catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		}finally {
			if(con!=null) dataSource.close(con);
		}
		return rowCount;
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
			pstmt = con.prepareStatement(OrdersSQL.ORDERS_DELETE_BY_O_NO);
			pstmt.setInt(1, o_no);
			rowCount = pstmt.executeUpdate();
			con.commit();
			pstmt.close();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null) dataSource.close(con);
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
			pstmt = con.prepareStatement(OrdersSQL.ORDERS_DELETE_BY_M_ID);
			pstmt.setString(1, m_id);
			rowCount = pstmt.executeUpdate();
			con.commit();
			pstmt.close();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null) dataSource.close(con);
		}
		return rowCount;
	}
	
	// 유저 아이디로 주문리스트 불러오기
		public List<Orders> findById(String m_id) throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			List<Orders> orderList = new ArrayList<Orders>();
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				// "select * from orders where m_id=?";
				pstmt = con.prepareStatement(OrdersSQL.ORDERS_SELECT_BY_M_ID);
				pstmt.setString(1, m_id);
				rs = pstmt.executeQuery();
				/*
				 * 이름 	널? 		유형 
				 * ------- -------- ------------- 
				 * O_NO 	NOT NULL NUMBER(10) 
				 * O_DESC 			 VARCHAR2(100)
				 * O_QTY			 NUMBER(10) 
				 * O_PRICE 			 NUMBER(10) 
				 * O_DATE 			 DATE 
				 * M_ID				 VARCHAR2(50)
				 */
				while (rs.next()) {
					orderList.add(new Orders(	rs.getInt("o_no"), 
												rs.getString("o_desc"), 
												rs.getInt("o_qty"),
												rs.getInt("o_price"), 
												rs.getDate("o_date"), 
												rs.getString("m_id")));
				}
				rs.close();
				pstmt.close();
			} finally {
				if (con != null) dataSource.close(con);
			}
			return orderList;
		}

		// 주문 1개보기 고객아이디,주문번호
		public Orders findByOrderNo(String m_id, int o_no) throws Exception {

			Orders order = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			con = dataSource.getConnection();
			/*
			 * select * from orders o join order_item oi on o.o_no=oi.o_no join product p on
			 * oi.p_no=p.p_no where o.userid=? and o.o_no = ?
			 */
			pstmt = con.prepareStatement(OrdersSQL.ORDERS_SELECT_WITH_PRODUCT_BY_M_ID);
			pstmt.setString(1, m_id);
			pstmt.setInt(2, o_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				order = new Orders(	rs.getInt("o_no"), 
									rs.getString("o_desc"), 
									rs.getInt("o_qty"), 
									rs.getInt("o_price"),
									rs.getDate("o_date"),
									rs.getString("m_id"));
				do {
					order.getOrderItemList()
							.add(new OrderItem(	rs.getInt("oi_no"), 
												rs.getInt("oi_qty"), 
												rs.getInt("o_no"),
												new Product(rs.getInt("p_no"), 
															rs.getString("p_name"), 
															rs.getInt("p_price"),
															rs.getString("p_img"), 
															rs.getString("p_desc"),
															rs.getString("p_freeDelivery"))));
				} while (rs.next());
			}
			rs.close();
			pstmt.close();
			dataSource.close(con);
			return order;
		}
		// 주문 여러개 보기
		public List<Orders> findByMid(String m_id) throws Exception {

			List<Orders> orderList = new ArrayList<Orders>();
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			con = dataSource.getConnection();

			pstmt = con.prepareStatement(OrdersSQL.ORDERS_SELECT_BY_M_ID);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Orders order = new Orders(	rs.getInt("o_no"), 
									rs.getString("o_desc"), 
									rs.getInt("o_qty"), 
									rs.getInt("o_price"),
									rs.getDate("o_date"),
									rs.getString("m_id"));
				
				orderList.add(order);
			}
			rs.close();
			pstmt.close();
			dataSource.close(con);
			System.out.println(orderList.size()+"   Dao");
			return orderList;
		}
	
}
