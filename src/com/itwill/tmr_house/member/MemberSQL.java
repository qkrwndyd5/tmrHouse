package com.itwill.tmr_house.member;

public class MemberSQL {
	public static final String MEMBER_INSERT = "insert into member(m_id, m_pw, m_name, m_birth, m_phone, m_address) values(?,?,?,?,?,?)";
	public static final String MEMBER_UPDATE = "update member set m_pw = ?, m_name = ?, m_birth = ?, m_phone = ?, m_address = ? where m_id = ?";
	public static final String MEMBER_DELETE = "delete from member where m_id = ?";
	public static final String MEMBER_SELECTED_BY_ID = "select m_id, m_pw, m_name, m_birth, m_phone, m_address from member where m_id = ?";
	public static final String MEMBER_SELECTED_BY_ALL = "select m_id, m_pw, m_name, m_birth, m_phone, m_address from member";
	
}
