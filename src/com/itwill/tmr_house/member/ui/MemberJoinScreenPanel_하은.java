package com.itwill.tmr_house.member.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itwill.tmr_house.member.Member;
import com.itwill.tmr_house.member.MemberService;
import com.itwill.tmr_house.ui.*;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberJoinScreenPanel_하은 extends JPanel {
	/****************MemberService 멤버필드 선언 ***********************/
	private MemberService memberService;
	
	/********메인프레임 참조********/
	TmrHouseMainFrame frame;
	
	
	private JTextField joinIdTF;
	private JTextField joinNameTF;
	private JTextField joinPhoneNumberTF;
	private JTextField joinAddressTF;
	private JPasswordField joinPasswordField;
	private JPasswordField joinPasswordCorrectField;
	private JButton joinBtn;
	private JButton joinCancelBtn;
	private JLabel joinIdMsgLB;
	private JLabel joinPwCorrectMsgLB;
	private JLabel joinBirthLB;
	private JTextField joinBirthTF;

	public void setFrame(TmrHouseMainFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberJoinScreenPanel_하은() throws Exception {
		setLayout(new BorderLayout(0, 0));
		
		JPanel memberJoinNorthPanel = new JPanel();
		memberJoinNorthPanel.setBackground(new Color(255, 255, 255));
		add(memberJoinNorthPanel, BorderLayout.NORTH);
		
		JTextPane memberJoinAppTitleTextPane = new JTextPane();
		memberJoinAppTitleTextPane.setFont(new Font("D2Coding", Font.BOLD, 20));
		memberJoinAppTitleTextPane.setText("Tomorrow's House");
		memberJoinNorthPanel.add(memberJoinAppTitleTextPane);
		
		JPanel memberJoinCenterPanel = new JPanel();
		memberJoinCenterPanel.setBackground(new Color(255, 255, 255));
		add(memberJoinCenterPanel, BorderLayout.CENTER);
		memberJoinCenterPanel.setLayout(null);
		
		JLabel idLB = new JLabel("아이디");
		idLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		idLB.setBounds(47, 147, 152, 18);
		memberJoinCenterPanel.add(idLB);
		
		JLabel pwLB = new JLabel("비밀번호");
		pwLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		pwLB.setBounds(47, 203, 152, 24);
		memberJoinCenterPanel.add(pwLB);
		
		JLabel pwCorrectLB = new JLabel("비밀번호확인");
		pwCorrectLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		pwCorrectLB.setBounds(47, 251, 152, 37);
		memberJoinCenterPanel.add(pwCorrectLB);
		
		JLabel name = new JLabel("이름");
		name.setFont(new Font("D2Coding", Font.PLAIN, 17));
		name.setBounds(47, 357, 152, 37);
		memberJoinCenterPanel.add(name);
		
		JLabel phoneNumberLB = new JLabel("핸드폰 번호");
		phoneNumberLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		phoneNumberLB.setBounds(47, 422, 152, 24);
		memberJoinCenterPanel.add(phoneNumberLB);
		
		JLabel addressLB = new JLabel("주소");
		addressLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		addressLB.setBounds(47, 488, 152, 18);
		memberJoinCenterPanel.add(addressLB);
		
		joinBtn = new JButton("가입");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********회원가입**********/
				checkJoinId();
			}
		});
		joinBtn.setForeground(new Color(255, 255, 255));
		joinBtn.setBorderPainted(false);
		joinBtn.setBackground(new Color(64, 184, 255));
		joinBtn.setFont(new Font("D2Coding", Font.PLAIN, 17));
		joinBtn.setBounds(102, 537, 97, 37);
		memberJoinCenterPanel.add(joinBtn);
		
		joinCancelBtn = new JButton("취소");
		joinCancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 초기화면으로 전환
				frame.changePanel(TmrHouseMainFrame.PANEL_MEMBER_PRIMARY_SCREEN);
			}
		});
		joinCancelBtn.setBorderPainted(false);
		joinCancelBtn.setBackground(new Color(255, 255, 255));
		joinCancelBtn.setFont(new Font("D2Coding", Font.PLAIN, 17));
		joinCancelBtn.setBounds(323, 537, 97, 37);
		memberJoinCenterPanel.add(joinCancelBtn);
		
		joinIdTF = new JTextField();
		joinIdTF.setFont(new Font("D2Coding", Font.PLAIN, 17));
		joinIdTF.setBounds(236, 147, 205, 21);
		memberJoinCenterPanel.add(joinIdTF);
		joinIdTF.setColumns(10);
		
		joinNameTF = new JTextField();
		joinNameTF.setFont(new Font("D2Coding", Font.PLAIN, 17));
		joinNameTF.setBounds(236, 366, 205, 21);
		memberJoinCenterPanel.add(joinNameTF);
		joinNameTF.setColumns(10);
		
		joinPhoneNumberTF = new JTextField();
		joinPhoneNumberTF.setFont(new Font("D2Coding", Font.PLAIN, 17));
		joinPhoneNumberTF.setBounds(236, 425, 205, 21);
		memberJoinCenterPanel.add(joinPhoneNumberTF);
		joinPhoneNumberTF.setColumns(11);
		
		joinAddressTF = new JTextField();
		joinAddressTF.setFont(new Font("D2Coding", Font.PLAIN, 17));
		joinAddressTF.setBounds(236, 488, 205, 21);
		memberJoinCenterPanel.add(joinAddressTF);
		joinAddressTF.setColumns(20);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblNewLabel.setBounds(102, 54, 269, 37);
		memberJoinCenterPanel.add(lblNewLabel);
		
		joinPasswordField = new JPasswordField();
		joinPasswordField.setFont(new Font("D2Coding", Font.PLAIN, 17));
		joinPasswordField.setBounds(236, 206, 205, 21);
		memberJoinCenterPanel.add(joinPasswordField);
		
		joinPasswordCorrectField = new JPasswordField();
		joinPasswordCorrectField.setFont(new Font("D2Coding", Font.PLAIN, 17));
		joinPasswordCorrectField.setBounds(236, 260, 205, 21);
		memberJoinCenterPanel.add(joinPasswordCorrectField);
		
		joinIdMsgLB = new JLabel("");
		joinIdMsgLB.setFont(new Font("D2Coding", Font.PLAIN, 12));
		joinIdMsgLB.setForeground(new Color(255, 0, 0));
		joinIdMsgLB.setBounds(236, 167, 205, 29);
		memberJoinCenterPanel.add(joinIdMsgLB);
		
		joinPwCorrectMsgLB = new JLabel("");
		joinPwCorrectMsgLB.setHorizontalAlignment(SwingConstants.CENTER);
		joinPwCorrectMsgLB.setForeground(Color.RED);
		joinPwCorrectMsgLB.setFont(new Font("D2Coding", Font.PLAIN, 12));
		joinPwCorrectMsgLB.setBounds(205, 279, 269, 29);
		memberJoinCenterPanel.add(joinPwCorrectMsgLB);
		
		joinBirthLB = new JLabel("생년월일");
		joinBirthLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		joinBirthLB.setBounds(47, 298, 152, 37);
		memberJoinCenterPanel.add(joinBirthLB);
		
		joinBirthTF = new JTextField();
		joinBirthTF.setFont(new Font("D2Coding", Font.PLAIN, 17));
		joinBirthTF.setBounds(236, 307, 205, 21);
		memberJoinCenterPanel.add(joinBirthTF);
		joinBirthTF.setColumns(10);
		
	
		/*****************멤버필드 객체생성******************/
		memberService = new MemberService();
		
		}
	
	public void checkJoinId() {
		try {
			String id = joinIdTF.getText();
			String password = new String(joinPasswordField.getPassword());
			String passwordCorrect = new String(joinPasswordCorrectField.getPassword());
			String name = joinNameTF.getText();
			String birth = joinBirthTF.getText();
			String phoneNumber = joinPhoneNumberTF.getText();
			String address = joinAddressTF.getText();
			/************유효성 체크***********/
			
			if(id.equals("")) {
				joinIdMsgLB.setText("아이디를 입력하세요.");
				joinIdTF.requestFocus();
				return;
			}
			if(password.equals(passwordCorrect)) {
				Member newMember = new Member (id,password,name,birth,phoneNumber,address);
				String memberAdd = memberService.addMemberDetail(newMember);
				if(memberAdd.equals("가입성공")) {
					// 로그인 화면 전환
					frame.changePanel(TmrHouseMainFrame.PANEL_MEMBER_LOGIN_SCREEN);
				}else if(memberAdd.equals("중복된아이디입니다.")) {
					joinIdMsgLB.setText("중복된 아이디 입니다.");
					joinIdTF.requestFocus();
					return;
				}else {
					JOptionPane.showMessageDialog(null, "올바르지 않은 아이디형식입니다.");
					joinIdTF.requestFocus();
					return;
				}
			}else {
				joinPwCorrectMsgLB.setText("입력하신 비밀번호와 일치하지 않습니다.");
				joinPasswordCorrectField.requestFocus();
				}
			} catch (Exception e1) {
				System.out.println("회원가입 -->" +e1.getMessage());
			
			}
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

