package com.my0803.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //컨트롤러 용도의 객체생성 요청
public class MemberController {
	
	@RequestMapping(value="/member/memberJoin.do")
	public String memberJoin() {
		
		return "/member/memberJoin";
	}
	
}
