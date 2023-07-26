package com.itwill.tmr_house.member.김세연;

import com.itwill.tmr_house.member.Member;

public class MemberServiceTestMain_S {

	public static void main(String[] args) throws Exception {
		MemberService_S memberService = new MemberService_S();
		/*
		 * 회원 로그인
		 * 	0 : 아이디 존재안함
		 * 	1 : 패스워드 불일치
		 * 	2 : 로그인 성공
		 */
		System.out.println("----- login test -----");
		System.out.println(">> " + memberService.login("aaaa", "aaaa"));
		System.out.println(">> " + memberService.login("bbbb", "aaaa"));
		System.out.println(">> " + memberService.login("empty", "aaaa"));
		
		/*System.out.println("---- 회원 정보 조회 ----");
		System.out.println(memberService.memberDetail("bbbb"));
		
		System.out.println("---- 회원 정보 수정 ----");
		System.out.println("수정 전 : " + memberService.memberDetail("aaaa"));
		int rowCount = memberService.memberUpdate(new Member("aaaa", "aaaa", "유리", "991212", "12345", "떡잎마을"));
		System.out.println(">> " + rowCount  + "행 수정 완료");
		System.out.println("수정 후 : " + memberService.memberDetail("aaaa"));
		
		System.out.println("--- 회원탈퇴 ---");
		rowCount = memberService.delete("aaaa");
		System.out.println(">> " + rowCount  + "행 삭제 완료");
		*/
	}
}
