package com.itwill.tmr_house.order.이찬영;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itwill.tmr_house.common.DataSource;
import com.itwill.tmr_house.product.성민모.Product;


public class OrderDao {
	private DataSource dataSource;

	public OrderDao() throws Exception {
		dataSource = new DataSource();
	}

	public int insert(Order order) throws Exception {

		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int rowCount1 = 0;
		int rowCount2 = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1 = con.prepareStatement(OrderSQL.ORDER_INSERT);
			// ORDER_INSERT = "insert into orders(o_no,o_desc,o_date,o_price,m_id) values (orders_o_no_SEQ.nextval,?,sysdate,?,?)"
			pstmt1.setString(1, order.getO_desc());
			pstmt1.setInt(2, order.getO_qty());
			pstmt1.setInt(3, order.getO_price());
			pstmt1.setString(4, order.getM_id());
			rowCount1 = pstmt1.executeUpdate();

			pstmt2 = con.prepareStatement(OrderSQL.ORDERITEM_INSERT);
			// "insert into order_item(oi_no,oi_qty,o_no,p_no)
			// values(order_item_oi_no_SEQ.nextval,?,order_item_oi_no_SEQ.currval,?)
			for (OrderItem orderitem : order.getOrderItemList()) {
				pstmt2.setInt(1, orderitem.getOi_qty());
				pstmt2.setInt(2, orderitem.getProduct().getP_no());
				rowCount2 =	pstmt2.executeUpdate();
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		} finally {
			pstmt1.close();
			pstmt2.close();
			
			if (con != null)
				
				con.close();
		}

		return rowCount1+rowCount2;
	}

//아이디로 주문전체 삭제
	public int deleteById(String m_Id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_M_ID);
			// public final static String ORDER_DELETE_BY_M_ID = "delete from orders where
			// m_id=?";
			pstmt.setString(1, m_Id);
			rowCount = pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		} finally {

			pstmt.close();
			if (con != null)
				con.close();
		}
		return rowCount;
	}

	// 주문번호로 주문1건삭제
	public int deleteByOrderNo(int o_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			// delete from orders where o_no=?
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_O_NO);
			pstmt.setInt(1, o_no);
			rowCount = pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		} finally {

			pstmt.close();
			if (con != null)
				con.close();

		}
		return rowCount;

	}

	// 유저 아이디로 주문리스트 불러오기
	public ArrayList<Order> findById(String m_id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<Order> orderList = new ArrayList<Order>();
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			// "select * from orders where m_id=?";
			pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_BY_M_ID);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			/*
			 * 이름 널? 유형 ------- -------- ------------- O_NO NOT NULL NUMBER(10) O_DESC
			 * VARCHAR2(100) O_QTY NUMBER(10) O_PRICE NUMBER(10) O_DATE DATE M_ID
			 * VARCHAR2(50)
			 * 
			 */
			while (rs.next()) {
				orderList.add(new Order(rs.getInt("o_no"), rs.getString("o_desc"), rs.getInt("o_qty"),
						rs.getInt("o_price"), rs.getDate("o_date"), rs.getString("m_id")));

			}
		} finally {
			rs.close();
			pstmt.close();
			if (con != null)
				con.close();
		}
		return orderList;

	}

	// 주문 1개보기 고객아이디,주문번호
	public Order findByOrderNo(String m_id, int o_no) throws Exception {

		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = dataSource.getConnection();
		/*
		 * select * from orders o join order_item oi on o.o_no=oi.o_no join product p on
		 * oi.p_no=p.p_no where o.userid=? and o.o_no = ?
		 */
		pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_PRODUCT_BY_M_ID);
		pstmt.setString(1, m_id);
		pstmt.setInt(2, o_no);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			order = new Order(rs.getInt("o_no"), rs.getString("o_desc"), rs.getInt("o_qty"), rs.getInt("o_price"),
					rs.getDate("o_date"), rs.getString("m_id"));
			do {
				order.getOrderItemList().add(new OrderItem(rs.getInt("oi_no"), rs.getInt("oi_qty"), rs.getInt("o_no"),
								new Product(rs.getInt("p_no"), rs.getString("p_name"), rs.getInt("p_price"),
										rs.getString("p_img"), rs.getString("p_desc"),
										rs.getString("p_freeDelivery"))));
						
			} while (rs.next());
		}
		return order;
	}

}
