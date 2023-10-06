package com.my0803.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my0803.myapp.domain.MemberVo;

@Controller //��Ʈ�ѷ� �뵵�� ��ü���� ��û
@RequestMapping(value="/member")
public class MemberController {
	
	@RequestMapping(value="/memberJoin.do")
	public String memberJoin() {
		
		return "/member/memberJoin";
	}
	
	@RequestMapping(value="/memberJoinAction.do")
	public String memberJoinAction(MemberVo mv) { //input ��ü���� ���� ���ε��Ѵ�.
		
		//ó���ϴ� �Է� ����
		
		
		return "redirect:/index.jsp"; //���������� �ƴ� sendRedirect���
	}
	
	@RequestMapping(value="/memberLogin.do")
	public String memberLogin() {
		
		return "/member/memberLogin";
	}
	
}
