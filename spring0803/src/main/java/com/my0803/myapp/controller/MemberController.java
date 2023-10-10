package com.my0803.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my0803.myapp.domain.MemberVo;
import com.my0803.myapp.service.MemberService;

@Controller // ��Ʈ�ѷ� �뵵�� ��ü���� ��û
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	MemberService ms;
	// �������̽��� �����ϰ� �����Ѵ�.

	@RequestMapping(value = "/memberJoin.do")
	public String memberJoin() {

		return "/member/memberJoin";
	}

	@RequestMapping(value = "/memberJoinAction.do")
	public String memberJoinAction(MemberVo mv) { // input ��ü���� ���� ���ε��Ѵ�.

		String birth = mv.getMemberYear() + mv.getMemberMonth() + mv.getMemberDay();
		mv.setMemberBirth(birth);

		// ó���ϴ� �Է� ����
		int value = ms.memberInsert(mv);

		return "redirect:/"; // ���������� �ƴ� sendRedirect���
	}

	@RequestMapping(value = "/memberLogin.do")
	public String memberLogin() {

		return "/member/memberLogin";
	}

	@RequestMapping(value = "/memberLoginAction.do")
	public String memberLoginAction(
			@RequestParam("memberId") String memberId, 
			@RequestParam("memberPwd") String memberPwd) {

		MemberVo mv = ms.memberLogin(memberId, memberPwd);
		
		if(mv!=null) {
			return "redirect:/";
		}else {
			return "/member/memberLogin";
		}
		
		
	}

}
