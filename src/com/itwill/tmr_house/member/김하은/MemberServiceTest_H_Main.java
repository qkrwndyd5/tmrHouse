package com.itwill.tmr_house.member.김하은;

import com.itwill.tmr_house.member.Member;

public class MemberServiceTest_H_Main {

	public static void main(String[] args) throws Exception {
		MemberService_H memberService = new MemberService_H();
		/*
		 * 회원가입
		 */
		System.out.println("회원가입");
		String msg = memberService.addMember(new Member("zzzz","zzzz","흰둥이","720926","3452-5444","떡잎유치원"));
		System.out.println(msg);
		msg = memberService.addMember(new Member("qqqq","qqqq","초롱이","220405","1234-2321","외계인"));
		System.out.println(msg);
		/*
		 * 아이디 생성조건(숫자,소문자만 가능 & 길이 4글자 이상 10글자이내) 있는 회원가입
		 */
		System.out.println("아이디 생성조건 있는 회원가입");
		msg = memberService.addMemberDetail(new Member("zzzz", "zzzz", "원장님", "720926", "3452-5444", "떡잎유치원"));
		System.out.println(msg);
		// 아이디에 대문자가 섞여있는 경우
		System.out.println("--아이디에 대문자가 섞여있는 경우--");
		msg = memberService.addMemberDetail(new Member("AADs", "AADS", "원장님", "720926", "3452-5444", "떡잎유치원"));
		System.out.println(msg);
		System.out.println();
		// 아이디에 특수문자가 섞여있는 경우
		System.out.println("--아이디에 특수문자가 섞여있는 경우--");
		msg = memberService.addMemberDetail(new Member("123@#", "123@#", "원장님", "720926", "3452-5444", "떡잎유치원"));
		System.out.println(msg);
		System.out.println();
		// 아이디의 길이가 4글자 미만인경우
		System.out.println("--아이디의 길이가 4글자 미만인경우--");
		msg = memberService.addMemberDetail(new Member("hhh", "hhh", "원장님", "720926", "3452-5444", "떡잎유치원"));
		System.out.println(msg);
		System.out.println();
		// 아이디의 길이가 10글자 초과인경우
		System.out.println("--아이디의 길이가 10글자 초과인경우--");
		msg = memberService.addMemberDetail(new Member("hhhhhhhhhhh", "hhh", "원장님", "720926", "3452-5444", "떡잎유치원"));
		System.out.println(msg);
		System.out.println();
		// 정상적인 경우
		System.out.println("--정상적인 경우--");
		msg = memberService.addMemberDetail(new Member("hhhh", "hhhh", "원장님", "720926", "3452-5444", "떡잎유치원"));
		System.out.println(msg);

		/*
		 * 회원정보수정
		 */ 
		int rowCount = memberService.memberUpdate(new Member("hhhh", "hhhh", "원장님부인", "720926", "3452-5444", "떡잎유치원"));
		System.out.println(">>" + rowCount + "행이 수정되었습니다");
		
		/*
		 * 회원탈퇴
		 */ 
		rowCount = memberService.memerDelete("hhhh");
		System.out.println(">>" + rowCount + "명이 탈퇴하였습니다");
		
	    /*
		 * 회원정보 상세보기
		 */ 
		System.out.println(memberService.memberDetail("qqqq"));
		
		}

}
