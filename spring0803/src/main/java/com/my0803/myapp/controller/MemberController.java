package com.my0803.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //��Ʈ�ѷ� �뵵�� ��ü���� ��û
public class MemberController {
	
	@RequestMapping(value="/member/memberJoin.do")
	public String memberJoin() {
		
		return "/member/memberJoin";
	}
	
}
