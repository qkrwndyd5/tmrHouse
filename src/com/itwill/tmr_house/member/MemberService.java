package com.itwill.tmr_house.member;

public class MemberService {
private MemberDao memberDao;
	
	public MemberService() throws Exception {
		memberDao = new MemberDao();
	}
	
	/*
	 * 회원가입 아이디가 중복되는 경우 메시지
	 * 아이디 존재여부 체크
	 * 	- 아이디 존재하면 메시지
	 *  - 아이디 존재하지 않으면 가입성공
	*/
	
	private String addMember(Member member) throws Exception {
		String isSuccess = "";
		if(memberDao.findByID(member.getM_id())==null) {
			memberDao.memberInsert(member);
			isSuccess = "가입성공";
		}else {
			isSuccess = "중복된아이디입니다.";
		}
		return isSuccess;
	}
	
	/*
	 * 옵션
	 * 아이디 존재여부 체크
	 * 	- 아이디(소문자,숫자만 사용가능 & 4~10자 이내)조합으로 되어있는 아이디인지
	 * 		> 맞다면 아이디 존재하는지 체크
	 * 			> 아이디가 존재하면 메시지 / 존재하지 않으면 가입성공
	 * - 아이디(소문자,숫자만 사용가능 & 4~10자 이내)) 조합으로 되어있지 않다면 
	 * 	 올바른 아이디 형태가 아닙니다 메시지 
	 * 
	 */
	public String addMemberDetail(Member member) throws Exception {
		String isSuccess = "";
		char[] temp = member.getM_id().toCharArray();
		for(int i = 0; i < temp.length; i++) {
			if((temp.length >= 4  && temp.length <= 10) && ((temp[i] >= 'a' && temp[i] <= 'z' ) || (temp[i] >= '0' && temp[i] <= '9' )) ) {
				if(i == temp.length-1) {
					isSuccess = this.addMember(member);
					break;
				}
			}else {
				isSuccess = "올바르지 않은 아이디형식입니다.";
				break;
			}
		}
		return isSuccess;
	}
	
	
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
	 * 회원정보수정
	 */
	public int memberUpdate(Member member) throws Exception {
		return memberDao.memberUpdate(member);
	}
	/*
	 * 회원탈퇴
	 */
	public int memerDelete(String m_id) throws Exception {
		return memberDao.memberDelete(m_id);
	}
	/*
	 * 회원정보 상세보기
	 */
	public Member memberDetail(String m_id) throws Exception {
		return memberDao.findByID(m_id);
	}
}
