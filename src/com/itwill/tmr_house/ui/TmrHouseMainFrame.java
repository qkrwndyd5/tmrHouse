package com.itwill.tmr_house.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.tmr_house.cart.*;
import com.itwill.tmr_house.member.*;
import com.itwill.tmr_house.member.ui.*;
import com.itwill.tmr_house.order.*;
import com.itwill.tmr_house.product.*;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import com.itwill.tmr_house.order.ui.김하은.OrdersPanel_하은2;
import com.itwill.tmr_house.order.ui.김하은.OrdersDetailPanel_하은2;
import com.itwill.tmr_house.product.ui.김세연.ProductListPanel;
import com.itwill.tmr_house.product.ui.김세연.ProductDetailPanelChairRattan;
import com.itwill.tmr_house.product.ui.김세연.ProductDetailPanelChairSteel;
import com.itwill.tmr_house.product.ui.김세연.ProductDetailPanelMonstera;
import com.itwill.tmr_house.product.ui.김세연.ProductDetailPanelOlive;
import com.itwill.tmr_house.product.ui.김세연.ProductDetailPanelPendant;
import com.itwill.tmr_house.product.ui.김세연.ProductDetailPanelShortstand;
import com.itwill.tmr_house.product.ui.김세연.ProductDetailPanelTableSteel;
import com.itwill.tmr_house.product.ui.김세연.ProductDetailPanelTableWood;
import com.itwill.tmr_house.cart.ui.박주용.CartListPanel_test_박주용;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import com.itwill.tmr_house.order.ui.김하은.OrdersDetailPanel_하은;

public class TmrHouseMainFrame extends JFrame {
	
	private CardLayout cardLayout ;
	/*
	 * 패널 체인지 상수
	 */
	// 멤버
	public static final int PANEL_MEMBER_PRIMARY_SCREEN = 1;
	public static final int PANEL_MEMBER_JOIN_SCREEN = 2;
	public static final int PANEL_MEMBER_LOGIN_SCREEN = 3;
	public static final int PANEL_MEMBER_MY_PAGE_SCREEN = 4;
	

	// 20부터 시작함.
	public static final int PANEL_PRODUCT_LIST_PANEL = 20;
	public static final int PANEL_PRODUCT_TABLE_STEEL = 21;
	public static final int PANEL_PRODUCT_TABLE_WOOD = 22;
	public static final int PANEL_PRODUCT_CHAIR_STEEL = 23;
	public static final int PANEL_PRODUCT_CHAIR_WOOD = 24;
	public static final int PANEL_PRODUCT_LIGHTING_TABLE = 25;
	public static final int PANEL_PRODUCT_LIGHTING_PENDANT = 26;
	public static final int PANEL_PRODUCT_PLANT_MONSTERA = 27;
	public static final int PANEL_PRODUCT_PLANT_OLIVE = 28;

	public static final int PANEL_CARTLIST = 99;
	
	// 카트
	
	
	// 오더
	
	public static final int PANEL_ORDERS_DETAIL_하은 = 9;
	
	
	private JPanel contentPane;
	
	/*
	 * 1. Service 객체선언
	 */
	public MemberService memberService;
	public CartService cartService;
	public OrdersService ordersService;
	public ProductService productService;
	
	/*
	 * 2. 로그인 유저 객체 선언
	 */
	
	public Member loginMember = null;
	
