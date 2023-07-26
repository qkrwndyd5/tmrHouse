package com.itwill.tmr_house.member.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import com.itwill.tmr_house.ui.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class MemberPrimaryScreenPanel_하은 extends JPanel {
	
	/********메인프레임 참조********/
	TmrHouseMainFrame frame;
	
	
	public void setFrame(TmrHouseMainFrame frame) {
		this.frame = frame;
	}


	/**
	 * Create the panel.
	 */
	public MemberPrimaryScreenPanel_하은() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel primaryScreenNorthPanel = new JPanel();
		primaryScreenNorthPanel.setBackground(new Color(255, 255, 255));
		add(primaryScreenNorthPanel, BorderLayout.NORTH);
		
		JTextPane appTitleTextPane = new JTextPane();
		appTitleTextPane.setBackground(new Color(255, 255, 255));
		appTitleTextPane.setFont(new Font("D2Coding", Font.BOLD, 55));
		appTitleTextPane.setText("Tomorrow's House");
		primaryScreenNorthPanel.add(appTitleTextPane);
		
		JPanel primaryScreenCenterPanel = new JPanel();
		primaryScreenCenterPanel.setBackground(new Color(255, 255, 255));
		add(primaryScreenCenterPanel, BorderLayout.CENTER);
		primaryScreenCenterPanel.setLayout(null);
		
		JLabel houseImageLB = new JLabel("");
		houseImageLB.setBounds(50, 37, 400, 400);
		houseImageLB.setIcon(new ImageIcon(MemberPrimaryScreenPanel_하은.class.getResource("/com/itwill/tmr_house/member/images/home.png")));
		primaryScreenCenterPanel.add(houseImageLB);
		
		JButton memberJoinBtn = new JButton("회원가입 바로가기");
		memberJoinBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		memberJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(TmrHouseMainFrame.PANEL_MEMBER_JOIN_SCREEN);
			}
		});
		memberJoinBtn.setBounds(50, 462, 400, 45);
		memberJoinBtn.setBorderPainted(false);
		memberJoinBtn.setFont(new Font("D2Coding", Font.PLAIN, 30));
		memberJoinBtn.setForeground(new Color(255, 255, 255));
		memberJoinBtn.setBackground(new Color(64, 184, 255));
		primaryScreenCenterPanel.add(memberJoinBtn);
		
		JButton loginBtn = new JButton("로그인 바로가기");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(TmrHouseMainFrame.PANEL_MEMBER_LOGIN_SCREEN);
			}
		});
		loginBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginBtn.setBounds(50, 527, 400, 45);
		loginBtn.setFont(new Font("D2Coding", Font.PLAIN, 30));
		loginBtn.setBackground(new Color(255, 255, 255));
		loginBtn.setBorderPainted(false);
		primaryScreenCenterPanel.add(loginBtn);
		


	}

}
