package com.itwill.tmr_house.member.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;

import com.itwill.tmr_house.member.Member;
import com.itwill.tmr_house.member.MemberService;
import com.itwill.tmr_house.order.*;
import com.itwill.tmr_house.order.ui.김하은.*;
import com.itwill.tmr_house.ui.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MemberMyPageScreenPanel_하은 extends JPanel {
	
	/********메인프레임 참조********/
	TmrHouseMainFrame frame;
	

	private JTextField modifyIdTF;
	private JPasswordField modifyPasswordField;
	private JPasswordField modifyPasswordCorrectField;
	private JTextField modifyNameTF;
	private JTextField modifyPhoneNumberTF;
	private JTextField modifyAddressTF;
	
	private MemberService memberService;
	private JTextField modifyBirthTF;
	private JLabel modifyPwCorrectLB;
	
	/*********추가********/
	OrdersDetailPanel_하은2 ordersDetailPanel_하은2;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberMyPageScreenPanel_하은() throws Exception {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					displayMemberInfo(frame.loginMember);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JPanel memberMyPageNorthPanel = new JPanel();
		memberMyPageNorthPanel.setBackground(new Color(255, 255, 255));
		add(memberMyPageNorthPanel, BorderLayout.NORTH);
		
		JLabel memberMyPageAppTitleLB = new JLabel("Tommorow's House");
		memberMyPageAppTitleLB.setFont(new Font("D2Coding", Font.BOLD, 20));
		memberMyPageNorthPanel.add(memberMyPageAppTitleLB);
		
		JPanel memberMyPageCenterPanel = new JPanel();
		memberMyPageCenterPanel.setBackground(new Color(255, 255, 255));
		add(memberMyPageCenterPanel, BorderLayout.CENTER);
		memberMyPageCenterPanel.setLayout(null);
		
		JLabel idLB = new JLabel("아이디");
		idLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		idLB.setBounds(54, 130, 152, 18);
		memberMyPageCenterPanel.add(idLB);
		
		JLabel pwLB = new JLabel("비밀번호");
		pwLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		pwLB.setBounds(54, 178, 152, 24);
		memberMyPageCenterPanel.add(pwLB);
		
		JLabel pwCorrectLB = new JLabel("비밀번호확인");
		pwCorrectLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		pwCorrectLB.setBounds(54, 232, 152, 37);
		memberMyPageCenterPanel.add(pwCorrectLB);
		
		JLabel name = new JLabel("이름");
		name.setFont(new Font("D2Coding", Font.PLAIN, 17));
		name.setBounds(54, 345, 152, 37);
		memberMyPageCenterPanel.add(name);
		
		JLabel phoneNumberLB = new JLabel("핸드폰 번호");
		phoneNumberLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		phoneNumberLB.setBounds(54, 410, 152, 24);
		memberMyPageCenterPanel.add(phoneNumberLB);
		
		JLabel addressLB = new JLabel("주소");
		addressLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		addressLB.setBounds(54, 475, 152, 18);
		memberMyPageCenterPanel.add(addressLB);
		
		modifyIdTF = new JTextField();
		modifyIdTF.setEnabled(false);
		modifyIdTF.setFont(new Font("D2Coding", Font.PLAIN, 17));
		modifyIdTF.setColumns(10);
		modifyIdTF.setBounds(253, 130, 205, 21);
		memberMyPageCenterPanel.add(modifyIdTF);
		
		modifyPasswordField = new JPasswordField();
		modifyPasswordField.setFont(new Font("D2Coding", Font.PLAIN, 17));
		modifyPasswordField.setBounds(253, 180, 205, 21);
		memberMyPageCenterPanel.add(modifyPasswordField);
		
		modifyPasswordCorrectField = new JPasswordField();
		modifyPasswordCorrectField.setFont(new Font("D2Coding", Font.PLAIN, 17));
		modifyPasswordCorrectField.setBounds(253, 241, 205, 21);
		memberMyPageCenterPanel.add(modifyPasswordCorrectField);
		
		modifyNameTF = new JTextField();
		modifyNameTF.setEnabled(false);
		modifyNameTF.setFont(new Font("D2Coding", Font.PLAIN, 17));
		modifyNameTF.setColumns(10);
		modifyNameTF.setBounds(253, 353, 205, 21);
		memberMyPageCenterPanel.add(modifyNameTF);
		
		modifyPhoneNumberTF = new JTextField();
		modifyPhoneNumberTF.setFont(new Font("D2Coding", Font.PLAIN, 17));
		modifyPhoneNumberTF.setColumns(11);
		modifyPhoneNumberTF.setBounds(253, 412, 205, 21);
		memberMyPageCenterPanel.add(modifyPhoneNumberTF);
		
		modifyAddressTF = new JTextField();
		modifyAddressTF.setFont(new Font("D2Coding", Font.PLAIN, 17));
		modifyAddressTF.setColumns(20);
		modifyAddressTF.setBounds(253, 474, 205, 21);
		memberMyPageCenterPanel.add(modifyAddressTF);
		
		JLabel lblNewLabel = new JLabel("회원정보 수정");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblNewLabel.setBounds(140, 26, 218, 37);
		memberMyPageCenterPanel.add(lblNewLabel);
		
		JButton modifyBtn = new JButton("저장");
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateMemberMyPage();
			}
		});
		modifyBtn.setForeground(Color.WHITE);
		modifyBtn.setFont(new Font("D2Coding", Font.PLAIN, 17));
		modifyBtn.setBorderPainted(false);
		modifyBtn.setBackground(new Color(64, 184, 255));
		modifyBtn.setBounds(95, 535, 97, 37);
		memberMyPageCenterPanel.add(modifyBtn);
		
		JButton cancelBtn = new JButton("취소");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 원래 로그인 정보 기입
				try {
					displayMemberInfo(frame.loginMember);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_LIST_PANEL);
			}
		});
		cancelBtn.setFont(new Font("D2Coding", Font.PLAIN, 17));
		cancelBtn.setBorderPainted(false);
		cancelBtn.setBackground(Color.WHITE);
		cancelBtn.setBounds(316, 535, 97, 37);
		memberMyPageCenterPanel.add(cancelBtn);
		
		JLabel modifyBirthLB = new JLabel("생년월일");
		modifyBirthLB.setFont(new Font("D2Coding", Font.PLAIN, 17));
		modifyBirthLB.setBounds(54, 295, 152, 29);
		memberMyPageCenterPanel.add(modifyBirthLB);
		
		modifyBirthTF = new JTextField();
		modifyBirthTF.setFont(new Font("D2Coding", Font.PLAIN, 17));
		modifyBirthTF.setBounds(253, 299, 205, 21);
		memberMyPageCenterPanel.add(modifyBirthTF);
		modifyBirthTF.setColumns(10);
		
		modifyPwCorrectLB = new JLabel("");
		modifyPwCorrectLB.setHorizontalAlignment(SwingConstants.CENTER);
		modifyPwCorrectLB.setBackground(new Color(255, 255, 255));
		modifyPwCorrectLB.setForeground(new Color(255, 0, 0));
		modifyPwCorrectLB.setFont(new Font("D2Coding", Font.PLAIN, 12));
		modifyPwCorrectLB.setBounds(219, 274, 239, 15);
		memberMyPageCenterPanel.add(modifyPwCorrectLB);
		
		JLabel lblNewLabel_1 = new JLabel("주문내역보기");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.changePanel(TmrHouseMainFrame.PANEL_ORDERS_DETAIL_하은);
				
			}
		});
		lblNewLabel_1.setFont(new Font("D2Coding", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(354, 81, 118, 24);
		memberMyPageCenterPanel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.changePanel(TmrHouseMainFrame.PANEL_PRODUCT_LIST_PANEL);
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(MemberMyPageScreenPanel_하은.class.getResource("/com/itwill/tmr_house/member/images/home(30x30).png")));
		btnNewButton.setBounds(194, 619, 97, 37);
		memberMyPageCenterPanel.add(btnNewButton);
		
		memberService = new MemberService();
	}
	
	public void setFrame(TmrHouseMainFrame frame) {
		this.frame = frame;
	}
	
	public void displayMemberInfo(Member member) throws Exception {
		
			modifyIdTF.setText(member.getM_id());
			modifyPasswordField.setText(member.getM_pw());
			modifyBirthTF.setText(member.getM_birth());
			modifyNameTF.setText(member.getM_name());
			modifyPhoneNumberTF.setText(member.getM_phone());
			modifyAddressTF.setText(member.getM_address());
		}
	
	public void updateMemberMyPage() {
		try {
			String id = modifyIdTF.getText();
			String password = new String(modifyPasswordField.getPassword());
			String passwordCorrect = new String(modifyPasswordCorrectField.getPassword());
			String name = modifyNameTF.getText();
			String birth = modifyBirthTF.getText();
			String phoneNumber = modifyPhoneNumberTF.getText();
			String address = modifyAddressTF.getText();
			
			if(password.equals(passwordCorrect)) {
				Member updateMember = new Member(id,password,name,birth,phoneNumber,address);
				memberService.memberUpdate(updateMember);
				frame.loginMember = memberService.memberDetail(id);
				JOptionPane.showMessageDialog(null, "저장되었습니다.");
				} else  {
					modifyPwCorrectLB.setText("입력하신 비밀번호와 일치하지 않습니다.");
					modifyPasswordCorrectField.requestFocus();
					frame.loginMember = memberService.memberDetail(id);
					return;
					}
		}catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
	
}
