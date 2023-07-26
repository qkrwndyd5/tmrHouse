package com.itwill.tmr_house.cart.ui.김혜지;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.itwill.tmr_house.cart.Cart;
import com.itwill.tmr_house.cart.CartService;
import com.itwill.tmr_house.member.Member;
import com.itwill.tmr_house.order.OrdersService;

public class CartListPanel_김혜지 extends JPanel {
	private JPanel cartContentPanel;

	/******service객체 멤버변수 선언***********/
	private CartService cartService;
	private OrdersService ordersService;
	
	
	/*********로그인한 user 객체 저장할 user 객체 선언********/
	private Member loginMember = null;
	private JScrollPane cartContentPanelScrollPane;
	private JLabel productTitleLB;
	private JLabel productTotPriceLB;
	private JCheckBox cartSelectCheckBox;
	private JComboBox cartItemQtyCB;
	private JButton cartItemUpdateBTN;
	private JButton cartItemDeleteBTN;
	private JButton orderSelectedBTN;
	private JButton orderAllBTN;
	private JLabel cartTotPriceLB;
	
	
	/**
	 * Create the panel.
	 */
	public CartListPanel_김혜지() throws Exception{
		setLayout(null);
		
//		List<Cart> cartList = cartService.findCartItemByUserId(loginMember.getM_id());
//		for (Cart cart : cartList) {
			
		cartContentPanelScrollPane = new JScrollPane();
		cartContentPanelScrollPane.setBounds(20, 100, 460, 450);
		add(cartContentPanelScrollPane);
		
		cartContentPanel = new JPanel();
		cartContentPanel.setPreferredSize(new Dimension(10, 700));
		cartContentPanelScrollPane.setViewportView(cartContentPanel);
		
		JPanel cartItemPanel = new JPanel();
		cartItemPanel.setPreferredSize(new Dimension(420, 120));
		cartContentPanel.add(cartItemPanel);
		cartItemPanel.setLayout(null);

		JLabel productImageLB = new JLabel("");
		//
		
		
		
		//
		productImageLB.setIcon(new ImageIcon(CartListPanel_김혜지.class.getResource("/com/itwill/tmr_house/product/images/80_chair_rattan_wood.png")));
		productImageLB.setBounds(40, 20, 80, 80);
		cartItemPanel.add(productImageLB);
		
		
		
		JLabel productTitleLB = new JLabel("");
		productTitleLB.setBounds(132, 50, 100, 25);
		cartItemPanel.add(productTitleLB);
		
		//
		
		
		
		productTotPriceLB = new JLabel("가격");
		productTotPriceLB.setBounds(286, 50, 80, 25);
		cartItemPanel.add(productTotPriceLB);
		
		/* 선택 주문을 위한 체크박스 액션 */
		cartSelectCheckBox = new JCheckBox("");
		cartSelectCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cartSelectCheckBox.setBounds(10, 50, 25, 25);
		cartItemPanel.add(cartSelectCheckBox);
		
		cartItemQtyCB = new JComboBox();
		cartItemQtyCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		cartItemQtyCB.setBounds(210, 50, 50, 25);
		cartItemPanel.add(cartItemQtyCB);
		
		/**************cartItem수량 수정 버튼*************/
		cartItemUpdateBTN = new JButton("수정");
		cartItemUpdateBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cartItemUpdateBTN.setBounds(350, 50, 55, 23);
		cartItemPanel.add(cartItemUpdateBTN);
		
		cartItemDeleteBTN = new JButton("삭제");
		cartItemDeleteBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("상품 삭제");
					int c_no = 1;
					cartService.deleteCartItemByCartNo(c_no);
				}catch(Exception e1){
					
					
				}
			}
		});
		cartItemDeleteBTN.setBounds(350, 87, 55, 23);
		cartItemPanel.add(cartItemDeleteBTN);
		
		orderSelectedBTN = new JButton("선택 상품 주문");
		orderSelectedBTN.setBounds(50, 650, 150, 25);
		add(orderSelectedBTN);
		
		orderAllBTN = new JButton("전체 상품 주문");
		orderAllBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********주문***********/
				try {
					System.out.println("장바구니에서 주문");
					ordersService.cartOrder(loginMember.getM_id());
				}catch(Exception e1){
					System.out.println(e1.getMessage());
				}
			}
		});
		orderAllBTN.setBounds(300, 650, 150, 25);
		add(orderAllBTN);
		
		cartTotPriceLB = new JLabel("Total Price");
		cartTotPriceLB.setBounds(300, 600, 150, 25);
		add(cartTotPriceLB);

		
		/**********service 객체멤버변수 초기화*************/
		cartService = new CartService();	
		
		
		
		
		
		
		
	}//생성자 끝
	
	private void displayCartList(Cart cart) {
		productTitleLB.setText(cart.getProduct().getP_name());
		cartItemQtyCB.setSelectedItem(cart.getC_qty());
		
		
		//productTotPriceLB.setText(cart.getProduct().getP_price()*cart.getC_qty());
		
		
	}
	
	
	
	
	
//	public void displayCartList() throws Exception {
//		cartContentPanel.removeAll();
//		List<Cart> cartList = cartService.findCartItemByUserId(loginMember.getM_id());
//		for(Cart cart : cartList) {
//			/*******cartItemPanel ********/
//			JPanel cartItemPanel = new JPanel();
//			cartItemPanel.setPreferredSize(new Dimension(420, 120));
//			cartContentPanel.add(cartItemPanel);
//			cartItemPanel.setLayout(null);
//			
//			JLabel productImageLB = new JLabel("");
//			productImageLB.setIcon(new ImageIcon(CartListPanel.class.getResource("/com/itwill/tmr_house/product/images/80_chair_rattan_wood.png")));
//			productImageLB.setBounds(40, 20, 80, 80);
//			cartItemPanel.add(productImageLB);
//			
//			JLabel productTitleLB = new JLabel("상품명");
//			productTitleLB.setBounds(132, 50, 100, 25);
//			cartItemPanel.add(productTitleLB);
//			
//			JLabel productTotPriceLB = new JLabel("가격");
//			productTotPriceLB.setBounds(286, 50, 80, 25);
//			cartItemPanel.add(productTotPriceLB);
//			
//			JButton cartItemDeleteBTN = new JButton("삭제");
//			cartItemDeleteBTN.setBounds(350, 87, 55, 23);
//			cartItemPanel.add(cartItemDeleteBTN);
//			
//			cartItemDeleteBTN.addActionListener(new ActionListener() {
//				private Cart c = cart;
//				JPanel cPanel = cartItemPanel;
//				public void actionPerformed(ActionEvent e) {
//					/************카트 아이템 1개 삭제**********/
//					try {
//						//카트 아이템 삭제
//						int deleteCartItemCount = cartService.deleteCartItemByCartNo(c.getC_no());
//						JOptionPane.showMessageDialog(null, deleteCartItemCount + " 개의 제품이 삭제되었습니다.");
//						//카트 수량 아이콘 변경
////						int cartItemCount = cartService.findCartItemByCartNo(c.getCart_no());
////						cartCountLB
//						//카트 리스트 보여주기
////						displayCartList();
//						
//						
//					}catch (Exception ex){
//						ex.printStackTrace();
//					}
//					/*****************************************/
//					
//				}
//			});
//			
//
//			
//		}
//	}
	
	
	
	
	
	
	
	
	
	
}


