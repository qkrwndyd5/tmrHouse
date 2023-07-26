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

public class ProductListPanel extends JPanel {
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
	public ProductListPanel() throws Exception {
		setLayout(null);
		
		productListScrollPane = new JScrollPane();
		productListScrollPane.setBounds(26, 68, 445, 578);
		add(productListScrollPane);
		
		productItemListPanel = new JPanel();
		FlowLayout fl_productItemListPanel = (FlowLayout) productItemListPanel.getLayout();
		fl_productItemListPanel.setVgap(10);
		fl_productItemListPanel.setHgap(30);
		fl_productItemListPanel.setAlignment(FlowLayout.LEFT);
		productItemListPanel.setPreferredSize(new Dimension(260, 1000));
		productListScrollPane.setViewportView(productItemListPanel);
		
		/*************product item start*************/
		JPanel productPanel = new JPanel();
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
		productImageLabel.setIcon(new ImageIcon(ProductListPanel.class.getResource("/com/itwill/tmr_house/product/images/plant_monstera150.png")));
		productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productImageLabel.setBounds(-15, 4, 185, 121);
		productPanel.add(productImageLabel);
		
		JLabel productNameLabel = new JLabel("몬스테라 화분");
		productNameLabel.setFont(new Font("굴림", Font.BOLD, 14));
		productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productNameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		productNameLabel.setBounds(22, 135, 126, 15);
		productPanel.add(productNameLabel);
		
		JPanel serchPanel = new JPanel();
		serchPanel.setBounds(0, 0, 500, 58);
		add(serchPanel);
		serchPanel.setLayout(null);
		
		serchTextField = new JTextField();
		serchTextField.setBounds(26, 14, 306, 34);
		serchTextField.setToolTipText("검색어를 입력하세요.");
		serchTextField.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
		serchTextField.setColumns(10);
		serchPanel.add(serchTextField);
		
		JButton serchBtn = new JButton("");
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
		serchBtn.setBounds(344, 14, 57, 33);
		serchBtn.setIcon(new ImageIcon(ProductListPanel.class.getResource("/com/itwill/tmr_house/product/images/search_25.png")));
		serchBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
		serchPanel.add(serchBtn);
		
		JButton cartButton = new JButton("");
		cartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// 카드로 전환
			}
		});
		cartButton.setBounds(413, 14, 57, 34);
		cartButton.setIcon(new ImageIcon(ProductListPanel.class.getResource("/com/itwill/tmr_house/product/images/shopping-cart_25.png")));
		cartButton.setToolTipText("카트에 담기");
		serchPanel.add(cartButton);
		/*************product item end*************/
		productService = new ProductService();
		productList(null);
	}
	
	public void productList(String keyword) throws Exception {
		List<Product> productList=null;
		if(keyword==null) {
			productList= productService.ProductList();
			System.out.println(productList);
		}else {
			productList= productService.searchAll(keyword);
		}
		
		for (Product product:productList) {
			JPanel productPanel = new JPanel();
			productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			productPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
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
			productImageLabel.setIcon(new ImageIcon(ProductListPanel.class.getResource("/com/itwill/tmr_house/product/images/plant_monstera150.png")));
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
}
