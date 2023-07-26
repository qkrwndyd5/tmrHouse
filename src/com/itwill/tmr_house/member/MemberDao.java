package com.itwill.tmr_house.member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.tmr_house.common.DataSource;

public class MemberDao {
private DataSource dataSource;
	
	public MemberDao() throws Exception {
		dataSource = new DataSource();
	}
	
	public int memberInsert(Member member) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_INSERT);
		pstmt.setString(1, member.getM_id());
		pstmt.setString(2, member.getM_pw());
		pstmt.setString(3, member.getM_name());
		pstmt.setString(4, member.getM_birth());
		pstmt.setString(5, member.getM_phone());
		pstmt.setString(6, member.getM_address());
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public int memberUpdate(Member m) throws Exception {
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
	
	public int memberDelete(String m_id) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_DELETE);
		pstmt.setString(1, m_id);
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public Member findByID(String id) throws Exception {
		Member findMember = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_SELECTED_BY_ID);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String i = rs.getString("m_id");
			String pw = rs.getString("m_pw");
			String name = rs.getString("m_name");
			String birth = rs.getString("m_birth");
			String phone = rs.getString("m_phone");
			String address = rs.getString("m_address");
			findMember = new Member(i, pw, name, birth, phone, address);
		} else {
			
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return findMember;
	}
	
	public List<Member> findAll() throws Exception{
		List<Member> memberList = new ArrayList<Member>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_SELECTED_BY_ALL);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("m_id");
			String pw = rs.getString("m_pw");
			String name = rs.getString("m_name");
			String birth = rs.getString("m_birth");
			String phone = rs.getString("m_phone");
			String address = rs.getString("m_address");
			
			Member findMember = new Member(id,pw,name,birth,phone,address);
			memberList.add(findMember);
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return memberList;
	}

}
