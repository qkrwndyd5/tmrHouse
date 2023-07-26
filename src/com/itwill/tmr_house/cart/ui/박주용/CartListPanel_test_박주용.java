package com.itwill.tmr_house.cart.ui.박주용;

import java.awt.Dimension;
import java.util.List;

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
import com.itwill.tmr_house.member.MemberService;
import com.itwill.tmr_house.order.OrdersService;
import com.itwill.tmr_house.product.Product;
import com.itwill.tmr_house.product.ProductService;
import com.itwill.tmr_house.ui.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;


public class CartListPanel_test_박주용 extends JPanel {
	
	
	TmrHouseMainFrame frame;
	
	
	private JScrollPane cartContentPanelScrollPane;
	private JPanel cartContentPanel;
	private JLabel productImageLB;
	private JComboBox cartItemQtyCB;
	private JLabel productTitleLB;
	private JButton cartItemDeleteBTN_1;
	private JButton cartItemUpdateBTN;

	
	public void setFrame(TmrHouseMainFrame frame) throws Exception {
		this.frame = frame;
		
	}


	/**
	 * Create the panel.
	 */
	public CartListPanel_test_박주용() throws Exception {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		cartContentPanelScrollPane = new JScrollPane();
		cartContentPanelScrollPane.setBounds(0, 65, 477, 507);
		add(cartContentPanelScrollPane);
		
		cartContentPanel = new JPanel();
		cartContentPanel.setPreferredSize(new Dimension(10, 700));
		cartContentPanelScrollPane.setViewportView(cartContentPanel);
		cartContentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel cartItemPanel = new JPanel();
		cartItemPanel.setPreferredSize(new Dimension(460, 120));
		cartContentPanel.add(cartItemPanel);
		cartItemPanel.setLayout(null);
		
		productImageLB = new JLabel("");
		productImageLB.setIcon(new ImageIcon(CartListPanel_test_박주용.class.getResource("/com/itwill/tmr_house/product/김혜지/images/chair_rattan_wood.png")));
		productImageLB.setBounds(12, 20, 80, 80);
		cartItemPanel.add(productImageLB);
		
		productTitleLB = new JLabel("상품 이름");
		productTitleLB.setPreferredSize(new Dimension(60, 15));
		productTitleLB.setFont(new Font("굴림", Font.PLAIN, 10));
		productTitleLB.setBounds(101, 51, 126, 25);
		cartItemPanel.add(productTitleLB);
		
		cartItemQtyCB = new JComboBox();
		cartItemQtyCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					Integer.parseInt((String)cartItemQtyCB.getSelectedItem());
				}
				
			}
		});
		cartItemQtyCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cartItemQtyCB.setBounds(239, 50, 50, 25);
		cartItemPanel.add(cartItemQtyCB);
		
		cartItemDeleteBTN_1 = new JButton("삭제");
		cartItemDeleteBTN_1.setOpaque(false);
		cartItemDeleteBTN_1.setBackground(new Color(255, 255, 255));
		cartItemDeleteBTN_1.setFont(new Font("굴림", Font.PLAIN, 12));
		cartItemDeleteBTN_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cartItemDeleteBTN_1.setBounds(331, 68, 89, 32);
		cartItemPanel.add(cartItemDeleteBTN_1);
		
		cartItemUpdateBTN = new JButton("수정");
		cartItemUpdateBTN.setFont(new Font("굴림", Font.PLAIN, 12));
		cartItemUpdateBTN.setOpaque(false);
		cartItemUpdateBTN.setBackground(new Color(255, 255, 255));
		cartItemUpdateBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cartItemUpdateBTN.setBounds(331, 20, 89, 25);
		cartItemPanel.add(cartItemUpdateBTN);
		
		JButton orderSelectedBTN = new JButton("선택 상품 주문");
		orderSelectedBTN.setOpaque(false);
		orderSelectedBTN.setBounds(51, 592, 150, 25);
		add(orderSelectedBTN);
		
		JButton orderAllBTN = new JButton("전체 상품 주문");
		orderAllBTN.setBackground(new Color(64, 184, 255));
		orderAllBTN.setOpaque(false);
		orderAllBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					orderAllCart(frame.loginMember.getM_id());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 오더창으로 넘어가기
				frame.changePanel(TmrHouseMainFrame.PANEL_ORDERS_DETAIL_하은);
			}
		});
		orderAllBTN.setBounds(296, 592, 150, 25);
		add(orderAllBTN);
		
		JButton ordersHomeBtn = new JButton("");
		ordersHomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_LIST_PANEL);
			}
		});
		ordersHomeBtn.setBorderPainted(false);
		ordersHomeBtn.setOpaque(false);
		ordersHomeBtn.setIcon(new ImageIcon(CartListPanel_test_박주용.class.getResource("/com/itwill/tmr_house/member/images/home(30x30).png")));
		ordersHomeBtn.setBackground(new Color(64, 184, 255));
		ordersHomeBtn.setBounds(218, 651, 63, 39);
		add(ordersHomeBtn);
		
		JLabel lblNewLabel = new JLabel("Tomorrow's House");
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(83, 10, 304, 29);
		add(lblNewLabel);
		/****************카트 패널 끝*****************/
		
		
		/**************Service 객체 멤버 변수 초기화****************/
		

		

	}/**생성자 끝*/
	
	
	/*public void displayCartList(Member member) throws Exception {
		
		cartContentPanel.removeAll();
		List<Cart> cartList = frame.cartService.findCartItemByUserId(member.getM_id());
		System.out.println(cartList);
		for(final Cart cart : cartList) {
			
			JPanel cartItemPanel = new JPanel();
			cartItemPanel.setPreferredSize(new Dimension(420, 120));
			cartContentPanel.add(cartItemPanel);
			cartItemPanel.setLayout(null);
			
			JLabel productImageLB = new JLabel(cart.getProduct().getP_name());
			productImageLB.setIcon(new ImageIcon(CartListPanel_test_박주용.class.getResource("/com/itwill/tmr_house/product/images/"+cart.getProduct().getP_img())));
			productImageLB.setBounds(40, 20, 80, 80);
			cartItemPanel.add(productImageLB);
			
			JLabel productTitleLB = new JLabel(cart.getProduct().getP_name());
			productTitleLB.setBounds(132, 50, 100, 25);
			productTitleLB.setText(cart.getProduct().getP_name());
			cartItemPanel.add(productTitleLB);
			
			JLabel lblTotprice = new JLabel("가격");
			lblTotprice.setBounds(286, 50, 80, 25);
			lblTotprice.setText(Integer.toString(cart.getProduct().getP_price()));
			cartItemPanel.add(lblTotprice);
			
			JComboBox cartItemQtyCB = new JComboBox();
			cartItemQtyCB.setBounds(210, 50, 50, 25);
			cartItemPanel.add(cartItemQtyCB);
			
			JButton cartItemDeleteBTN = new JButton("삭제");
			//cartItemDeleteBTN.setIcon(new ImageIcon());
			cartItemDeleteBTN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						deleteCartItem(cart.getC_no());
						
//						cartPanel.remove(cartPanel);
						System.out.println("제품이 삭제되었습니다");
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});
			cartItemDeleteBTN.setFont(new Font("D2Coding", Font.BOLD, 10));
			cartItemDeleteBTN.setBounds(350, 75, 55, 23);
			cartItemPanel.add(cartItemDeleteBTN);
			
			cartItemUpdateBTN = new JButton("수정");
			cartItemUpdateBTN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			cartItemUpdateBTN.setFont(new Font("D2Coding", Font.BOLD, 10));
			cartItemUpdateBTN.setBounds(350, 20, 55, 23);
			cartItemPanel.add(cartItemUpdateBTN);
			
			
		}
		
	}
	*/
		public void displayCartList(String m_id) throws Exception {
		
		cartContentPanel.removeAll();
		List<Cart> cartList = frame.cartService.findCartItemByUserId(frame.loginMember.getM_id());
		System.out.println(cartList);
		for(final Cart cart : cartList) {
			
			JPanel cartItemPanel = new JPanel();
			cartItemPanel.setPreferredSize(new Dimension(420, 120));
			cartContentPanel.add(cartItemPanel);
			cartItemPanel.setLayout(null);
			
			JLabel productImageLB = new JLabel(cart.getProduct().getP_name());
			productImageLB.setIcon(new ImageIcon(CartListPanel_test_박주용.class.getResource("/com/itwill/tmr_house/product/images/"+cart.getProduct().getP_img())));
			productImageLB.setBounds(40, 20, 80, 80);
			cartItemPanel.add(productImageLB);
			
			JLabel productTitleLB = new JLabel(cart.getProduct().getP_name());
			productTitleLB.setBounds(132, 50, 100, 25);
			productTitleLB.setText(cart.getProduct().getP_name());
			cartItemPanel.add(productTitleLB);
			
			JLabel lblTotprice = new JLabel("가격");
			lblTotprice.setBounds(286, 50, 80, 25);
			lblTotprice.setText(Integer.toString(cart.getProduct().getP_price()));
			cartItemPanel.add(lblTotprice);
			
			JComboBox cartItemQtyCB = new JComboBox();
			cartItemQtyCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
			cartItemQtyCB.setBounds(210, 50, 50, 25);
			cartItemPanel.add(cartItemQtyCB);
			
			
			JButton cartItemDeleteBTN = new JButton("삭제");
			//cartItemDeleteBTN.setIcon(new ImageIcon());
			cartItemDeleteBTN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						deleteCartItem(cart.getC_no());
						displayCartList(frame.loginMember.getM_id());
//						cartPanel.remove(cartPanel);
						System.out.println("제품이 삭제되었습니다");
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});
			cartItemDeleteBTN.setFont(new Font("D2Coding", Font.BOLD, 10));
			cartItemDeleteBTN.setBounds(350, 75, 55, 23);
			cartItemPanel.add(cartItemDeleteBTN);
			
			cartItemUpdateBTN = new JButton("수정");
			cartItemUpdateBTN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			cartItemUpdateBTN.setFont(new Font("D2Coding", Font.BOLD, 10));
			cartItemUpdateBTN.setBounds(350, 20, 55, 23);
			cartItemPanel.add(cartItemUpdateBTN);
			
			
		}
		
	}
	
	public void orderAllCart(String m_id) throws Exception {
		frame.ordersService.cartOrder(m_id);
	}
	
	public void deleteCartItem(int c_no) throws Exception {
		frame.cartService.deleteCartItemByCartNo(c_no);
	}
}
