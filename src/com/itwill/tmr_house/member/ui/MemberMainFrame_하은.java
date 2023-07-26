package com.itwill.tmr_house.member.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

public class MemberMainFrame_하은 extends JFrame {

	private JPanel contentPane;
	private JPanel parentPanel;
	private CardLayout cardLayout;
	private MemberJoinScreenPanel_하은 memberJoinScreenPanel_하은;
	private MemberLoginScreenPanel_하은 memberLoginScreenPanel_하은;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMainFrame_하은 frame = new MemberMainFrame_하은();
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
	public MemberMainFrame_하은() throws Exception {
		setTitle("내일의 집");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		parentPanel = new JPanel();
		contentPane.add(parentPanel, BorderLayout.CENTER);
		parentPanel.setLayout(new CardLayout(0, 0));
		
		
		
		memberLoginScreenPanel_하은 = new MemberLoginScreenPanel_하은();
		parentPanel.add(memberLoginScreenPanel_하은, "name_1549632722540400");
		
	}

}
