package com.itwill.tmr_house.member.김세연;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itwill.tmr_house.common.DataSource;
import com.itwill.tmr_house.member.Member;
import com.itwill.tmr_house.member.MemberSQL;

public class MemberDao_S {	
	
	private DataSource dataSource;
	public MemberDao_S() throws Exception {
		dataSource = new DataSource();
	}
	
	public int updateMember(Member m) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_UPDATE);
		pstmt.setString(1, m.getM_pw());
		pstmt.setString(2, m.getM_name());
		pstmt.setString(3, m.getM_birth());
		pstmt.setString(4, m.getM_phone());
		pstmt.setString(5, m.getM_address());
		pstmt.setString(6, m.getM_id());
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	public Member findByID(String id) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_SELECTED_BY_ID);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		Member findMember = null;
		if (rs.next()) {
			String i = rs.getString("m_id");
			String pw = rs.getString("m_pw");
			String name = rs.getString("m_name");
			String birth = rs.getString("m_birth");
			String phone = rs.getString("m_phone");
			String address = rs.getString("m_address");
			findMember = new Member(i, pw, name, birth, phone, address);
		} else {
			System.out.println("회원을 찾을 수 없습니다.");
		}
		
		pstmt.close();
		dataSource.close(con);
		
		return findMember;
	}
	
}