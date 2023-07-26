package com.itwill.tmr_house.member;
/*
 이름        널?       유형            
--------- -------- ------------- 
M_ID      NOT NULL VARCHAR2(50)  
M_PW               VARCHAR2(100) 
M_NAME             VARCHAR2(100) 
M_BIRTH            VARCHAR2(100) 
M_PHONE            VARCHAR2(100) 
M_ADDRESS          VARCHAR2(200) 
 */
public class Member {
	
	private String m_id;		// 회원아이디
	private String m_pw;		// 회원비밀번호
	private String m_name;		// 회원이름
	private String m_birth;		// 회원생년월일
	private String m_phone;		// 회원핸드폰번호
	private String m_address;	// 회원주소
	
	
	public Member() {

	}


	public Member(String m_id, String m_pw, String m_name, String m_birth, String m_phone, String m_address) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_birth = m_birth;
		this.m_phone = m_phone;
		this.m_address = m_address;
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	public String getM_pw() {
		return m_pw;
	}


	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}


	public String getM_name() {
		return m_name;
	}


	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	public String getM_birth() {
		return m_birth;
	}


	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}


	public String getM_phone() {
		return m_phone;
	}


	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}


	public String getM_address() {
		return m_address;
	}


	public void setM_address(String m_address) {
		this.m_address = m_address;
	}


	@Override
	public String toString() {
		return "Member [m_id=" + m_id + ", m_pw=" + m_pw + ", m_name=" + m_name + ", m_birth=" + m_birth + ", m_phone="
				+ m_phone + ", m_address=" + m_address + "]\n";
	}
	
	
}
