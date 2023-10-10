package com.my0803.myapp.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my0803.myapp.domain.MemberVo;
import com.my0803.myapp.service.MemberService;

@Controller // 컨트롤러 용도의 객체생성 요청
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	MemberService ms;
	// 인터페이스를 지정하고 주입한다.

	@RequestMapping(value = "/memberJoin.do")
	public String memberJoin() {

		return "/member/memberJoin";
	}

	@RequestMapping(value = "/memberJoinAction.do")
	public String memberJoinAction(MemberVo mv) { // input 객체들의 값을 바인딩한다.

		String birth = mv.getMemberYear() + mv.getMemberMonth() + mv.getMemberDay();
		mv.setMemberBirth(birth);

		// 처리하는 입력 로직
		int value = ms.memberInsert(mv);

		return "redirect:/"; // 포워드방식이 아닌 sendRedirect방식
	}

	@RequestMapping(value = "/memberLogin.do")
	public String memberLogin() {

		return "/member/memberLogin";
	}

	@RequestMapping(value = "/memberLoginAction.do")
	public String memberLoginAction(
			@RequestParam("memberId") String memberId, 
			@RequestParam("memberPwd") String memberPwd,
			HttpSession session) {

		MemberVo mv = ms.memberLogin(memberId, memberPwd);
		
		if(mv!=null) {
			session.setAttribute("midx",mv.getMemberId());
			session.setAttribute("memberName", mv.getMemberName());
			return "redirect:/";
		}else {
			return "/member/memberLogin";
		}
	}
	
	@RequestMapping(value = "/memberLogout.do")
	public String memberLogout(HttpSession session) {
		session.removeAttribute("midx");
		session.removeAttribute("memberName");
		session.invalidate();
		return "redirect:/";
	}

}
