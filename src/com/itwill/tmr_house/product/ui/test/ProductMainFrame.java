package com.itwill.tmr_house.product.ui.test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.tmr_house.cart.CartService;
import com.itwill.tmr_house.member.MemberService;
import com.itwill.tmr_house.order.OrdersService;
import com.itwill.tmr_house.product.ProductService;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class ProductMainFrame extends JFrame {
	ProductMainFrame frame;
	private JPanel contentPane;
	
	MemberService memberService = new MemberService();
	ProductService productService = new ProductService();
	CartService cartService = new CartService();
	OrdersService orderservice = new OrdersService();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductMainFrame frame = new ProductMainFrame();
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
	public ProductMainFrame() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		ProductListPanel_하은 productListPanel = new ProductListPanel_하은();
		panel.add(productListPanel, BorderLayout.CENTER);
		
		/************************************
		 * 3.Service객체생성
		 ************************************/
		memberService = new MemberService();
		productService = new ProductService();
		cartService = new CartService();
		orderservice = new OrdersService();
	}
}
