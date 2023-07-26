package com.itwill.tmr_house.product.ui.test;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ProductDetailPanelMonstera_하은 extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProductDetailPanelMonstera_하은() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(255, 255, 255));
		add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("~ 상품 상세보기 페이지~");
		northPanel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(ProductDetailPanelMonstera_하은.class.getResource("/com/itwill/tmr_house/product/images/shopping-cart_25.png")));
		northPanel.add(btnNewButton);
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		centerPanel.add(panel);
		panel.setLayout(null);
		
		JLabel productImgLabel1 = new JLabel("");
		productImgLabel1.setBounds(12, 60, 250, 350);
		panel.add(productImgLabel1);
		productImgLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		productImgLabel1.setIcon(new ImageIcon(ProductDetailPanelMonstera_하은.class.getResource("/com/itwill/tmr_house/product/images/plant_monstera350.png")));
		
		JLabel productNameLabel = new JLabel("몬스테라 화분");
		productNameLabel.setBounds(288, 90, 200, 50);
		panel.add(productNameLabel);
		productNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("수   량");
		lblNewLabel_1.setBounds(288, 176, 50, 22);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JComboBox qtyComboBox = new JComboBox();
		qtyComboBox.setBounds(419, 179, 42, 22);
		panel.add(qtyComboBox);
		qtyComboBox.setFont(new Font("굴림", Font.PLAIN, 13));
		qtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		JLabel productDetailLabel = new JLabel("초보자도 키우기 쉬운 공기정화 식물");
		productDetailLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		productDetailLabel.setBounds(12, 511, 476, 120);
		panel.add(productDetailLabel);
		
		JButton direcOrderButton = new JButton("바로 구매");
		direcOrderButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		direcOrderButton.setBounds(37, 430, 200, 50);
		panel.add(direcOrderButton);
		
		JButton addCartButton = new JButton("카트 담기");
		addCartButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		addCartButton.setBounds(261, 430, 200, 50);
		panel.add(addCartButton);
		
		JLabel shippingLabel = new JLabel("배송비");
		shippingLabel.setHorizontalAlignment(SwingConstants.LEFT);
		shippingLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		shippingLabel.setBounds(288, 240, 50, 22);
		panel.add(shippingLabel);
		
		JLabel shippingLabel_1 = new JLabel("무료배송 여부 표시");
		shippingLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		shippingLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		shippingLabel_1.setBounds(350, 241, 111, 22);
		panel.add(shippingLabel_1);
		
		JLabel totLabel = new JLabel("합   계");
		totLabel.setHorizontalAlignment(SwingConstants.LEFT);
		totLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		totLabel.setBounds(288, 300, 50, 22);
		panel.add(totLabel);
		
		JLabel totLabel_1 = new JLabel("원");
		totLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		totLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		totLabel_1.setBounds(432, 300, 29, 22);
		panel.add(totLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("합계 표시");
		lblNewLabel_2.setBounds(363, 307, 57, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("데코/식물 > 플라워/식물 > 화분");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.ITALIC, 15));
		lblNewLabel_4.setBounds(12, 10, 235, 37);
		panel.add(lblNewLabel_4);
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(new Color(255, 255, 255));
		add(southPanel, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(84, 164, 255));
		btnNewButton_1.setIcon(new ImageIcon(ProductDetailPanelMonstera_하은.class.getResource("/com/itwill/tmr_house/member/images/home(30x30).png")));
		southPanel.add(btnNewButton_1);

	}
}
