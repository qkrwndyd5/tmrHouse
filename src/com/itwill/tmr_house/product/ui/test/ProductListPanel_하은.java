package com.itwill.tmr_house.product.ui.test;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.itwill.tmr_house.cart.CartService;
import com.itwill.tmr_house.member.Member;
import com.itwill.tmr_house.member.MemberService;
import com.itwill.tmr_house.order.OrdersService;
import com.itwill.tmr_house.product.Product;
import com.itwill.tmr_house.product.ProductService;
import com.itwill.tmr_house.ui.TmrHouseMainFrame;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class ProductListPanel_하은 extends JPanel {
	TmrHouseMainFrame frame;
	
	public void setFrame(TmrHouseMainFrame frame) throws Exception{
		this.frame = frame;
		productList(null);
	}
	
	private JPanel productItemListPanel;
	private JTextField serchTextField;
	
	Product selectedProduct = null;
	
	/************ Service객체멤버변수선언 ************/
	MemberService memberService;
	ProductService productService;
	CartService cartService;
	OrdersService ordersService;
	private JScrollPane productListScrollPane;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public ProductListPanel_하은() throws Exception {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		productListScrollPane = new JScrollPane();
		productListScrollPane.setBounds(26, 68, 445, 578);
		add(productListScrollPane);
		
		productItemListPanel = new JPanel();
		productItemListPanel.setBackground(new Color(255, 255, 255));
		FlowLayout fl_productItemListPanel = (FlowLayout) productItemListPanel.getLayout();
		fl_productItemListPanel.setVgap(10);
		fl_productItemListPanel.setHgap(30);
		fl_productItemListPanel.setAlignment(FlowLayout.LEFT);
		productItemListPanel.setPreferredSize(new Dimension(260, 1000));
		productListScrollPane.setViewportView(productItemListPanel);
		
		/*************product item start*************/
		JPanel productPanel = new JPanel();
		productPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 상품 상세페이지로 이동
			}
		});
		productPanel.setBorder(null);
		productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		productPanel.setLayout(null);
		productPanel.setSize(new Dimension(120, 140));
		productPanel.setPreferredSize(new Dimension(200, 150));
		productPanel.setMinimumSize(new Dimension(150, 150));
		productPanel.setMaximumSize(new Dimension(250, 250));
		productPanel.setBounds(new Rectangle(0, 0, 120, 120));
		productPanel.setBackground(Color.WHITE);
		productPanel.setAlignmentY(1.0f);
		productPanel.setAlignmentX(1.0f);
		
		productItemListPanel.add(productPanel);
		
		JLabel productImageLabel = new JLabel("");
		productImageLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		productImageLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		productImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		productImageLabel.setIcon(new ImageIcon(ProductListPanel_하은.class.getResource("/com/itwill/tmr_house/product/images/plant_monstera150.png")));
		productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productImageLabel.setBounds(-15, 4, 185, 121);
		productPanel.add(productImageLabel);
		
		JLabel productNameLabel = new JLabel("몬스테라 화분");
		productNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productNameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		productNameLabel.setBounds(22, 135, 126, 15);
		productPanel.add(productNameLabel);
		
		JPanel serchPanel = new JPanel();
		serchPanel.setBackground(new Color(255, 255, 255));
		serchPanel.setBounds(0, 0, 500, 58);
		add(serchPanel);
		serchPanel.setLayout(null);
		
		serchTextField = new JTextField();
		serchTextField.setBackground(new Color(240, 240, 240));
		serchTextField.setBounds(26, 14, 228, 34);
		serchTextField.setToolTipText("검색어를 입력하세요.");
		serchTextField.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
		serchTextField.setColumns(10);
		serchPanel.add(serchTextField);
		
		JButton serchBtn = new JButton("");
		serchBtn.setBackground(new Color(64, 164, 255));
		serchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 조회된 페이지로 전환 필요
				try {
					String keyWord = serchTextField.getText();
					productList(keyWord);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		serchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		serchBtn.setBounds(280, 14, 57, 33);
		serchBtn.setIcon(new ImageIcon(ProductListPanel_하은.class.getResource("/com/itwill/tmr_house/product/images/search_25.png")));
		serchBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
		serchPanel.add(serchBtn);
		
		JButton cartButton = new JButton("");
		cartButton.setBorderPainted(false);
		cartButton.setOpaque(false);
		cartButton.setBackground(new Color(255, 255, 255));
		cartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// 카트로 전환
			}
		});
		cartButton.setBounds(349, 14, 57, 34);
		cartButton.setIcon(new ImageIcon(ProductListPanel_하은.class.getResource("/com/itwill/tmr_house/product/images/shopping-cart_25.png")));
		cartButton.setToolTipText("카트에 담기");
		serchPanel.add(cartButton);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(ProductListPanel_하은.class.getResource("/com/itwill/tmr_house/product/images/user 30.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(TmrHouseMainFrame.PANEL_MEMBER_MY_PAGE_SCREEN);
			}
		});
		btnNewButton.setBounds(411, 14, 58, 34);
		serchPanel.add(btnNewButton);
		/*************product item end*************/
		productService = new ProductService();
		productList(null);
	} // 생성자 끝
	
	public void productList(String keyword) throws Exception {
		List<Product> productList = null;
		if(keyword == null) {
			productList= productService.ProductList();
			//System.out.println(productList);
		}else {
			productList= productService.searchAll(keyword);
			//System.out.println(productList); // 잘 나옴
		}
		productItemListPanel.removeAll();
		for (Product product:productList) {
			JPanel productPanel = new JPanel();
			productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			productPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//상품디테일 패널로
					
				}
			});
			productPanel.setLayout(null);
			productPanel.setSize(new Dimension(120, 140));
			productPanel.setPreferredSize(new Dimension(170, 150));
			productPanel.setMinimumSize(new Dimension(150, 150));
			productPanel.setMaximumSize(new Dimension(250, 250));
			productPanel.setBounds(new Rectangle(0, 0, 120, 120));
			productPanel.setBorder(null);
			productPanel.setBackground(Color.WHITE);
			productPanel.setAlignmentY(1.0f);
			productPanel.setAlignmentX(1.0f);
			
			JLabel productImageLabel = new JLabel("");
			productImageLabel.setHorizontalTextPosition(SwingConstants.LEADING);
			productImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
			productImageLabel.setIcon(new ImageIcon(ProductListPanel_하은.class.getResource("/com/itwill/tmr_house/product/images/" + product.getP_img())));
			productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productImageLabel.setBounds(22, 4, 126, 121);
			productPanel.add(productImageLabel);
			
			JLabel productNameLabel = new JLabel(product.getP_name());
			productNameLabel.setFont(new Font("굴림", Font.BOLD, 14));
			productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productNameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			productNameLabel.setBounds(22, 135, 126, 15);
			productPanel.add(productNameLabel);
			
			productItemListPanel.add(productPanel);
		
			
		}
	}
	
		public void productDetail(Product product) throws Exception {
			productService.findByProductNo(product.getP_no());
		}
}
