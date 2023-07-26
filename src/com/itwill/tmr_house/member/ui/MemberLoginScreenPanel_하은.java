package com.itwill.tmr_house.member.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.itwill.tmr_house.member.Member;
import com.itwill.tmr_house.member.MemberService;
import com.itwill.tmr_house.ui.*;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberLoginScreenPanel_하은 extends JPanel {
	
	/********메인프레임 참조********/
	TmrHouseMainFrame frame;
	
	private JTextField loginIdTF;
	private JPasswordField loginPasswordField;
	
	private MemberService memberService;
	
	
	public void setFrame(TmrHouseMainFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberLoginScreenPanel_하은() throws Exception {
		setLayout(new BorderLayout(0, 0));
		
		JPanel LoginScreenNorthAppTitlePanel = new JPanel();
		LoginScreenNorthAppTitlePanel.setBackground(new Color(255, 255, 255));
		add(LoginScreenNorthAppTitlePanel, BorderLayout.NORTH);
		
		JLabel loginScreenPanelAppTitleLB = new JLabel("Tommorow's House");
		loginScreenPanelAppTitleLB.setFont(new Font("D2Coding", Font.BOLD, 20));
		LoginScreenNorthAppTitlePanel.add(loginScreenPanelAppTitleLB);
		
		JPanel LoginScreenCenterAppTitlePanel = new JPanel();
		LoginScreenCenterAppTitlePanel.setBackground(new Color(255, 255, 255));
		add(LoginScreenCenterAppTitlePanel, BorderLayout.CENTER);
		LoginScreenCenterAppTitlePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("로그인");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblNewLabel.setBounds(165, 104, 165, 34);
		LoginScreenCenterAppTitlePanel.add(lblNewLabel);
		
		JLabel loginIdLB = new JLabel("아이디");
		loginIdLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		loginIdLB.setBackground(new Color(255, 255, 255));
		loginIdLB.setBounds(57, 264, 96, 24);
		LoginScreenCenterAppTitlePanel.add(loginIdLB);
		
		JLabel loginPwLB = new JLabel("비밀번호");
		loginPwLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		loginPwLB.setBackground(new Color(255, 255, 255));
		loginPwLB.setBounds(57, 330, 96, 24);
		LoginScreenCenterAppTitlePanel.add(loginPwLB);
		
		loginIdTF = new JTextField();
		loginIdTF.setFont(new Font("D2Coding", Font.PLAIN, 17));
		loginIdTF.setBounds(178, 267, 165, 21);
		LoginScreenCenterAppTitlePanel.add(loginIdTF);
		loginIdTF.setColumns(10);
		
		loginPasswordField = new JPasswordField();
		loginPasswordField.setFont(new Font("D2Coding", Font.PLAIN, 17));
		loginPasswordField.setBounds(178, 333, 165, 21);
		LoginScreenCenterAppTitlePanel.add(loginPasswordField);
		
		JButton loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginTest();
			}
		});
		loginBtn.setForeground(new Color(255, 255, 255));
		loginBtn.setBorderPainted(false);
		loginBtn.setFont(new Font("D2Coding", Font.PLAIN, 17));
		loginBtn.setBackground(new Color(64, 184, 255));
		loginBtn.setBounds(366, 264, 97, 90);
		LoginScreenCenterAppTitlePanel.add(loginBtn);
		
		JButton loginBacklBtn = new JButton("");
		loginBacklBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 초기화면으로 전환
				frame.changePanel(TmrHouseMainFrame.PANEL_MEMBER_PRIMARY_SCREEN);
			}
		});
		loginBacklBtn.setIcon(new ImageIcon(MemberLoginScreenPanel_하은.class.getResource("/com/itwill/tmr_house/member/images/left-arrow (1).png")));
		loginBacklBtn.setBorderPainted(false);
		loginBacklBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		loginBacklBtn.setBackground(new Color(255, 255, 255));
		loginBacklBtn.setBounds(12, 23, 68, 21);
		LoginScreenCenterAppTitlePanel.add(loginBacklBtn);
		
		/*****************멤버필드 객체생성******************/
		memberService = new MemberService();
		
		}
		

	/************로그인 유효성 검사**************/
	public void loginTest() {
		try {
			String id = loginIdTF.getText();
			String pw = new String(loginPasswordField.getPassword());
			int result = memberService.login(id, pw);
			/*
			 *  0 : 아이디 존재안함
			 * 	1 : 패스워드 불일치
			 * 	2 : 로그인 성공
			 */
			if(result == 2) {
				// 로그인 성공
				loginProcess(id);
				JOptionPane.showMessageDialog(null, "로그인 성공");
				loginIdTF.setText("");
				loginPasswordField.setText("");
				frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_LIST_PANEL);
			}else {
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다.");
				loginIdTF.setSelectionStart(0);
				loginIdTF.setSelectionEnd(id.length());
				loginIdTF.requestFocus();
			}
			
		}catch(Exception e1){
			System.out.println(e1.getMessage());
		}
	}
	/*******************로그인 성공 시 호출 할 메소드*****************/
	
	public void loginProcess(String id) throws Exception {
		// 1. 로그인 성공한 멤버객체 멤버필드에 저장
		frame.loginMember = memberService.memberDetail(id);
		
		// 2. 타이틀 변경 (변경 안함)
		// 3. 로그인화면 , 화면가입 불활성화 (x)
		
		// 4. 정보보기 화면
		
		// 5. 수정작업(x 다른패널)
		
	}
	
	
	
	
}
