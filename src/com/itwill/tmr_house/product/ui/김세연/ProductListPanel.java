package com.itwill.tmr_house.product.ui.김세연;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.itwill.tmr_house.cart.CartService;
import com.itwill.tmr_house.member.Member;
import com.itwill.tmr_house.member.MemberService;
import com.itwill.tmr_house.order.OrdersService;
import com.itwill.tmr_house.product.Product;
import com.itwill.tmr_house.product.ProductService;
//import com.itwill.tmr_house.ui.TmrHouseMainFrame;
import com.itwill.tmr_house.ui.TmrHouseMainFrame;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

//import javax.net.ssl.CertPathTrustManagerParameters;
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
	
	public void setFrame(TmrHouseMainFrame frame) {
		this.frame = frame;
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
		});
		productPanel.setBorder(null);
		productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		productPanel.setLayout(null);
		productPanel.setSize(new Dimension(120, 140));
		productPanel.setPreferredSize(new Dimension(200, 150));
		productPanel.setMinimumSize(new Dimension(150, 150));
		productPanel.setMaximumSize(new Dimension(250, 250));
		productPanel.setBounds(new Rectangle(0, 0, 120, 120));
		productPanel.setBackground(new Color(192, 192, 192));
		productPanel.setAlignmentY(1.0f);
		productPanel.setAlignmentX(1.0f);
		
		productItemListPanel.add(productPanel);
		
		JLabel productImageLabel = new JLabel("");
		/*productImageLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});*/
		productImageLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		productImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		productImageLabel.setIcon(new ImageIcon(ProductListPanel.class.getResource("/com/itwill/tmr_house/product/images/plant_monstera150.png")));
		productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productImageLabel.setBounds(0, 0, 185, 121);
		productPanel.add(productImageLabel);
		
 		JLabel productNameLabel = new JLabel("몬스테라 화분");
 		productNameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		productNameLabel.setFont(new Font("굴림", Font.BOLD, 14));
		productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productNameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		productNameLabel.setBounds(0, 131, 200, 15);
		productPanel.add(productNameLabel);
		
		JPanel serchPanel = new JPanel();
		serchPanel.setBackground(new Color(255, 255, 255));
		serchPanel.setBounds(0, 0, 500, 58);
		add(serchPanel);
		serchPanel.setLayout(null);
		
		serchTextField = new JTextField();
		serchTextField.setBounds(26, 13, 254, 35);
		serchTextField.setToolTipText("검색어를 입력하세요.");
		serchTextField.setFont(new Font("D2Coding ligature", Font.PLAIN, 15));
		serchTextField.setColumns(10);
		serchPanel.add(serchTextField);
		
		JButton serchBtn = new JButton("");
		serchBtn.setBackground(new Color(64, 184, 255));
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
		serchBtn.setBounds(291, 15, 57, 33);
		serchBtn.setIcon(new ImageIcon(ProductListPanel.class.getResource("/com/itwill/tmr_house/product/images/search_25.png")));
		serchBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
		serchPanel.add(serchBtn);
		
		JButton cartButton = new JButton("");
		cartButton.setBackground(new Color(255, 255, 255));
		cartButton.setBorderPainted(false);
		cartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// 카트로 전환
				frame.changePanel(TmrHouseMainFrame.PANEL_CARTLIST);
				
			}
		});
		cartButton.setBounds(353, 15, 57, 34);
		cartButton.setIcon(new ImageIcon(ProductListPanel.class.getResource("/com/itwill/tmr_house/product/images/shopping-cart_25.png")));
		cartButton.setToolTipText("카트에 담기");
		serchPanel.add(cartButton);
		
		JButton myPageButton = new JButton("");
		myPageButton.setBackground(new Color(255, 255, 255));
		myPageButton.setBorderPainted(false);
		myPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.changePanel(TmrHouseMainFrame.PANEL_MEMBER_MY_PAGE_SCREEN);
			}
		});
		myPageButton.setIcon(new ImageIcon(ProductListPanel.class.getResource("/com/itwill/tmr_house/product/images/user 30.png")));
		myPageButton.setBounds(416, 16, 53, 34);
		serchPanel.add(myPageButton);
		/*************product item end*************/
		productService = new ProductService();
		productList(null);
		
		
	}
	
	public void productList(String keyword) throws Exception {
		List<Product> productList = null;
		if (keyword == null) {
			productList = productService.ProductList();
//			System.out.println(productList);
		} else {
			productList = productService.searchAll(keyword);
		}
		productItemListPanel.removeAll();
		for (Product product : productList) {
			JPanel productPanel = new JPanel();
			// productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
			productImageLabel.setIcon(new ImageIcon(ProductListPanel.class.getResource("/com/itwill/tmr_house/product/images/" + product.getP_img())));
			productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productImageLabel.setBounds(22, 4, 126, 121);
			productPanel.add(productImageLabel);
			
			final JLabel productNameLabel = new JLabel(product.getP_name());
			productNameLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						String p_name = productNameLabel.getText();
						findProductDetail(p_name);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			productNameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			productNameLabel.setFont(new Font("굴림", Font.BOLD, 14));
			productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productNameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			productNameLabel.setBounds(22, 135, 126, 15);
			productPanel.add(productNameLabel);
			
			productItemListPanel.add(productPanel);
			
		}
	}
	
	/**************************** 최종 메인프레임의 changePanel 메소드로 바꿈 *********************************************/
	public void findProductDetail(String p_name) throws Exception {
		List<Product> productList = productService.ProductList();
		if (productList.get(0).getP_name().equals(p_name)) {
			frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_TABLE_STEEL);
		} else if(productList.get(1).getP_name().equals(p_name)) {
			frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_TABLE_WOOD);
		} else if(productList.get(2).getP_name().equals(p_name)) {
			frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_CHAIR_STEEL);
		} else if(productList.get(3).getP_name().equals(p_name)) {
			frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_CHAIR_WOOD);
		} else if(productList.get(4).getP_name().equals(p_name)) {
			frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_LIGHTING_TABLE);
		} else if(productList.get(5).getP_name().equals(p_name)) {
			frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_LIGHTING_PENDANT);
		} else if(productList.get(6).getP_name().equals(p_name)) {
			frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_PLANT_MONSTERA);
		} else if(productList.get(7).getP_name().equals(p_name)) {
			frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_PLANT_OLIVE);
		}
	}
}
