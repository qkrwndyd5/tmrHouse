package com.itwill.tmr_house.member.김하은;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.tmr_house.common.DataSource;
import com.itwill.tmr_house.member.Member;
import com.itwill.tmr_house.member.MemberSQL;

public class MemberDao_H {
	private DataSource dataSource;
	
	
	public MemberDao_H() throws Exception {
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
	
	public int memberDelete(String m_id) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_UPDATE);
		pstmt.setString(1, m_id);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
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
