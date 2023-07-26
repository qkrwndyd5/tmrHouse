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

public class OrdersDetailPanel_하은 extends JPanel {
	TmrHouseMainFrame frame;
	OrdersService ordersService;
	private JTable orderListTable;
	private JTable orderDetailTable;
	Orders curtOrder = null;

	
	public void setFrame(TmrHouseMainFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public OrdersDetailPanel_하은() throws Exception {
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
		ordersHomeBtn.setBorderPainted(false);
		ordersHomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_LIST_PANEL);
			}
		});
		ordersHomeBtn.setBackground(new Color(255, 255, 255));
		ordersHomeBtn.setIcon(new ImageIcon(
				OrdersDetailPanel_하은.class.getResource("/com/itwill/tmr_house/member/images/home(30x30).png")));
		ordersDetailSouthPanel.add(ordersHomeBtn);

		JPanel ordersDetailCenterPanel = new JPanel();
		ordersDetailCenterPanel.setBackground(new Color(255, 255, 255));
		add(ordersDetailCenterPanel, BorderLayout.CENTER);
		ordersDetailCenterPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 150));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(0, 0, 500, 85);
		ordersDetailCenterPanel.add(scrollPane);

		orderListTable = new JTable();
		orderListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowNo = orderListTable.getSelectedRow();
				int order_no = (Integer) orderListTable.getValueAt(rowNo, 0);
				displayOrderDetail(order_no);
			}
		});
		orderListTable.setPreferredScrollableViewportSize(new Dimension(450, 200));
		orderListTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "\uC8FC\uBB38\uBC88\uD638", "\uC8FC\uBB38\uC0C1\uD488", "\uC218\uB7C9", "\uAE08\uC561",
						"\uC8FC\uBB38\uB0A0\uC9DC", "\uC8FC\uBB38\uC544\uC774\uB514" }));
		orderListTable.getColumnModel().getColumn(0).setPreferredWidth(59);
		orderListTable.getColumnModel().getColumn(1).setPreferredWidth(170);
		orderListTable.getColumnModel().getColumn(2).setPreferredWidth(45);
		orderListTable.setFont(new Font("D2Coding", Font.PLAIN, 12));
		scrollPane.setViewportView(orderListTable);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 294, 500, 152);
		ordersDetailCenterPanel.add(scrollPane_1);

		orderDetailTable = new JTable();
		orderDetailTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		scrollPane_1.setViewportView(orderDetailTable);

		ordersService = new OrdersService();
		
	} // 생성자 끝

	public void displayOrderDetail(int o_no) {
		try {
			curtOrder = ordersService.orderListDetail(frame.loginMember.getM_id(), o_no);
			List<OrderItem> orderItemList = curtOrder.getOrderItemList();

			Vector columnVector = new Vector();
			columnVector.add("주문번호");
			// columnVector.add("주문상품번호");
			columnVector.add("수량");
			columnVector.add("상품명");
			columnVector.add("상품금액");
			// columnVector.add("상세설명");
			// columnVector.add("주문날짜");
			columnVector.add("배송비유무");

			Vector tableVector = new Vector();

			for (OrderItem orderItem : orderItemList) {
				Vector rowVector = new Vector();
				rowVector.add(orderItem.getO_no());
				// rowVector.add(orderItem.getOi_no());
				rowVector.add(orderItem.getOi_qty());
				rowVector.add(orderItem.getProduct().getP_name());
				rowVector.add(orderItem.getProduct().getP_price());
				// rowVector.add(orderItem.getProduct().getP_desc());
				rowVector.add(orderItem.getProduct().getP_freeDelivery());
				tableVector.add(rowVector);
			}

			DefaultTableModel tableModel = new DefaultTableModel(tableVector, columnVector);
			orderDetailTable.setModel(tableModel);

		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
	}

	public void displayOrders()  {
		/**********주문데이터보기 [Jtable]*********/
		try {
			Vector columnVector = new Vector();
			columnVector.add("주문번호");
			columnVector.add("주문상품");
			columnVector.add("수량");
			columnVector.add("주문금액");
			columnVector.add("주문날짜");
			columnVector.add("주문아이디");
			
			List<Orders> orderList = frame.ordersService.orderListAddOrderItemList(frame.loginMember.getM_id());
			System.out.println(orderList.size());
			Vector tableVector = new Vector();
			for(Orders order : orderList) {
				Vector rowVector = new Vector();
				rowVector.add(order.getO_no());
				rowVector.add(order.getO_desc());
				rowVector.add(order.getO_qty());
				rowVector.add(order.getO_price());
				rowVector.add(order.getO_date());
				rowVector.add(order.getM_id());
				tableVector.add(rowVector);
			}
			DefaultTableModel tableModel = new DefaultTableModel(tableVector,columnVector);
			orderListTable.setModel(tableModel);
			
		}catch(Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
	
		
	}
	
}
