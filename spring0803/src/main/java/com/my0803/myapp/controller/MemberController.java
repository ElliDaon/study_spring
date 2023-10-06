package com.my0803.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my0803.myapp.domain.MemberVo;
import com.my0803.myapp.service.MemberService;


@Controller //컨트롤러 용도의 객체생성 요청
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	MemberService ms;
	//인터페이스를 지정하고 주입한다.
	
	@RequestMapping(value="/memberJoin.do")
	public String memberJoin() {
		
		return "/member/memberJoin";
	}
	
	@RequestMapping(value="/memberJoinAction.do")
	public String memberJoinAction(MemberVo mv) { //input 객체들의 값을 바인딩한다.
		
		//처리하는 입력 로직
		int value = ms.memberInsert(mv);
		
		return "redirect:/"; //포워드방식이 아닌 sendRedirect방식
	}
	
	@RequestMapping(value="/memberLogin.do")
	public String memberLogin() {
		
		return "/member/memberLogin";
	}
	
}