	private JPanel parentPanel;
	private MemberPrimaryScreenPanel_하은 memberPrimaryScreenPanel_하은;
	private MemberJoinScreenPanel_하은 memberJoinScreenPanel_하은;
	private MemberLoginScreenPanel_하은 memberLoginScreenPanel_하은;
	private MemberMyPageScreenPanel_하은 memberMyPageScreenPanel_하은;
	private ProductListPanel productListPanel;
	private ProductDetailPanelChairRattan productDetailPanelChairRattan;
	private ProductDetailPanelChairSteel productDetailPanelChairSteel;
	private ProductDetailPanelMonstera productDetailPanelMonstera;
	private ProductDetailPanelOlive productDetailPanelOlive;
	private ProductDetailPanelPendant productDetailPanelPendant;
	private ProductDetailPanelShortstand productDetailPanelShortstand;
	private ProductDetailPanelTableSteel productDetailPanelTableSteel;
	private ProductDetailPanelTableWood productDetailPanelTableWood;
	private CartListPanel_test_박주용 cartListPanel_test_박주용;
	private OrdersDetailPanel_하은 ordersDetailPanel_하은;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TmrHouseMainFrame frame = new TmrHouseMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public TmrHouseMainFrame() throws Exception {
		setTitle("Tomorrow's House");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TmrHouseMainFrame.class.getResource("/com/itwill/tmr_house/member/images/home(30x30).png")));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		parentPanel = new JPanel();
		parentPanel.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println(evt);
			}
		});
		parentPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(parentPanel, BorderLayout.CENTER);
		cardLayout = new CardLayout(0, 0);
		parentPanel.setLayout(cardLayout);
		
		memberPrimaryScreenPanel_하은 = new MemberPrimaryScreenPanel_하은();
		parentPanel.add(memberPrimaryScreenPanel_하은, "1");
		
		memberJoinScreenPanel_하은 = new MemberJoinScreenPanel_하은();
		parentPanel.add(memberJoinScreenPanel_하은, "2");
		
		memberLoginScreenPanel_하은 = new MemberLoginScreenPanel_하은();
		parentPanel.add(memberLoginScreenPanel_하은, "3");

		memberMyPageScreenPanel_하은 = new MemberMyPageScreenPanel_하은();
		parentPanel.add(memberMyPageScreenPanel_하은, "4");
		
	
		
		productListPanel = new ProductListPanel();
		parentPanel.add(productListPanel, "20");
		
		productDetailPanelChairRattan = new ProductDetailPanelChairRattan();
		parentPanel.add(productDetailPanelChairRattan, "24");
		
		productDetailPanelChairSteel = new ProductDetailPanelChairSteel();
		parentPanel.add(productDetailPanelChairSteel, "23");
		
		productDetailPanelMonstera = new ProductDetailPanelMonstera();
		parentPanel.add(productDetailPanelMonstera, "27");
		
		productDetailPanelOlive = new ProductDetailPanelOlive();
		parentPanel.add(productDetailPanelOlive, "28");
		
		productDetailPanelPendant = new ProductDetailPanelPendant();
		parentPanel.add(productDetailPanelPendant, "26");
		
		productDetailPanelShortstand = new ProductDetailPanelShortstand();
		parentPanel.add(productDetailPanelShortstand, "25");
		
		productDetailPanelTableSteel = new ProductDetailPanelTableSteel();
		parentPanel.add(productDetailPanelTableSteel, "21");
		
		productDetailPanelTableWood = new ProductDetailPanelTableWood();
		parentPanel.add(productDetailPanelTableWood, "22");
	
		cartListPanel_test_박주용 = new CartListPanel_test_박주용();
		parentPanel.add(cartListPanel_test_박주용, "99");
		
		ordersDetailPanel_하은 = new OrdersDetailPanel_하은();
		parentPanel.add(ordersDetailPanel_하은, "9");
		
	/******service 객체 생성******/
		memberService = new MemberService();
		cartService = new CartService();
		productService = new ProductService();
		ordersService = new OrdersService();
		
		memberPrimaryScreenPanel_하은.setFrame(this);
		memberJoinScreenPanel_하은.setFrame(this);
		memberLoginScreenPanel_하은.setFrame(this);
		memberMyPageScreenPanel_하은.setFrame(this);
	
		ordersDetailPanel_하은.setFrame(this);
		productListPanel.setFrame(this);
		productDetailPanelChairRattan.setFrame(this);
		productDetailPanelChairSteel.setFrame(this);
		productDetailPanelMonstera.setFrame(this);
		productDetailPanelOlive.setFrame(this);
		productDetailPanelPendant.setFrame(this);
		productDetailPanelShortstand.setFrame(this);
		productDetailPanelTableSteel.setFrame(this);
		productDetailPanelTableWood.setFrame(this);
		
		
		cartListPanel_test_박주용.setFrame(this);
		
		
		
		
		
	}
	
	
	/******************패널 체인지 메소드************************/
	
	public void changePanel(int panel_no) {
		if(panel_no == PANEL_MEMBER_PRIMARY_SCREEN) {
			
			cardLayout.show(parentPanel, "1");
			
		}else if(panel_no == PANEL_MEMBER_JOIN_SCREEN) {
			cardLayout.show(parentPanel, "2");
			
		}else if(panel_no == PANEL_MEMBER_LOGIN_SCREEN) {
			cardLayout.show(parentPanel, "3");
			
		}else if(panel_no == PANEL_MEMBER_MY_PAGE_SCREEN) {
			cardLayout.show(parentPanel, "4");
			
		}else if(panel_no == PANEL_PRODUCT_LIST_PANEL) {
			cardLayout.show(parentPanel, "20");
			
		}else if(panel_no == PANEL_PRODUCT_TABLE_STEEL) {
			
			cardLayout.show(parentPanel, "21");
			
		}else if(panel_no == PANEL_PRODUCT_TABLE_WOOD) {
			
			cardLayout.show(parentPanel, "22");
			
		}else if(panel_no == PANEL_PRODUCT_CHAIR_STEEL) {
			
			cardLayout.show(parentPanel, "23");
			
		}else if(panel_no == PANEL_PRODUCT_CHAIR_WOOD) {
			cardLayout.show(parentPanel, "24");
			
		}else if(panel_no == PANEL_PRODUCT_LIGHTING_TABLE) {
			cardLayout.show(parentPanel, "26");
			
		}else if(panel_no == PANEL_PRODUCT_LIGHTING_PENDANT) {
			cardLayout.show(parentPanel, "25");
			
		}else if(panel_no == PANEL_PRODUCT_PLANT_MONSTERA) {
			cardLayout.show(parentPanel, "27");
			
		}else if(panel_no == PANEL_PRODUCT_PLANT_OLIVE) {
			cardLayout.show(parentPanel, "28");
				
		}else if(panel_no == PANEL_ORDERS_DETAIL_하은) {
			cardLayout.show(parentPanel, "9");
			ordersDetailPanel_하은.displayOrders();
		}else if(panel_no == PANEL_CARTLIST ) {
			
			cardLayout.show(parentPanel, "99");
			try {
				cartListPanel_test_박주용.displayCartList(loginMember.getM_id());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
