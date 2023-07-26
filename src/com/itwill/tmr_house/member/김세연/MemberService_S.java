package com.itwill.tmr_house.member.김세연;

import com.itwill.tmr_house.member.Member;
import com.itwill.tmr_house.member.MemberDao;

public class MemberService_S {
	private MemberDao memberDao;
	public MemberService_S() throws Exception {
		memberDao = new MemberDao();
	}
	/*
	 * 회원가입 아이디가 중복되는 경우 메시지
		 * 아이디 존재여부 체크
		 * 	- 아이디 존재하면 메시지
		 *  - 아이디 존재하지 않으면 가입성공
		 */
	
	/*
	 * 옵션
	 * 아이디 존재여부 체크
	 * 	- 아이디(소문자+숫자 & 4~10자 이내)조합으로 되어있는 아이디인지
	 * 		> 맞다면 아이디 존재하는지 체크
	 * 			> 아이디가 존재하면 메시지 / 존재하지 않으면 가입성공
	 * - 아이디(소문자+숫자 & 4~10자 이내)) 조합으로 되어있지 않다면 
	 * 	 올바른 아이디 형태가 아닙니다 메시지 
	 */
	
	
	/*
	 * 회원 로그인
	 * 	0 : 아이디 존재안함
	 * 	1 : 패스워드 불일치
	 * 	2 : 로그인 성공
	 */
	public int login(String m_id, String m_pw) throws Exception {
		int isSuccess = -999;
		//Member findMember = memberDao.findByID(m_id);
		if (memberDao.findByID(m_id) == null) {
			isSuccess = 0;
		} else {
			if (memberDao.findByID(m_id).getM_pw().equals(m_pw)) {
				isSuccess = 2;
			}else {
				isSuccess = 1;
			}
		}
		return isSuccess;
	}
	
	/*
	 * 로그인한 회원의 정보보기
	 */
	public Member memberDetail(String m_id) throws Exception {
		return memberDao.findByID(m_id);
	}

	/*
	 * 회원수정
	 */
	public int memberUpdate(Member member) throws Exception {
		return memberDao.memberUpdate(member);
	}
	
	/*
	 * 아이디중복체크
	public boolean isDuplicatedId(Member member) throws Exception {
		if (memberDao.findByID(member.getM_id()) != null) {
			return true;
		} else {
			return false;
		}
	}
	 */

	/*
	 * 회원탈퇴
	 */
	public int delete(String m_id) throws Exception {
		return memberDao.memberDelete(m_id);
	}

}