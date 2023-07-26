package com.itwill.tmr_house.member.test;

import com.itwill.tmr_house.member.Member;
import com.itwill.tmr_house.member.MemberDao;

public class MemberDaoTestMain {

	public static void main(String[] args) throws Exception {
		MemberDao memberDao = new MemberDao();
		System.out.println("회원 탈퇴");
		int rowCount = memberDao.memberDelete("aaaa");
		System.out.println(">> " + rowCount + "행이 삭제되었습니다");
		
		System.out.println("회원가입");
		Member newMember = new Member("zzzz", "zzzz", "흰둥이", "201212", "1234-0000", "짱구네");
		rowCount = memberDao.memberInsert(newMember);
		System.out.println(">> " + rowCount + "행이 삽입되었습니다");
		
		System.out.println("회원수정");
		rowCount = memberDao.memberUpdate(new Member("zzzz","zzzz","나미리","19860206","5555-6874","나미리집"));
		System.out.println(">> " + rowCount + "행이 수정되었습니다");
		
		System.out.println("아이디로 회원정보 찾기");
		System.out.println(memberDao.findByID("zzzz"));
		
		System.out.println("모든회원 리스트");
		System.out.println(memberDao.findAll());
		
	}

}
