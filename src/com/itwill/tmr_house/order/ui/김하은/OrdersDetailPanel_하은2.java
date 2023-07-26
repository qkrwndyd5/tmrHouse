package com.itwill.tmr_house.order.ui.김하은;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.tmr_house.order.*;
import com.itwill.tmr_house.ui.*;

import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class OrdersDetailPanel_하은2 extends JPanel {
	TmrHouseMainFrame frame;
	OrdersService ordersService;
	private JTable orderDetailTable;
	Orders curtOrder = null;
	
	
	public void setFrame(TmrHouseMainFrame frame) {
		this.frame = frame;
	}
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public OrdersDetailPanel_하은2() throws Exception {
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel ordersDetailNorthPanel = new JPanel();
		ordersDetailNorthPanel.setBackground(new Color(255, 255, 255));
		add(ordersDetailNorthPanel, BorderLayout.NORTH);
		
		JPanel ordersScreenNorthAppTitlePanel = new JPanel();
		ordersScreenNorthAppTitlePanel.setBackground(Color.WHITE);
		ordersDetailNorthPanel.add(ordersScreenNorthAppTitlePanel);
		
		JLabel loginScreenPanelAppTitleLB = new JLabel("Tommorow's House");
		loginScreenPanelAppTitleLB.setFont(new Font("D2Coding", Font.BOLD, 20));
		ordersScreenNorthAppTitlePanel.add(loginScreenPanelAppTitleLB);
		
		JPanel ordersDetailSouthPanel = new JPanel();
		ordersDetailSouthPanel.setBackground(new Color(255, 255, 255));
		add(ordersDetailSouthPanel, BorderLayout.SOUTH);
		ordersDetailSouthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton ordersHomeBtn = new JButton("");
		ordersHomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_LIST_PANEL);
			}
		});
		ordersHomeBtn.setBackground(new Color(64, 184, 255));
		ordersHomeBtn.setIcon(new ImageIcon(OrdersDetailPanel_하은2.class.getResource("/com/itwill/tmr_house/member/images/home(30x30).png")));
		ordersDetailSouthPanel.add(ordersHomeBtn);
		
		JPanel ordersDetailCenterPanel = new JPanel();
		ordersDetailCenterPanel.setBackground(new Color(255, 255, 255));
		add(ordersDetailCenterPanel, BorderLayout.CENTER);
		ordersDetailCenterPanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 81, 500, 152);
		ordersDetailCenterPanel.add(scrollPane_1);
		
		orderDetailTable = new JTable();
		orderDetailTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane_1.setViewportView(orderDetailTable);
		
		ordersService = new OrdersService();
	
		//orders.setM_id(frame.loginMember.getM_id()); // 로그인하고 주문한 아이디로 바꿔줘야함
		//orders.setO_no(findOrderNo(frame.loginMember.getM_id()));
	
		//displayOrderDetail(orders);
	} // 생성자 끝

	public void displayOrderDetail(int o_no) {
		try {
			curtOrder = ordersService.orderListDetail(frame.loginMember.getM_id(),o_no);
			List<OrderItem> orderItemList = curtOrder.getOrderItemList();
			
			Vector columnVector = new Vector();
			columnVector.add("주문번호");
			//columnVector.add("주문상품번호");
			columnVector.add("수량");
			columnVector.add("상품명");
			columnVector.add("상품금액");
			//columnVector.add("상세설명");
			//columnVector.add("주문날짜");
			columnVector.add("배송비유무");
			
			Vector tableVector = new Vector();
			
			
			for(OrderItem orderItem:orderItemList) {
				Vector rowVector = new Vector();
				rowVector.add(orderItem.getO_no());
				//rowVector.add(orderItem.getOi_no());
				rowVector.add(orderItem.getOi_qty());
				rowVector.add(orderItem.getProduct().getP_name());
				rowVector.add(orderItem.getProduct().getP_price());
				//rowVector.add(orderItem.getProduct().getP_desc());
				rowVector.add(orderItem.getProduct().getP_freeDelivery());
				tableVector.add(rowVector);
			}
			
			DefaultTableModel tableModel = new DefaultTableModel(tableVector,columnVector);
			orderDetailTable.setModel(tableModel);
			
		}catch(Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
	}
	
	/*public int findOrderNo(String id) throws Exception {
			List<Orders> orderList = ordersService.orderList(id);
			int row = 0;
			for(Orders order : orderList) {
				if(id.equals(order.getM_id())) {
					row = order.getO_no();
				}
			}
			return row;
		}
	*/
	
	
}
