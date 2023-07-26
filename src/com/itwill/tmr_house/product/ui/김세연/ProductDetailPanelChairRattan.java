package com.itwill.tmr_house.product.ui.김세연;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.itwill.tmr_house.cart.Cart;
import com.itwill.tmr_house.cart.CartService;
import com.itwill.tmr_house.member.Member;
import com.itwill.tmr_house.member.MemberService;
import com.itwill.tmr_house.order.OrdersService;
import com.itwill.tmr_house.product.Product;
import com.itwill.tmr_house.product.ProductService;
import com.itwill.tmr_house.ui.TmrHouseMainFrame;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.GridLayout;

public class ProductDetailPanelChairRattan extends JPanel {
	
	TmrHouseMainFrame frame;
	
	public void setFrame(TmrHouseMainFrame frame) {
		this.frame = frame;
	}

	/************ Service객체멤버변수선언 ************/
	MemberService memberService;
	ProductService productService;
	CartService cartService;
	OrdersService ordersService;
	
	/***** 로그인한 member객체저장할 Member객체선언 **********/
	Member loginMember = null;
	Product product = null;
	private JComboBox qtyComboBox;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public ProductDetailPanelChairRattan() throws Exception {
		setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		
		JButton productListButton = new JButton("이전 페이지로");
		productListButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		productListButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 상품리스트 페이지로 전환
				frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_LIST_PANEL);
			}
		});
		northPanel.setLayout(new GridLayout(0, 1, 0, 0));
		northPanel.add(productListButton);
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel productDetailPanel = new JPanel();
		centerPanel.add(productDetailPanel);
		productDetailPanel.setLayout(null);
		
		JLabel productImgLabel = new JLabel("");
		productImgLabel.setBounds(12, 60, 250, 350);
		productDetailPanel.add(productImgLabel);
		productImgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productImgLabel.setIcon(new ImageIcon(ProductDetailPanelChairRattan.class.getResource("/com/itwill/tmr_house/product/images/chair_rattan_wood350.png")));
		
		JLabel productNameLabel = new JLabel("라탄 원목 의자");
		productNameLabel.setBounds(288, 90, 200, 50);
		productDetailPanel.add(productNameLabel);
		productNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		JLabel qtyLabel = new JLabel("수   량");
		qtyLabel.setBounds(288, 176, 50, 22);
		productDetailPanel.add(qtyLabel);
		qtyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		qtyLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		qtyComboBox = new JComboBox();
		qtyComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					int cart_qty=Integer.parseInt((String)qtyComboBox.getSelectedItem());
//					System.out.println(cart_qty);
				}
			}
		});
		
		qtyComboBox.setBounds(419, 179, 42, 22);
		productDetailPanel.add(qtyComboBox);
		qtyComboBox.setFont(new Font("굴림", Font.PLAIN, 13));
		qtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		JLabel productDetailLabel = new JLabel("고무나무 원목과 라탄이 조화로운 의자");
		productDetailLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		productDetailLabel.setBounds(12, 511, 476, 120);
		productDetailPanel.add(productDetailLabel);
		
		JButton directOrderButton = new JButton("바로 구매");
		directOrderButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				바로구매
				try {
					directOrder(Integer.parseInt((String)qtyComboBox.getSelectedItem()));
					frame.changePanel(TmrHouseMainFrame.PANEL_ORDERS_DETAIL_하은);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		directOrderButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		directOrderButton.setBounds(37, 430, 200, 50);
		productDetailPanel.add(directOrderButton);
		
		JButton addCartButton = new JButton("카트 담기");
		addCartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				카트에 담기
				try {
					addCart(Integer.parseInt((String)qtyComboBox.getSelectedItem()));
//				카트 페이지로 전환

					frame.changePanel(TmrHouseMainFrame.PANEL_CARTLIST);
					
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		addCartButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		addCartButton.setBounds(261, 430, 200, 50);
		productDetailPanel.add(addCartButton);
		
		JLabel freeDeliveryLabel = new JLabel("배송비");
		freeDeliveryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		freeDeliveryLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		freeDeliveryLabel.setBounds(288, 313, 50, 22);
		productDetailPanel.add(freeDeliveryLabel);
		
		JLabel categoryLabel = new JLabel("가구 > 의자 > 인테리어의자");
		categoryLabel.setFont(new Font("맑은 고딕", Font.ITALIC, 15));
		categoryLabel.setBounds(12, 10, 235, 37);
		productDetailPanel.add(categoryLabel);
		
		JLabel priceLabel = new JLabel("가   격");
		priceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		priceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		priceLabel.setBounds(288, 246, 50, 22);
		productDetailPanel.add(priceLabel);
		
		JLabel priceDataLabel = new JLabel("50,000원");
		priceDataLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		priceDataLabel.setBounds(393, 249, 68, 22);
		productDetailPanel.add(priceDataLabel);
		
		JLabel freeDeliveryDataLabel = new JLabel("무료배송");
		freeDeliveryDataLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		freeDeliveryDataLabel.setBounds(393, 316, 68, 22);
		productDetailPanel.add(freeDeliveryDataLabel);

		/************ Service객체멤버변수선언 ************/
		memberService = new MemberService();
		productService = new ProductService();
		cartService = new CartService();
		ordersService = new OrdersService();

	} // 생성
	
	public Product findProduct() throws Exception {
		Product findProduct = productService.findByProductNo(8);
		return findProduct;
	}
	
	public void directOrder(int cart_qty) throws Exception {
		Product product;
		product = productService.findByProductNo(4);
		/****************************** loginMember id 가져와주기 **********************************/
		ordersService.directOrder(frame.loginMember.getM_id(), product.getP_no(), cart_qty);
	}
	
	public void addCart(int cart_qty) throws Exception {
		Product product;
		product = productService.findByProductNo(4);
		/****************************** loginMember id 가져와주기 **********************************/
		cartService.insertCart(new Cart(0, cart_qty, frame.loginMember.getM_id(), product));
		}
}
